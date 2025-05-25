package clases.visual;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GestionProveedoresProductos {
//    private Frame ventana;
//    private Panel panelMenu;
//    private TextArea areaTexto;
//    private List<Proveedor> proveedores = new ArrayList<>();
//
//    public void mostrar() {
//        ventana = new Frame("Gestión de Proveedores y Productos");
//        ventana.setSize(500, 400);
//        ventana.setLayout(new FlowLayout());
//
//
//        // Panel de menú
//        panelMenu = new Panel();
//        panelMenu.setLayout(new GridLayout(4,1));
//
//        Button btnProveedor = new Button("Agregar Proveedor");
//        Button btnProducto = new Button("Agregar Producto");
//        Button btnListar = new Button("Listar Todo");
//        Button btnSalir = new Button("Salir");
//
//        // Área de texto
//        areaTexto = new TextArea();
//        areaTexto.setEditable(false);
//
//        // Eventos
//        btnProveedor.addActionListener(e -> mostrarFormularioProveedor());
//        btnProducto.addActionListener(e -> mostrarFormularioProducto());
//        btnListar.addActionListener(e -> listarTodo());
//        btnSalir.addActionListener(e -> System.exit(0));
//
//        panelMenu.add(btnProveedor);
//        panelMenu.add(btnProducto);
//        panelMenu.add(btnListar);
//        panelMenu.add(btnSalir);
//
//        ventana.add(panelMenu, BorderLayout.WEST);
//        ventana.add(areaTexto, BorderLayout.CENTER);
//
//        ventana.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//
//        ventana.setVisible(true);
//    }
//
//    private void mostrarFormularioProveedor() {
//        Panel panelForm = new Panel();
//        panelForm.setLayout(new GridLayout(5, 2));
//
//        Label lblCedula = new Label("Cédula:");
//        TextField txtCedula = new TextField();
//        Label lblNombre = new Label("Nombre:");
//        TextField txtNombre = new TextField();
//        Label lblApellido = new Label("Apellido:");
//        TextField txtApellido = new TextField();
//        Label lblTelefono = new Label("Teléfono:");
//        TextField txtTelefono = new TextField();
//
//        Button btnGuardar = new Button("Guardar");
//        Button btnLimpiar = new Button("Limpiar");
//
//        btnGuardar.addActionListener(e -> {
//            String cedula = txtCedula.getText();
//            String nombre = txtNombre.getText();
//            String apellido = txtApellido.getText();
//            String telefono = txtTelefono.getText();
//
//            if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()) {
//                areaTexto.setText("Todos los campos son obligatorios");
//                return;
//            }
//
//            if (existeProveedor(cedula)) {
//                areaTexto.setText("Ya existe un proveedor con esta cédula");
//                return;
//            }
//
//            Proveedor nuevo = new Proveedor(nombre, apellido, telefono);
//            proveedores.add(nuevo);
//            areaTexto.setText("Proveedor agregado:\n" + nuevo);
//        });
//
//        btnLimpiar.addActionListener(e -> {
//            txtCedula.setText("");
//            txtNombre.setText("");
//            txtApellido.setText("");
//            txtTelefono.setText("");
//        });
//
//        panelForm.add(lblCedula);
//        panelForm.add(txtCedula);
//        panelForm.add(lblNombre);
//        panelForm.add(txtNombre);
//        panelForm.add(lblApellido);
//        panelForm.add(txtApellido);
//        panelForm.add(lblTelefono);
//        panelForm.add(txtTelefono);
//        panelForm.add(btnGuardar);
//        panelForm.add(btnLimpiar);
//
//        // Reemplazar contenido
//        ventana.remove(panelMenu);
//        ventana.remove(areaTexto);
//        ventana.add(panelForm, BorderLayout.NORTH);
//        ventana.add(areaTexto, BorderLayout.CENTER);
//        ventana.add(crearBotonVolver(), BorderLayout.SOUTH);
//        ventana.validate();
//    }
//
//    private void mostrarFormularioProducto() {
//        if (proveedores.isEmpty()) {
//            areaTexto.setText("Primero debe agregar proveedores");
//            return;
//        }
//
//        Panel panelForm = new Panel();
//        panelForm.setLayout(new GridLayout(6, 2));
//
//        Label lblId = new Label("ID Producto:");
//        TextField txtId = new TextField();
//        Label lblNombre = new Label("Nombre:");
//        TextField txtNombre = new TextField();
//        Label lblPrecio = new Label("Precio:");
//        TextField txtPrecio = new TextField();
//        Label lblCantidad = new Label("Cantidad:");
//        TextField txtCantidad = new TextField();
//        Label lblProveedor = new Label("Cédula Proveedor:");
//        TextField txtProveedor = new TextField();
//
//        Button btnGuardar = new Button("Guardar");
//        Button btnLimpiar = new Button("Limpiar");
//
//        btnGuardar.addActionListener(e -> {
//            String id = txtId.getText();
//            String nombre = txtNombre.getText();
//            String precioStr = txtPrecio.getText();
//            String cantidadStr = txtCantidad.getText();
//            String cedulaProveedor = txtProveedor.getText();
//
//            if (id.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty() || cedulaProveedor.isEmpty()) {
//                areaTexto.setText("Todos los campos son obligatorios");
//                return;
//            }
//
//            try {
//                double precio = Double.parseDouble(precioStr);
//                int cantidad = Integer.parseInt(cantidadStr);
//
//                Proveedor proveedor = buscarProveedor(cedulaProveedor);
//                if (proveedor == null) {
//                    areaTexto.setText("No existe proveedor con esa cédula");
//                    return;
//                }
//
//                Producto nuevo = new Producto(id, nombre, precio, cantidad);
//                proveedor.agregarProducto(nuevo);
//                areaTexto.setText("Producto agregado a:\n" + proveedor + "\n\nProducto:\n" + nuevo);
//            } catch (NumberFormatException ex) {
//                areaTexto.setText("Precio y cantidad deben ser números");
//            }
//        });
//
//        btnLimpiar.addActionListener(e -> {
//            txtId.setText("");
//            txtNombre.setText("");
//            txtPrecio.setText("");
//            txtCantidad.setText("");
//            txtProveedor.setText("");
//        });
//
//        panelForm.add(lblId);
//        panelForm.add(txtId);
//        panelForm.add(lblNombre);
//        panelForm.add(txtNombre);
//        panelForm.add(lblPrecio);
//        panelForm.add(txtPrecio);
//        panelForm.add(lblCantidad);
//        panelForm.add(txtCantidad);
//        panelForm.add(lblProveedor);
//        panelForm.add(txtProveedor);
//        panelForm.add(btnGuardar);
//        panelForm.add(btnLimpiar);
//
//        // Mostrar lista de proveedores
//        areaTexto.setText("Proveedores disponibles:\n");
//        for (Proveedor p : proveedores) {
//            areaTexto.append( p.getNombre() + " " + p.getApellido() + "\n");
//        }
//
//        // Reemplazar contenido
//        ventana.remove(panelMenu);
//        ventana.remove(areaTexto);
//        ventana.add(panelForm, BorderLayout.NORTH);
//        ventana.add(areaTexto, BorderLayout.CENTER);
//        ventana.add(crearBotonVolver(), BorderLayout.SOUTH);
//        ventana.validate();
//    }
//
//    private void listarTodo() {
//        StringBuilder sb = new StringBuilder();
//
//        if (proveedores.isEmpty()) {
//            sb.append("No hay proveedores registrados");
//        } else {
//            sb.append("=== LISTA DE PROVEEDORES CON PRODUCTOS ===\n\n");
//            for (Proveedor p : proveedores) {
//                sb.append("Proveedor: ").append(p.getNombre()).append(" ").append(p.getApellido()).append(")\n");
//
//                if (p.getProductos().isEmpty()) {
//                    sb.append("  No tiene productos\n");
//                } else {
//                    sb.append("  Productos:\n");
//                    for (Producto prod : p.getProductos()) {
//                        sb.append("  - ").append(prod.getNombre())
//                                .append(" (ID: ").append(prod.getIdProducto())
//                                .append(", Precio: $").append(prod.getPrecioUnidad())
//                                .append(", Cantidad: ").append(prod.getCantidad()).append(")\n");
//                    }
//                }
//                sb.append("\n");
//            }
//        }
//
//        areaTexto.setText(sb.toString());
//
//        // Reemplazar contenido
//        ventana.remove(panelMenu);
//        ventana.add(areaTexto, BorderLayout.CENTER);
//        ventana.add(crearBotonVolver(), BorderLayout.SOUTH);
//        ventana.validate();
//    }
//
//    private Button crearBotonVolver() {
//        Button btnVolver = new Button("Volver al Menú");
//        btnVolver.addActionListener(e -> {
//            ventana.removeAll();
//            ventana.add(panelMenu, BorderLayout.WEST);
//            ventana.add(areaTexto, BorderLayout.CENTER);
//            ventana.validate();
//        });
//        return btnVolver;
//    }
//
//    private boolean existeProveedor(String cedula) {
//        for (Proveedor p : proveedores) {
//            if (p.geti.equals(cedula)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Proveedor buscarProveedor(String cedula) {
//        for (Proveedor p : proveedores) {
//            if (p.getCedula().equals(cedula)) {
//                return p;
//            }
//        }
//        return null;
//    }
}
