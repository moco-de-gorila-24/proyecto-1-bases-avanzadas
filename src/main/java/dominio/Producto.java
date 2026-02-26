package dominio;

public class Producto {
    private int idProducto;
    private String producto;
    private boolean listo;

    public Producto(int idProducto, String producto, boolean listo) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.listo = listo;
    }

    public Producto(String producto, boolean listo) {
        this.producto = producto;
        this.listo = listo;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}

