package persistenciaDAO;

import dominio.Pedidos;
import negocio.PersistenciaException;
import java.util.List;

public interface IPedidoDAO {
    void agregarPedido(Pedidos pedido) throws PersistenciaException;
    List<Pedidos> buscarPedidos(String filtro) throws PersistenciaException;
    void registrarEntregaConPago(int idPedido, String metodoPago, float monto) throws PersistenciaException;
    List<Pedidos> buscarPedidosPorClienteYEstados(int idCliente, List<String> estados) throws PersistenciaException;
    Pedidos obtenerPorId(int idPedido) throws PersistenciaException;
}