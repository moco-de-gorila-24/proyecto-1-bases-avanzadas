package dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private int idPedido;
    private String estadoPedido;
    private float total;
    private Cliente cliente;
    private List<DetallePedido> detalles;

    private LocalDateTime fechaHoraRegistro;
    private LocalDateTime fechaHoraPreparacion;
    private LocalDateTime fechaHoraListo;
    private LocalDateTime fechaHoraEntrega;

    public static class DetallePedido {
        private Producto producto;
        private String notaOpcional;

        public DetallePedido(Producto producto, String notaOpcional) {
            this.producto = producto;
            this.notaOpcional = notaOpcional;
        }

        public Producto getProducto() {
            return producto;
        }

        public String getNotaOpcional() {
            return notaOpcional;
        }
    }

    public Pedidos() {
        this.estadoPedido = "Pendiente";
        this.fechaHoraRegistro = LocalDateTime.now();
        this.detalles = new ArrayList<>();
    }

    public void calcularTotal() {
        float suma = 0;
        for (DetallePedido detalle : detalles) {
            suma += detalle.getProducto().getPrecio();
        }
        this.total = suma;
    }

    public void agregarProducto(Producto producto, String nota) {
        this.detalles.add(new DetallePedido(producto, nota));
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public LocalDateTime getFechaHoraPreparacion() {
        return fechaHoraPreparacion;
    }

    public void setFechaHoraPreparacion(LocalDateTime fechaHoraPreparacion) {
        this.fechaHoraPreparacion = fechaHoraPreparacion;
    }

    public LocalDateTime getFechaHoraListo() {
        return fechaHoraListo;
    }

    public void setFechaHoraListo(LocalDateTime fechaHoraListo) {
        this.fechaHoraListo = fechaHoraListo;
    }

    public LocalDateTime getFechaHoraEntrega() {
        return fechaHoraEntrega;
    }

    public void setFechaHoraEntrega(LocalDateTime fechaHoraEntrega) {
        this.fechaHoraEntrega = fechaHoraEntrega;
    }
}


