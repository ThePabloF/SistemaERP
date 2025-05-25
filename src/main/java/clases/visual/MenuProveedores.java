package clases.visual;


import clases.SistemaDeCompras;

import javax.print.attribute.standard.PrinterName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuProveedores extends Frame {
    private SistemaDeCompras sistema;

    private int idProveedores = 103;

    private Panel panelForm;
    private Panel contenido;
    private Panel panelBuscar;
    private TextField nombre;
    private TextField telefono;
    private TextField correo;
    private TextField buscar;
    private Button btnBuscar;
    public MenuProveedores(SistemaDeCompras sistema) {
        this.sistema = sistema;
        mostrar();
    }
    public void mostrar() {
        setTitle("PROVEEDORES");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(new Color(169, 176, 185));

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
        // Área de texto para mostrar proveedoresa
        TextArea areaProveedores = new TextArea(10, 40);
        TextArea areaProveedoresB = new TextArea(10, 40);
        llenarAreaProveedores(areaProveedores);
        llenarAreaProveedores(areaProveedoresB);

        areaProveedores.setEditable(false);

        // Panel de CENTRO
        contenido = new Panel(new GridLayout(1,2));
        Button btnGuardar = new Button("Guardar");
        Panel centroDerecha = new Panel(new FlowLayout(FlowLayout.CENTER));
        centroDerecha.setBackground(Color.ORANGE);
        Panel centroIzquierda = new Panel(new FlowLayout(FlowLayout.CENTER));
        centroIzquierda.setBackground(Color.GREEN);
        centroDerecha.add(btnGuardar);
        centroIzquierda.add(areaProveedores);
        contenido.add(centroIzquierda, BorderLayout.WEST);
        contenido.add(centroDerecha, BorderLayout.EAST);




        // Panel de SUR
        panelBuscar = new Panel(new GridLayout(1,2));
        Panel buscarIzquierda = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel buscarDerecha = new Panel(new FlowLayout(FlowLayout.CENTER));

        Button btnVolver = new Button("Volver al Menú");
        btnBuscar = new Button("Buscar");
        buscar = new TextField(10);

        buscarIzquierda.add(btnBuscar);
        buscarIzquierda.add(buscar);
        buscarIzquierda.add(areaProveedoresB);

        buscarDerecha.add(btnVolver);
        panelBuscar.add(buscarIzquierda);
        panelBuscar.add(buscarDerecha);

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
            areaProveedoresB.setText("");
            for (Proveedor p : lista) {
                areaProveedores.append(p.toString() + "\n");
                areaProveedoresB.append(p.toString() + "\n");
            }

            // Limpiar campos
            nombre.setText("");
            telefono.setText("");
            correo.setText("");
        });


        add(panelForm, BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
        add(panelBuscar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void llenarAreaProveedores(TextArea area) {
        area.setText(""); // Limpia antes de escribir
        List<Proveedor> lista = sistema.getListaProveedores();
        for (Proveedor p : lista) {
            area.append(p.toString() + "\n");
        }
    }


}
