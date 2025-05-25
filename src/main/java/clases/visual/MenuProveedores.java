package clases.visual;



import clases.SistemaDeCompras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class MenuProveedores extends JFrame {
    private SistemaDeCompras sistema;
    private int idProveedores = 103;
    private JTextArea areaProveedores;

    public MenuProveedores(SistemaDeCompras sistema) {
        this.sistema = sistema;
    }
    public void mostrar() {
        setTitle("MENÚ PRINCIPAL");
        setSize(600, 500);
        setLocationRelativeTo(null);


        // Panel de formulario
        Panel panelForm = new Panel(new GridLayout(3, 2, 5, 5));
        panelForm.setBackground(new Color(169, 176, 185)); // gris azulado
        add(panelForm);
        // Campos del formulario
        JTextField nombre = new JTextField(10);
        JTextField telefono = new JTextField(10);
        JTextField correo = new JTextField(10);

        panelForm.add(new Label("Nombre:"));
        panelForm.add(nombre);
        panelForm.add(new Label("Teléfono:"));
        panelForm.add(telefono);
        panelForm.add(new Label("Correo:"));
        panelForm.add(correo);

        // Área de texto para mostrar proveedores
        areaProveedores = new JTextArea(10, 40);
        areaProveedores.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaProveedores);


        // Panel de botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver al Menú");

        btnVolver.addActionListener(e -> {
           dispose();
            new MenuPrincipal(sistema).mostrar();
        });

        // GUARDANDO
        btnGuardar.addActionListener(e -> {
            Proveedor proveedor = new Proveedor(idProveedores++, nombre.getText(), telefono.getText(), correo.getText());
            sistema.agregarProveedores(proveedor);

            List<Proveedor> lista = sistema.getListaProveedores();

            areaProveedores.setText("");
            for (Proveedor p : lista) {
                areaProveedores.append(p.toString() + "\n");
            }



        });
        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        // Organización final
        add(panelForm, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                new MenuPrincipal().mostrar();
            }
        });

        setVisible(true);
    }
}
