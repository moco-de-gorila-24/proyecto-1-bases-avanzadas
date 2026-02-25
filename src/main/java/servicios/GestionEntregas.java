package servicios;

import dominio.Pedidos;
import java.time.LocalDateTime;

public class GestionEntregas {

    public void entregarPedido(Pedidos pedido, String metodoPago) throws Exception {

        if (!pedido.getEstadoPedido().equalsIgnoreCase("Listo")) {
            throw new Exception("Error: Solo se pueden entregar pedidos en estado 'Listo'. " +
                    "Estado actual: " + pedido.getEstadoPedido());
        }

        pedido.setEstadoPedido("Entregado");
        pedido.setFechaHoraEntrega(LocalDateTime.now());

        registrarPago(pedido, metodoPago);

        System.out.println("Pedido #" + pedido.getIdPedido() + " entregado exitosamente.");
    }

    private void registrarPago(Pedidos pedido, String metodo) {
        System.out.println("Pago registrado: $" + pedido.getTotal() + " vía " + metodo);
    }
}
