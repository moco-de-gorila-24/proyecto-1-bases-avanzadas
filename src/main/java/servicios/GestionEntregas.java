/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaDAO.IPedidoDAO;
/**
 *
 * @author oscar
 */
public class GestionEntregas {

    private final IPedidoDAO pedidoDAO;

    public GestionEntregas(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void entregarPedido(Pedidos pedido, String metodoPago) throws Exception {
        if (pedido == null) {
            throw new Exception("Error: El pedido es nulo.");
        }

        if (pedido.getEstadoPedido() == null || !pedido.getEstadoPedido().equalsIgnoreCase("Listo")) {
            throw new Exception("Error: El pedido #" + pedido.getIdPedido() + " no está listo para entrega.");
        }

        pedidoDAO.registrarEntregaYPago(
            pedido.getIdPedido(),      
            metodoPago,                
            (double) pedido.getTotal() 
        );

        pedido.setEstadoPedido("Entregado");
    }
}