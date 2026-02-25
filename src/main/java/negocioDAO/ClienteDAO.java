package negocioDAO;

import DTO.ClienteDTO;
import com.mysql.cj.xdevapi.Client;
import dominio.Cliente;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IClienteDAO;

import javax.swing.*;
import java.sql.*;

public class ClienteDAO implements IClienteDAO {
    private final IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD =  conexionBD;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO clienteDTO) throws PersistenciaException {
        String comandoSQL = """
                            INSERT INTO clientes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, codigoPostal, contrasenia)
                            VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);             
                            """;

        try(Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, clienteDTO.getNombres());
            ps.setString(2, clienteDTO.getApellidoPaterno());
            ps.setString(3, clienteDTO.getApellidoMaterno());
            ps.setDate(4, clienteDTO.getFechaNacimiento());
            ps.setString(5, clienteDTO.getCallle());
            ps.setString(6, clienteDTO.getColonia());
            ps.setInt(7, clienteDTO.getCodigoPostal());
            ps.setString(8, clienteDTO.getContraseña());
            ps.executeUpdate();

        }
        catch (SQLException e) {
        }
        return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        return null;
    }


    @Override
    public boolean clienteExiste(ClienteDTO clienteDTO) throws PersistenciaException {
        String comandoSQL = """
                SELECT id
                FROM tecnicos 
                WHERE id = ?    
                """;
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(comandoSQL)) {
            //ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return false;
                }
                return true;
            }

        } catch (SQLException e) {
            throw manejarExcepcionSQL(e);
        }

    }

    private PersistenciaException manejarExcepcionSQL(SQLException ex) {

        return switch (ex.getErrorCode()) {
            case 0 ->
                    new PersistenciaException("Error: No se pudo conectar con el servidor.", ex);
            case 1045 ->
                    new PersistenciaException("Error: Usuario o contraseña de base de datos incorrectos.", ex);
            case 1062 ->
                    new PersistenciaException("Error: Registro duplicado detectado.", ex);
            case 1451 ->
                    new PersistenciaException("Error: No se puede eliminar un técnico con trabajos asignados.", ex);
            default ->
                    new PersistenciaException(
                            "Error de base de datos (Código " + ex.getErrorCode() + "): " + ex.getMessage(),
                            ex
                    );
        };
    }

}
