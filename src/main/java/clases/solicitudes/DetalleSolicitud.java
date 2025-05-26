package clases.solicitudes;

import clases.productos.Producto;

public class DetalleSolicitud {
    private Producto producto;
    private int cantidad;
    private String justificacion;

    // Constructor
    public DetalleSolicitud(Producto producto, int cantidad, String justificacion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.justificacion = justificacion;
    }

    // Metodo para calcular el subtotal del detalle (cantidad × precio del producto)
    public double calcularSubtotal() {
        if (producto != null) {

            return cantidad * producto.calcularPrecio();
        }
        return 0.0;
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
