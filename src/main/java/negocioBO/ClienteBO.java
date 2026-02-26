package negocioBO;

import DTO.ClienteDTO;
import dominio.Cliente;
import negocio.NegocioException;
import negocio.PersistenciaException;
import persistenciaBO.IClienteBO;
import persistenciaDAO.IClienteDAO;
import java.util.logging.Logger;

public class ClienteBO implements IClienteBO {
    private final IClienteDAO clienteDAO;
    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());

    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO clienteDTO) throws NegocioException, PersistenciaException {
        if(clienteDTO == null){
            LOG.severe("No puede ingresar un valor nulo");
            throw new NegocioException("No puede dejar valores nulos");
        }

        java.sql.Date fechaSQL = new java.sql.Date(clienteDTO.getFechaNacimiento().getTime());

        Cliente nuevoCliente = new Cliente(
            clienteDTO.getNombres(),
            clienteDTO.getApellidoPaterno(),
            clienteDTO.getApellidoMaterno(),
            fechaSQL,              
            clienteDTO.getCallle(),     
            clienteDTO.getColonia(),
            clienteDTO.getCodigoPostal(),
            clienteDTO.getContraseña()   
        );

        return clienteDAO.agregarCliente(nuevoCliente);
    }
}