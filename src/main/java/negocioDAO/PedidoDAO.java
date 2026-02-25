package negocioDAO;

import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IPedidoDAO;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class PedidoDAO implements IPedidoDAO {
    private final IConexionBD conexionBD;

    public PedidoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarPedido(Pedidos pedido) throws PersistenciaException {
    }

    @Override
    public List<Pedidos> buscarPedidos(String filtro) throws PersistenciaException {
        return new ArrayList<>();
    }

    @Override
    public void actualizarEstado(int idPedido, String nuevoEstado) throws PersistenciaException {
    }
}