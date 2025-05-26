package clases.productos;

import clases.enums.CategoriaProducto;
import clases.visual.Proveedor;

public abstract class Producto {
    private int id;
    private String nombreProducto;
    private double precioUnitario;
    private CategoriaProducto categoria; // Puedes definir esta clase o enum aparte
    private Proveedor proveedor; // Asociación: cada producto tiene un proveedor


    public Producto(int id, String nombreProducto,double precioUnitario,CategoriaProducto categoria, Proveedor proveedor) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public abstract double calcularPrecio();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioUnitario=" + calcularPrecio() +
                ", categoria=" + categoria +
                ", proveedor=" + proveedor.getNombre() +
                '}';
    }
}
