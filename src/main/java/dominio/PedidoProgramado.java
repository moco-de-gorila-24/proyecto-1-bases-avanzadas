package dominio;

public class PedidoProgramado {
    private int idPedido;
    private int numPedido;
    private String notaCliente;

    public PedidoProgramado(int idPedido, int numPedido, String notaCliente) {
        this.idPedido = idPedido;
        this.numPedido = numPedido;
        this.notaCliente = notaCliente;
    }

    public PedidoProgramado(String notaCliente, int numPedido) {
        this.notaCliente = notaCliente;
        this.numPedido = numPedido;
    }

    public PedidoProgramado() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getNotaCliente() {
        return notaCliente;
    }

    public void setNotaCliente(String notaCliente) {
        this.notaCliente = notaCliente;
    }
}
