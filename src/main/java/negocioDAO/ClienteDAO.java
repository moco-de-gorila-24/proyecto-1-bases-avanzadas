package negocioDAO;

import dominio.Cliente;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IClienteDAO;
import utilidades.Encriptador;

import java.sql.*;

public class ClienteDAO implements IClienteDAO {

    private final IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void registrarCliente(Cliente cliente) throws PersistenciaException {
        String sqlCliente = "INSERT INTO Clientes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, codigoPostal, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlTelefono = "INSERT INTO Telefonos (etiqueta, idCliente, telefono) VALUES (?, ?, ?)";

        Connection conn = null;
        try {
            conn = conexionBD.crearConexion();
            conn.setAutoCommit(false); // Transacción para cliente + teléfonos

            // 1. Insertar Cliente
            try (PreparedStatement psC = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS)) {
                psC.setString(1, cliente.getNombres());
                psC.setString(2, cliente.getApellidoPaterno());
                psC.setString(3, cliente.getApellidoMaterno());
                psC.setDate(4, cliente.getFechaNacimiento());
                psC.setString(5, cliente.getCalle());
                psC.setString(6, cliente.getColonia());
                psC.setInt(7, cliente.getCodigoPostal());
                psC.setString(8, cliente.getPassword()); // Aquí idealmente va la contraseña ya encriptada

                psC.executeUpdate();

                ResultSet rs = psC.getGeneratedKeys();
                if (rs.next()) {
                    cliente.setIdCliente(rs.getInt(1));
                }
            }

            // 2. Insertar sus teléfonos
            try (PreparedStatement psT = conn.prepareStatement(sqlTelefono)) {
                for (Cliente.Telefono tel : cliente.getTelefonos()) {
                    psT.setString(1, tel.getEtiqueta());
                    psT.setInt(2, cliente.getIdCliente());
                    psT.setString(3, tel.getNumero());
                    psT.addBatch();
                }
                psT.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) { }
            throw new PersistenciaException("Error al registrar cliente: " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { }
        }
    }

    @Override
    public Cliente login(String nombre, String passwordPlana) throws PersistenciaException {
        // 1. Buscamos al cliente solo por su nombre
        String sql = "SELECT * FROM Clientes WHERE nombre = ?";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashBD = rs.getString("contrasenia");

                    // 2. Verificamos si la contraseña coincide con el Hash
                    if (Encriptador.verificar(passwordPlana, hashBD)) {
                        return new Cliente(
                                rs.getInt("idCliente"),
                                rs.getString("nombre"),
                                rs.getString("apellidoPaterno"),
                                rs.getString("apellidoMaterno"),
                                rs.getDate("fechaNacimiento"),
                                rs.getString("calle"),
                                rs.getString("colonia"),
                                rs.getInt("codigoPostal"),
                                hashBD
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error en seguridad de login: " + e.getMessage());
        }
        return null; // Si no existe o la contraseña no coincide
    }

    @Override
    public Cliente buscarPorId(int idCliente) throws PersistenciaException {
        // Implementación similar al login pero buscando solo por ID...
        return null;
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws PersistenciaException {
        String sql = "UPDATE Clientes SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, calle=?, colonia=?, codigoPostal=? WHERE idCliente=?";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getCalle());
            ps.setString(5, cliente.getColonia());
            ps.setInt(6, cliente.getCodigoPostal());
            ps.setInt(7, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar: " + e.getMessage());
        }
    }
}
