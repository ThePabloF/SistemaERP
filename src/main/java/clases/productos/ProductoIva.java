package clases.productos;

import clases.enums.CategoriaProducto;
import clases.visual.Proveedor;

public class ProductoIva extends Producto {

    private final double porcentajeIva;

    public ProductoIva(int id, String nombreProducto, double precioUnitario,CategoriaProducto categoria, Proveedor proveedor) {
        super(id, nombreProducto, precioUnitario,categoria,proveedor);
        this.porcentajeIva = 15;
    }

    @Override
    public double calcularPrecio() {
        return getPrecioUnitario() + (getPrecioUnitario() * porcentajeIva / 100);
    }


    @Override
    public String toString() {
        return super.toString() + " (con IVA del " + porcentajeIva + "%)";
    }
}
