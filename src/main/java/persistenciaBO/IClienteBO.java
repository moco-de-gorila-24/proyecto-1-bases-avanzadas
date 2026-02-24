package persistenciaBO;

import DTO.ClienteDTO;
import dominio.Cliente;
import negocio.NegocioException;
import negocio.PersistenciaException;

public interface IClienteBO {
    public Cliente agregarCliente(ClienteDTO cliente) throws NegocioException, PersistenciaException;
}
