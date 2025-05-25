package clases.productos;

import clases.enums.CategoriaProducto;
import clases.visual.Proveedor;

public class ProductoNoIva extends Producto {
    public ProductoNoIva(int id, String nombreProducto,double precioUnitario,CategoriaProducto categoria, Proveedor proveedor) {
        super(id, nombreProducto, precioUnitario, categoria, proveedor);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioUnitario();
    }
}
