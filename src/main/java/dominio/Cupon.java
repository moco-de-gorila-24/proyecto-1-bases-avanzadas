package dominio;

import java.time.LocalDate;

public class Cupon {
    private int idCupon;
    private float porcentajeDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numUso;

    public Cupon(int idCupon, float porcentajeDescuento, LocalDate fechaInicio, LocalDate fechaFin, int numUso) {
        this.idCupon = idCupon;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numUso = numUso;
    }

    public Cupon(float porcentajeDescuento, int numUso, LocalDate fechaFin, LocalDate fechaInicio) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.numUso = numUso;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }

    public Cupon() {
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
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

    public int getNumUso() {
        return numUso;
    }

    public void setNumUso(int numUso) {
        this.numUso = numUso;
    }
}
