package clases.visual;

import clases.Usuario;
import clases.productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Usuario {
    private List<Producto> productos;

    public Proveedor(int id, String nombre, String telefono, String correo) {
        super(id, nombre, correo, telefono);
        this.productos = new ArrayList<>();

    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }



    @Override
    public String toString() {
        return getId() + " - " + getNombre() + " - " + getTelefono() + " - " + getCorreo();
    }
}