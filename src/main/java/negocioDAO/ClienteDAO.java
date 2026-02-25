package negocioDAO;

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
                INSERT INTO clientes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, codigoPostal)
                VALUES ( ?, ?, ?, ?, ?, ?, ?);             
                """;

        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setDate(4, cliente.getFechaNacimiento());
            ps.setString(5, cliente.getCallle());
            ps.setString(6, cliente.getColonia());
            ps.setInt(7, cliente.getCodigoPostal());

        } catch (SQLException e) {
        }
        return cliente;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        return null;
    }

    @Override
    public boolean clienteLogueado(int idTecnico) throws PersistenciaException {
        return false;
    }
}
