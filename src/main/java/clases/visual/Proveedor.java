package clases.visual;

import clases.Usuario;
import clases.productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Usuario {
    private List<Producto> productos;

    public Proveedor(int id, String nombre, String apellido, String telefono) {
        super(id, nombre, apellido, telefono);
        this.productos = new ArrayList<>();

    }

    // Método para agregar productos
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Getter para la lista de productos
    public List<Producto> getProductos() {
        return productos;
    }



    @Override
    public String toString() {
        return getId() + " - " + getNombre() + " - " + getTelefono() + " - " + getCorreo();
    }
}
