package dominio;

public class Producto {
    private int idProducto;
    private String nombre;
    private String tamaño;
    private String descripcion;
    private float precio;
    private String ingredientesBase;
    private boolean disponible;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String tamaño, String descripcion, float precio, String ingredientesBase, boolean disponible) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredientesBase = ingredientesBase;
        this.disponible = disponible;
    }

    public Producto(String nombre, String tamaño, String descripcion, float precio, String ingredientesBase, boolean disponible) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredientesBase = ingredientesBase;
        this.disponible = disponible;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getIngredientesBase() {
        return ingredientesBase;
    }

    public void setIngredientesBase(String ingredientesBase) {
        this.ingredientesBase = ingredientesBase;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

