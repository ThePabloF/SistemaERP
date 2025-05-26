package clases.solicitudes;

import clases.Calculable;
import clases.productos.Producto;

public class DetalleSolicitud implements Calculable {
    @Override
    public double calcularCosto() {
        if (producto != null) {

            return cantidad * producto.calcularPrecio();
        }
        return 0.0;
    }

    private Producto producto;
    private int cantidad;
    private String justificacion;

    public DetalleSolicitud(Producto producto, int cantidad, String justificacion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.justificacion = justificacion;
    }



    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Override
    public String toString() {
        return "DetalleSolicitud{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", justificacion='" + justificacion + '\'' +
                '}';
    }
}
