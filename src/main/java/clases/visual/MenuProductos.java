package clases.visual;


import clases.SistemaDeCompras;
import clases.enums.CategoriaProducto;
import clases.productos.Producto;
import clases.productos.ProductoIva;
import clases.productos.ProductoNoIva;
import clases.visual.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuProductos extends Frame {
    private SistemaDeCompras sistema;
    private TextArea areaProductos;
    private int idProductos = 103;
    private Checkbox conIVA;
    private Checkbox sinIVA;
    private CheckboxGroup grupoIVA;

    public MenuProductos(SistemaDeCompras sistema) {
        this.sistema = sistema;
        setTitle("MENÚ DE PRODUCTOS");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setupUI();
    }

    private void setupUI() {
        Panel panelForm = new Panel(new GridLayout(8, 2, 5, 5)); // Se aumentó la fila
        panelForm.setBackground(new Color(169, 176, 185));

        Label lblNombre = new Label("Nombre:");
        TextField nombre = new TextField(10);
        Label lblPrecio = new Label("Precio:");
        TextField precio = new TextField(10);
        Label lblCategoria = new Label("Categoría:");
        Choice comboCat = new Choice();
        grupoIVA = new CheckboxGroup();
        conIVA = new Checkbox("Con IVA", grupoIVA, true);  // Por defecto
        sinIVA = new Checkbox("Sin IVA", grupoIVA, false);

        panelForm.add(new Label("IVA:"));
        Panel panelIVA = new Panel(new FlowLayout(FlowLayout.LEFT));
        panelIVA.add(conIVA);
        panelIVA.add(sinIVA);
        panelForm.add(panelIVA);
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            comboCat.add(cat.name());
        }
        Label lblProveedor = new Label("Proveedor:");
        Choice comboProv = new Choice();
        List<Proveedor> proveedores = sistema.getListaProveedores();
        for (Proveedor p : proveedores) {
            comboProv.add(p.getNombre());
        }



        Label lblBuscar = new Label("Buscar por ID:");
        TextField buscarId = new TextField(10);
        Button btnBuscar = new Button("Buscar");

        // BUSCAR
        btnBuscar.addActionListener(e -> {
            try {
                int idBuscado = Integer.parseInt(buscarId.getText());
                Producto encontrado = null;
                for (Producto p : sistema.getListaProductos()) {
                    if (p.getId() == idBuscado) {
                        encontrado = p;
                        break;
                    }
                }
                if (encontrado != null) {
                    areaProductos.setText("Producto encontrado:\n" + encontrado.toString());
                } else {
                    areaProductos.setText("Producto con ID " + idBuscado + " no encontrado.");
                }
            } catch (NumberFormatException ex) {
                areaProductos.setText("Error: ID debe ser un número entero.");
            }
        });

        // Agregar objetos al panel del formulario
        panelForm.add(lblNombre);
        panelForm.add(nombre);
        panelForm.add(lblPrecio);
        panelForm.add(precio);
        panelForm.add(lblCategoria);
        panelForm.add(comboCat);
        panelForm.add(lblProveedor);
        panelForm.add(comboProv);
        panelForm.add(lblBuscar);
        panelForm.add(buscarId);
        panelForm.add(new Label("")); // Celda vacía
        panelForm.add(btnBuscar); // Botón en nueva fila

        // Área de texto para productos
        areaProductos = new TextArea(10, 40);
        areaProductos.setEditable(false);

        // Panel de botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver al Menú");

        btnGuardar.addActionListener(e -> {
            try {
                String nom = nombre.getText();
                double prec = Double.parseDouble(precio.getText());
                CategoriaProducto cat = CategoriaProducto.valueOf(comboCat.getSelectedItem());
                Proveedor prov = proveedores.get(comboProv.getSelectedIndex());

                for (Producto p : sistema.getListaProductos()) {
                    if (p.getNombreProducto().equalsIgnoreCase(nom) &&
                            p.getPrecioUnitario() == prec &&
                            p.getProveedor().getNombre().equalsIgnoreCase(prov.getNombre())) {

                        areaProductos.setText("Error: Ya existe un producto con el mismo nombre, precio y proveedor.\n" +
                                "Por favor cambia alguno de esos campos.");
                        return; // No continúa si encuentra duplicado
                    }
                }

                // Crear el producto según el checkbox
                Producto producto;
                if (conIVA.getState()) {
                    producto = new ProductoIva(idProductos++, nom, prec, cat, prov);
                } else {
                    producto = new ProductoNoIva(idProductos++, nom, prec, cat, prov);
                }

                // Agregar el producto al sistema
                sistema.getListaProductos().add(producto);
                prov.agregarProducto(producto);
                actualizarListaProductos();

                // Limpiar campos después de guardar
                nombre.setText("");
                precio.setText("");

            } catch (NumberFormatException ex) {
                areaProductos.setText("Error: Precio debe ser un número válido.");
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal(sistema).mostrar();
        });

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        // Organización final
        add(panelForm, BorderLayout.NORTH);
        add(areaProductos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarListaProductos();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                new MenuPrincipal(sistema).mostrar();
            }
        });
    }

    private void actualizarListaProductos() {
        areaProductos.setText("");
        for (Producto p : sistema.getListaProductos()) {
            areaProductos.append(p.toString() + "\n");
        }
    }
}