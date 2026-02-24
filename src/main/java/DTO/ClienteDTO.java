package DTO;

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

    public ClienteDTO() {
    }

    public ClienteDTO(Integer idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String callle, String colonia, int codigoPostal, String contraseña) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.callle = callle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.contraseña = contraseña;
    }

    public ClienteDTO(String contraseña, int codigoPostal, String colonia, String callle, Date fechaNacimiento, String apellidoMaterno, String apellidoPaterno, String nombres) {
        this.contraseña = contraseña;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.callle = callle;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.nombres = nombres;
    }


    
}


