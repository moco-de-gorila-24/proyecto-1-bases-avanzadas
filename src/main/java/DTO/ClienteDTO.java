package DTO;

import dominio.Cliente;
import java.util.Date;

public class ClienteDTO {

    private Integer idCliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String callle;
    private String colonia;
    private int codigoPostal;
    private String contraseña;

    public ClienteDTO(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nombres = cliente.getNombres();
        this.apellidoPaterno = cliente.getApellidoPaterno();
        this.apellidoMaterno = cliente.getApellidoMaterno();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        this.callle = cliente.getCalle();
        this.colonia = cliente.getColonia();
        this.codigoPostal = cliente.getCodigoPostal();
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCallle() {
        return callle;
    }

    public void setCallle(String callle) {
        this.callle = callle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}


