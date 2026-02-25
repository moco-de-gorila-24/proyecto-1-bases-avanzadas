package negocioDAO;

import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IPedidoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements IPedidoDAO {

    private final IConexionBD conexionBD;

    public PedidoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarPedido(Pedidos pedido) throws PersistenciaException {
        String sqlPedido = "INSERT INTO Pedidos (estadoPedido, total, idCliente) VALUES (?, ?, ?)";
        String sqlDetalle = "INSERT INTO PedidoProducto (idPedido, idProducto, cantidad, notas, subtotal) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = conexionBD.crearConexion();
            conn.setAutoCommit(false);

            try (PreparedStatement psP = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                psP.setString(1, pedido.getEstadoPedido());
                psP.setFloat(2, pedido.getTotal());

                if (pedido.getCliente() != null) {
                    psP.setInt(3, pedido.getCliente().getIdCliente());
                } else {
                    psP.setNull(3, Types.INTEGER);
                }

                psP.executeUpdate();

                ResultSet rs = psP.getGeneratedKeys();
                if (rs.next()) {
                    pedido.setIdPedido(rs.getInt(1));
                }
            }

            try (PreparedStatement psD = conn.prepareStatement(sqlDetalle)) {
                for (Pedidos.DetallePedido detalle : pedido.getDetalles()) {
                    psD.setInt(1, pedido.getIdPedido());
                    psD.setInt(2, detalle.getProducto().getIdProducto());
                    psD.setInt(3, 1);
                    psD.setString(4, detalle.getNotaOpcional());
                    psD.setFloat(5, detalle.getProducto().getPrecio());
                    psD.addBatch();
                }
                psD.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new PersistenciaException("Error al guardar pedido: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void registrarEntregaConPago(int idPedido, String metodoPago, float monto) throws PersistenciaException {
        String sql = "{CALL sp_registrar_entrega_pago(?, ?, ?)}";

        try (Connection conn = conexionBD.crearConexion();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, idPedido);
            cs.setString(2, metodoPago);
            cs.setFloat(3, monto);

            cs.execute();
        } catch (SQLException e) {
            throw new PersistenciaException("Error en entrega: " + e.getMessage());
        }
    }

    @Override
    public List<Pedidos> buscarPedidosPorClienteYEstados(int idCliente, List<String> estados) throws PersistenciaException {
        List<Pedidos> lista = new ArrayList<>();

        String placeholders = String.join(",", java.util.Collections.nCopies(estados.size(), "?"));
        String sql = "SELECT * FROM Pedidos WHERE idCliente = ? AND estadoPedido IN (" + placeholders + ")";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            for (int i = 0; i < estados.size(); i++) {
                ps.setString(i + 2, estados.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pedidos p = new Pedidos();
                    p.setIdPedido(rs.getInt("idPedido"));
                    p.setEstadoPedido(rs.getString("estadoPedido"));
                    p.setTotal(rs.getFloat("total"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar pedidos activos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Pedidos obtenerPorId(int idPedido) throws PersistenciaException {
        return null;
    }

    @Override
    public List<Pedidos> buscarPedidos(String filtro) throws PersistenciaException {
        List<Pedidos> lista = new ArrayList<>();
        String sql = "SELECT p.* FROM Pedidos p " +
                "LEFT JOIN Clientes c ON p.idCliente = c.idCliente " +
                "LEFT JOIN Telefonos t ON c.idCliente = t.idCliente " +
                "WHERE p.idPedido LIKE ? OR c.nombre LIKE ? OR t.telefono LIKE ? " +
                "GROUP BY p.idPedido ORDER BY p.fechaHoraRegistro DESC";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String f = "%" + filtro + "%";
            ps.setString(1, f);
            ps.setString(2, f);
            ps.setString(3, f);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedidos p = new Pedidos();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setEstadoPedido(rs.getString("estadoPedido"));
                p.setTotal(rs.getFloat("total"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar: " + e.getMessage());
        }
        return lista;
    }
}