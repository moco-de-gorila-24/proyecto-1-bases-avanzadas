/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocioBO;


import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaDAO.IPedidoDAO;
import java.util.List;
/**
 *
 * @author oscar
 */
public class PedidoBO {

    private final IPedidoDAO pedidoDAO;

    public PedidoBO(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public List<Pedidos> buscarPedidosListos() throws PersistenciaException {
        return pedidoDAO.buscarPedidosListos();
    }

    public void actualizarEstado(int idPedido, String nuevoEstado) throws PersistenciaException {
        if (idPedido <= 0) {
            throw new PersistenciaException("ID de pedido no válido.");
        }
        pedidoDAO.actualizarEstado(idPedido, nuevoEstado);
    }
    public void registrarEntrega(int idPedido, String metodo, double monto) throws PersistenciaException {
        pedidoDAO.registrarEntregaYPago(idPedido, metodo, monto);
    }
}