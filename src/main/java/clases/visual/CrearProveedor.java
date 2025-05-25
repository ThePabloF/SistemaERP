package clases.visual;

import clases.SistemaDeCompras;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CrearProveedor extends Frame {
    private SistemaDeCompras sistema;
    private int idProveedores = 103;

    private Panel panelForm;
    private Panel contenido;
    private Panel panelBuscar;
    private TextField nombre;
    private TextField telefono;
    private TextField correo;

    public CrearProveedor(SistemaDeCompras sistema) {
        this.sistema = sistema;
        mostrar();
    }
    public void mostrar() {
        setTitle("CREAR PROVEEDOR");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Panel NORTE
        panelForm = new Panel(new GridLayout(3, 2, 5, 5));
        panelForm.setBackground(new Color(169, 176, 185));

        nombre = new TextField(10);
        telefono = new TextField(10);
        correo = new TextField(10);

        panelForm.add(new Label("Nombre:"));
        panelForm.add(nombre);
        panelForm.add(new Label("Teléfono:"));
        panelForm.add(telefono);
        panelForm.add(new Label("Correo:"));
        panelForm.add(correo);

        // Área de texto para mostrar proveedores
        TextArea areaProveedores = new TextArea(10, 40);
        areaProveedores.setEditable(false);

        // Panel de SUR
        contenido = new Panel(new FlowLayout());
        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver al Menú");
        contenido.add(btnGuardar);
        contenido.add(btnVolver);
        // Paneel CENTRO
        panelBuscar = new Panel(new FlowLayout());
        panelBuscar.add(areaProveedores);


        // Acciones de Botones
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal(sistema).mostrar();
        });


        btnGuardar.addActionListener(e -> {
            Proveedor proveedor = new Proveedor(idProveedores++, nombre.getText(), telefono.getText(), correo.getText());
            sistema.agregarProveedores(proveedor);

            List<Proveedor> lista = sistema.getListaProveedores();

            areaProveedores.setText(""); // Limpiar área antes
            for (Proveedor p : lista) {
                areaProveedores.append(p.toString() + "\n");
            }

            // Limpiar campos
            nombre.setText("");
            telefono.setText("");
            correo.setText("");
        });


        add(panelForm, BorderLayout.NORTH);
        add(contenido, BorderLayout.SOUTH);
        add(panelBuscar, BorderLayout.CENTER);

        setVisible(true);

    }
}
