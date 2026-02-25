package dominio;

public class Telefono {
    private int idTelefono;
    private String etiqueta;
    private int idCliente;
    private String telefono;

    public Telefono(int idTelefono, String etiqueta, int idCliente, String telefono) {
        this.idTelefono = idTelefono;
        this.etiqueta = etiqueta;
        this.idCliente = idCliente;
        this.telefono = telefono;
    }

    public Telefono(String etiqueta, int idCliente, String telefono) {
        this.etiqueta = etiqueta;
        this.idCliente = idCliente;
        this.telefono = telefono;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
