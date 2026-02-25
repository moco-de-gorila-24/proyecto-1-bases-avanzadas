package negocioBO;

import dominio.PedidoExpress;
import dominio.Pedidos;
import negocio.PersistenciaException;
import persistenciaDAO.IPedidoDAO;
import utilidades.Encriptador;
import java.util.List;

public class PedidoBO {

    private final IPedidoDAO pedidoDAO;

    public PedidoBO(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public boolean puedeRealizarPedido(int idCliente) throws PersistenciaException {
        List<Pedidos> pedidosActivos = pedidoDAO.buscarPedidosPorClienteYEstados(idCliente,
                List.of("Pendiente", "En Preparación", "Listo"));

        return pedidosActivos.size() < 3;
    }

    public void procesarEntrega(Pedidos pedido, String pinIngresado, String metodoPago) throws Exception {

        if (!pedido.getEstadoPedido().equalsIgnoreCase("Listo")) {
            throw new Exception("Operación inválida: El pedido debe estar en estado 'Listo' para ser entregado.");
        }

        if (pedido instanceof PedidoExpress) {
            PedidoExpress express = (PedidoExpress) pedido;
            if (!Encriptador.verificar(pinIngresado, express.getPinSeguridad())) {
                throw new Exception("Error de seguridad: El PIN ingresado es incorrecto.");
            }
        }

        pedidoDAO.registrarEntregaConPago(pedido.getIdPedido(), metodoPago, pedido.getTotal());
    }

    public List<Pedidos> consultarPedidosParaMostrador(String filtro) throws PersistenciaException {
        return pedidoDAO.buscarPedidos(filtro);
    }
}
