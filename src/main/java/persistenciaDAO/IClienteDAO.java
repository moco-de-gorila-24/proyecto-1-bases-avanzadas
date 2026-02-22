package persistenciaDAO;

import dominio.Cliente;
import negocio.PersistenciaException;

public interface IClienteDAO {
    Cliente agregarCliente(Cliente cliente) throws PersistenciaException;

    Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;

    boolean clienteLogueado(int idTecnico) throws PersistenciaException;
}
