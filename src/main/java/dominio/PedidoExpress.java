package dominio;

import java.time.LocalDateTime;

public class PedidoExpress extends Pedidos {
    private String folio;
    private String pinSeguridad;
    private LocalDateTime fechaHoraLimite;

    public PedidoExpress() {
        super();
        this.fechaHoraLimite = LocalDateTime.now().plusMinutes(20);
    }

    public boolean haExpirado() {
        return LocalDateTime.now().isAfter(fechaHoraLimite);
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getPinSeguridad() {
        return pinSeguridad;
    }

    public void setPinSeguridad(String pinSeguridad) {
        this.pinSeguridad = pinSeguridad;
    }

    public LocalDateTime getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    public void setFechaHoraLimite(LocalDateTime fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }
}