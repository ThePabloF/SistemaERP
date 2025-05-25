package clases.visual;



import clases.SistemaDeCompras;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuProveedores extends Frame {
    private SistemaDeCompras sistema;
    private int idProveedores = 103;

    private Panel panelForm;
    private TextField nombre;
    private TextField telefono;
    private TextField correo;
    private TextField buscar;
    private Button btnBuscar;
    private TextArea areaProveedores;

    public MenuProveedores(SistemaDeCompras sistema) {
        this.sistema = sistema;
        mostrar();
    }

    public void mostrar() {
        setTitle("PROVEEDORES");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(new Color(169, 176, 185));

        // Panel de formulario
        panelForm = new Panel(new GridLayout(4, 2, 5, 5));
        panelForm.setBackground(new Color(169, 176, 185));

        nombre = new TextField(10);
        telefono = new TextField(10);
        correo = new TextField(10);
        buscar = new TextField(10);
        btnBuscar = new Button("Buscar");

        panelForm.add(new Label("Nombre:"));
        panelForm.add(nombre);
        panelForm.add(new Label("Teléfono:"));
        panelForm.add(telefono);
        panelForm.add(new Label("Correo:"));
        panelForm.add(correo);
        panelForm.add(new Label("Buscar por ID:"));
        panelForm.add(buscar);

        // Área de texto
        areaProveedores = new TextArea(10, 40);
        areaProveedores.setEditable(false);

        // Panel de botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver al Menú");

        panelBotones.add(btnBuscar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        // Acción Buscar
        btnBuscar.addActionListener(e -> {
            try {
                int idBuscado = Integer.parseInt(buscar.getText());
                List<Proveedor> lista = sistema.getListaProveedores();
                Proveedor encontrado = null;
                for (Proveedor p : lista) {
                    if (p.getId() == idBuscado) {
                        encontrado = p;
                        break;
                    }
                }
                if (encontrado != null) {
                    areaProveedores.setText("Proveedor encontrado:\n" + encontrado.toString());
                } else {
                    areaProveedores.setText("Proveedor con ID " + idBuscado + " no encontrado.");
                }
            } catch (NumberFormatException ex) {
                areaProveedores.setText("Error: ID debe ser un número entero.");
            }
        });

        // Acción Guardar
        btnGuardar.addActionListener(e -> {
            Proveedor proveedor = new Proveedor(idProveedores++, nombre.getText(), telefono.getText(), correo.getText());
            sistema.agregarProveedores(proveedor);
            actualizarListaProveedores();
            nombre.setText("");
            telefono.setText("");
            correo.setText("");
        });

        // Acción Volver
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal(sistema).mostrar();
        });

        // Agregamos al Frame
        add(panelForm, BorderLayout.NORTH);
        add(areaProveedores, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarListaProveedores();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                new MenuPrincipal(sistema).mostrar();
            }
        });

        setVisible(true);
    }

    private void actualizarListaProveedores() {
        areaProveedores.setText("");
        for (Proveedor p : sistema.getListaProveedores()) {
            areaProveedores.append(p.toString() + "\n");
        }
    }
}