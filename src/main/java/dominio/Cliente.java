package dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer idCliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String calle;
    private String colonia;
    private int codigoPostal;
    private String password;
    private List<Telefono> telefonos;

    public static class Telefono {
        private String numero;
        private String etiqueta;

        public Telefono(String numero, String etiqueta) {
            this.numero = numero;
            this.etiqueta = etiqueta;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getEtiqueta() {
            return etiqueta;
        }

        public void setEtiqueta(String etiqueta) {
            this.etiqueta = etiqueta;
        }
    }

    public Cliente() {
        this.telefonos = new ArrayList<>();
    }

    public Cliente(Integer idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String calle, String colonia, int codigoPostal, String password) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.password = password;
        this.telefonos = new ArrayList<>();
    }

    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String calle, String colonia, int codigoPostal, String password) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.password = password;
        this.telefonos = new ArrayList<>();
    }

    public int getEdad() {
        if (fechaNacimiento != null) {
            LocalDate nacimiento = fechaNacimiento.toLocalDate();
            return Period.between(nacimiento, LocalDate.now()).getYears();
        }
        return 0;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public void agregarTelefono(String numero, String etiqueta) {
        this.telefonos.add(new Telefono(numero, etiqueta));
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
