package clases.visual;

import clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Usuario {
    private List<Producto> productos;

    public Proveedor(int id, String nombre, String apellido, String telefono) {
        super(id, nombre, apellido, telefono);
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() { return productos; }

    @Override
    public String toString() {
        return getId() + " - " + getNombre() + " - " + getTelefono() + " - " + getCorreo();
    }
}
