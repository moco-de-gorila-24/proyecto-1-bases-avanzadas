package dominio;

import java.time.LocalDate;

public class Pedidos {
    private int idPedido;
    private String estadoPedido;
    private LocalDate fechaHoraPreparacion;
    private LocalDate fechaHoraEntrega;

    public Pedidos(int idPedido, String estadoPedido, LocalDate fechaHoraPreparacion, LocalDate fechaHoraEntrega) {
        this.idPedido = idPedido;
        this.estadoPedido = estadoPedido;
        this.fechaHoraPreparacion = fechaHoraPreparacion;
        this.fechaHoraEntrega = fechaHoraEntrega;
    }

    public Pedidos(LocalDate fechaHoraPreparacion, String estadoPedido, LocalDate fechaHoraEntrega) {
        this.fechaHoraPreparacion = fechaHoraPreparacion;
        this.estadoPedido = estadoPedido;
        this.fechaHoraEntrega = fechaHoraEntrega;
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
}


