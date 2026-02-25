package negocioBO;

import DTO.ClienteDTO;
import dominio.Cliente;
import negocio.NegocioException;
import negocio.PersistenciaException;
import negocioDAO.ClienteDAO;
import persistenciaBO.IClienteBO;
import persistenciaDAO.IClienteDAO;

import java.util.logging.Logger;

public class ClienteBO implements IClienteBO {
    private final IClienteDAO ClienteDAO;
    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());

    public ClienteBO(IClienteDAO clienteDAO) {
        ClienteDAO = clienteDAO;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws NegocioException, PersistenciaException {
        if(cliente == null){
            LOG.severe("No puede ingresar un valor nulo");
            throw new NegocioException("No puede dejar valores nulos");
        }

        if (cliente.getFechaNacimiento().getDay() < 1 || cliente.getFechaNacimiento().getDay() > 31){
            LOG.warning("Debe ingresar un dia valido");
            throw new NegocioException("Ingrese una fecha valida");
        }

        if(cliente.getFechaNacimiento().getMonth() < 1 || cliente.getFechaNacimiento().getMonth() > 12){
            LOG.warning("Debe ingresar un mes valido");
            throw new NegocioException("Debe ingresar una fecha valida");
        }

        // estas mandando un LA DTO de cliente al metodo pero este solo recibe objetos cliente
        ClienteDAO.agregarCliente(null);
        return null;
    }
}
