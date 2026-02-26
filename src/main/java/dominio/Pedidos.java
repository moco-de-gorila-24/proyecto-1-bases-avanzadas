package dominio;

import java.time.LocalDate;

/**
 * Entidad de dominio para los Pedidos de la Pizzería.
 * @author oscar
 */
public class Pedidos {
    private int idPedido;
    private String estadoPedido;
    private float total; 
    private LocalDate fechaHoraPreparacion;
    private LocalDate fechaHoraEntrega;
    private Integer idCliente; 

    public Pedidos(int idPedido, String estadoPedido, float total, LocalDate fechaHoraPreparacion, LocalDate fechaHoraEntrega, Integer idCliente) {
        this.idPedido = idPedido;
        this.estadoPedido = estadoPedido;
        this.total = total;
        this.fechaHoraPreparacion = fechaHoraPreparacion;
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.idCliente = idCliente;
    }

    public Pedidos(String estadoPedido, float total, Integer idCliente) {
        this.estadoPedido = estadoPedido;
        this.total = total;
        this.idCliente = idCliente;
    }

    public Pedidos() {
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public float getTotal() { 
        return total;
    }

    public void setTotal(float total) { 
        this.total = total;
    }

    public LocalDate getFechaHoraPreparacion() {
        return fechaHoraPreparacion;
    }

    public void setFechaHoraPreparacion(LocalDate fechaHoraPreparacion) {
        this.fechaHoraPreparacion = fechaHoraPreparacion;
    }

    public LocalDate getFechaHoraEntrega() {
        return fechaHoraEntrega;
    }

    public void setFechaHoraEntrega(LocalDate fechaHoraEntrega) {
        this.fechaHoraEntrega = fechaHoraEntrega;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}