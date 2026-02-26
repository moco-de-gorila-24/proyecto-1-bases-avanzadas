package dominio;

public class PedidoExpress {
    private int idPedido;
    private String folio;
    private String pin;

    public PedidoExpress(int idPedido, String folio, String pin) {
        this.idPedido = idPedido;
        this.folio = folio;
        this.pin = pin;
    }

    public PedidoExpress(String folio, String pin) {
        this.folio = folio;
        this.pin = pin;
    }

    public PedidoExpress(){

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
