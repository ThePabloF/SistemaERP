package clases.visual;

public class Producto {
    private String idProducto;
    private String nombre;
    private double precioUnidad;
    private int cantidad;

    public Producto(String idProducto, String nombre, double precioUnidad, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
    }

    public String getIdProducto() { return idProducto; }
    public String getNombre() { return nombre; }
    public double getPrecioUnidad() { return precioUnidad; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return nombre + " (ID: " + idProducto + ") - $" + precioUnidad + " - Cant: " + cantidad;
    }
}