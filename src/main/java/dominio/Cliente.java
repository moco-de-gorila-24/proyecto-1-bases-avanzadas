package dominio;

import java.time.LocalDate;

public class Cliente {
    private Integer idCliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String callle;
    private String colonia;
    private int codigoPostal;

    public Cliente(Integer idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String callle, String colonia, int codigoPostal) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.callle = callle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String callle, String colonia, int codigoPostal) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.callle = callle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Cliente(){

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCallle() {
        return callle;
    }

    public void setCallle(String callle) {
        this.callle = callle;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
}
