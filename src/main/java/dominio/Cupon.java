package dominio;

import java.time.LocalDate;

public class Cupon {
    private int idCupon;
    private String codigo;
    private float porcentajeDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int limiteUsos;
    private int usosActuales;

    public Cupon() {
    }

    public Cupon(int idCupon, String codigo, float porcentajeDescuento, LocalDate fechaInicio, LocalDate fechaFin, int limiteUsos, int usosActuales) {
        this.idCupon = idCupon;
        this.codigo = codigo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.limiteUsos = limiteUsos;
        this.usosActuales = usosActuales;
    }

    public boolean esValido() {
        LocalDate hoy = LocalDate.now();
        boolean fechaValida = (!hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin));
        boolean usosDisponibles = (usosActuales < limiteUsos);

        return fechaValida && usosDisponibles;
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getLimiteUsos() {
        return limiteUsos;
    }

    public void setLimiteUsos(int limiteUsos) {
        this.limiteUsos = limiteUsos;
    }

    public int getUsosActuales() {
        return usosActuales;
    }

    public void setUsosActuales(int usosActuales) {
        this.usosActuales = usosActuales;
    }
}
