/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioDAO;


import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IPedidoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author oscar
 */
public class PedidoDAO implements IPedidoDAO {

    private final IConexionBD conexionBD;

    public PedidoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void actualizarEstado(int idPedido, String nuevoEstado) throws PersistenciaException {
        String sql = "UPDATE Pedidos SET estadoPedido = ? WHERE idPedido = ?";

        try (Connection conn = this.conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);

            int filas = ps.executeUpdate();
            if (filas == 0) {
                throw new PersistenciaException("No se encontró el pedido #" + idPedido);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar estado del pedido", e);
        }
    }

   @Override
public List<Pedidos> buscarPedidosListos() throws PersistenciaException {
    List<Pedidos> lista = new ArrayList<>();
    
    String sql = """
        SELECT p.idPedido, p.total, p.estadoPedido, c.nombre 
        FROM Pedidos p 
        LEFT JOIN Clientes c ON p.idCliente = c.idCliente 
        WHERE p.estadoPedido = 'Listo'
        """;

    try (Connection conn = this.conexionBD.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Pedidos p = new Pedidos();
            p.setIdPedido(rs.getInt("idPedido"));
            p.setTotal(rs.getFloat("total"));
            p.setEstadoPedido(rs.getString("estadoPedido"));

            lista.add(p);
        }
    } catch (SQLException e) {
        throw new PersistenciaException("Error al consultar pedidos listos: " + e.getMessage(), e);
    }
    return lista;
}

    @Override
    public void registrarEntregaYPago(int idPedido, String metodoPago, double monto) throws PersistenciaException {
        String sql = "{CALL sp_registrar_entrega_pago(?, ?, ?)}";

        try (Connection conn = this.conexionBD.crearConexion();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, idPedido);
            cs.setString(2, metodoPago);
            cs.setDouble(3, monto);

            cs.execute();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al registrar la entrega: " + e.getMessage(), e);
        }
    }

    @Override
    public void agregarPedido(Pedidos pedido) throws PersistenciaException {
    }

    @Override
    public List<Pedidos> buscarPedidos(String filtro) throws PersistenciaException {
        return new ArrayList<>();
    }
}