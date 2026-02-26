package negocioDAO;

import DTO.ClienteDTO;
import dominio.Cliente;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IClienteDAO;

import java.sql.*;

public class ClienteDAO implements IClienteDAO {
    private final IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) throws PersistenciaException {
        String comandoSQL = """
                INSERT INTO Clientes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, codigoPostal, contrasenia)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);             
                """;

        try (Connection conn = this.conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setDate(4, cliente.getFechaNacimiento());
            ps.setString(5, cliente.getCallle());
            ps.setString(6, cliente.getColonia());
            ps.setInt(7, cliente.getCodigoPostal());
            ps.setString(8, cliente.getContraseña());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setIdCliente(rs.getInt(1));
                }
            }
            return cliente;

        } catch (SQLException e) {
            throw manejarExcepcionSQL(e);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        return null;
    }

    @Override
    public boolean clienteLogueado(int idCliente) throws PersistenciaException {
        String comandoSQL = "SELECT idCliente FROM Clientes WHERE idCliente = ?";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement ps = conexion.prepareStatement(comandoSQL)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw manejarExcepcionSQL(e);
        }
    }

    private PersistenciaException manejarExcepcionSQL(SQLException ex) {
        return switch (ex.getErrorCode()) {
            case 0 -> new PersistenciaException("Error: No se pudo conectar con el servidor.", ex);
            case 1045 -> new PersistenciaException("Error: Usuario o contraseña de BD incorrectos.", ex);
            case 1062 -> new PersistenciaException("Error: El cliente ya está registrado.", ex);
            default ->
                    new PersistenciaException("Error de base de datos (" + ex.getErrorCode() + "): " + ex.getMessage(), ex);
        };
    }
}