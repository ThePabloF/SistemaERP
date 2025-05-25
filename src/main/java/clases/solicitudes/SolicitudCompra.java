package clases.solicitudes;

import clases.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudCompra {
    private int numSolicitud;
    private Solicitante solicitante;
    private EstadoSolicitud estadoSolicitud;
    private List<DetalleSolicitud> detallesSolicitud;
    private GregorianCalendar fechaSolicitud;

    public SolicitudCompra(int numSolicitud, Solicitante solicitante,GregorianCalendar fechaSolicitud) {
        this.numSolicitud = numSolicitud;
        this.solicitante = solicitante;
        this.estadoSolicitud = EstadoSolicitud.EN_REVISION;
        this.detallesSolicitud = new ArrayList<>();
        this.fechaSolicitud = new GregorianCalendar();
    }

    public void agregarDetalle(DetalleSolicitud detalle) {
        detallesSolicitud.add(detalle);
    }

    // Metodo para calcular el costo total de la solicitud

    public double calcularCostoTotal() {
        double total = 0;
        for (DetalleSolicitud d : detallesSolicitud) {
            total += d.calcularSubtotal();
        }
        return total;
    }

    // Metodo para cambiar el estado de la solicitud
    public void cambiarEstadoSolicitud(EstadoSolicitud nuevoEstado) {
        this.estadoSolicitud = nuevoEstado;
    }

    //Getters y Setters
    public int getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(int numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public List<DetalleSolicitud> getDetallesSolicitud() {
        return detallesSolicitud;
    }

    public void setDetallesSolicitud(List<DetalleSolicitud> detallesSolicitud) {
        this.detallesSolicitud = detallesSolicitud;
    }

    public GregorianCalendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(GregorianCalendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
