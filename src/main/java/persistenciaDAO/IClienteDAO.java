package persistenciaDAO;

import dominio.Cliente;
import negocio.PersistenciaException;

public interface IClienteDAO {
    void registrarCliente(Cliente cliente) throws PersistenciaException;
    Cliente buscarPorId(int idCliente) throws PersistenciaException;
    Cliente login(String nombre, String password) throws PersistenciaException;
    void actualizarCliente(Cliente cliente) throws PersistenciaException;
}
