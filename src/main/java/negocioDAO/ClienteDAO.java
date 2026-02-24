package persistenciaDAO;

import dominio.Cliente;
import negocio.PersistenciaException;
import persistenciaBD.ConexionBD;
import persistenciaBD.IConexionBD;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class ClienteDAO implements IClienteDAO{
    private final IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD =  conexionBD;
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) throws PersistenciaException {
        String comandoSQL = """
                            INSERT INTO clientes (idCliente, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, codigoPostal)
                            VALUES (?, ?, ?, ?, ?, ?, ?, ?);             
                            """;

        try(Connection conn = this.conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidoPaterno());
            ps.setString(4, cliente.getApellidoMaterno());
            ps.setDate(5, cliente.getFechaNacimiento());
            ps.setString(6, cliente.getCallle());
            ps.setString(7, cliente.getColonia());
            ps.setInt(8, cliente.getCodigoPostal());

            ps.executeUpdate();

        }
        catch (SQLException e) {
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
