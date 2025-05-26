package clases.visual;

import clases.SistemaDeCompras;
import clases.enums.Departamento;
import clases.enums.EstadoSolicitud;
import clases.productos.Producto;
import clases.solicitudes.DetalleSolicitud;
import clases.solicitudes.SolicitudCompra;
import clases.usuarios.Solicitante;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MenuSolicitudes extends Frame {
    private SistemaDeCompras sistema;
    private TextArea areaSolicitudes;
    private int idSolicitudes = 403;
    private int idDetalles = 201;
    private List<DetalleSolicitud> litDetalles = new ArrayList<>();
    private List<SolicitudCompra> listaSolicitudes = new ArrayList<>();
    private SolicitudCompra solicitudEncontrada = null;

    public MenuSolicitudes(SistemaDeCompras sistema) {
        this.sistema = sistema;
        setTitle("SOLICITUDES DE COMPRA");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setupUI();
    }

    private void setupUI() {
        Panel panelForm = new Panel(new GridLayout(9, 2, 5, 5));
        panelForm.setBackground(new Color(200, 220, 240));

        // Campos solicitante
        TextField nombre = new TextField(10);
        TextField telefono = new TextField(10);
        TextField correo = new TextField(10);
        TextField buscar = new TextField(10);

        // ComboBox de departamentos (enum)
        Choice comboDepartamento = new Choice();
        for (Departamento dep : Departamento.values()) {
            comboDepartamento.add(dep.name());
        }

        // Campos detalle
        Choice comboProducto = new Choice();
        List<Producto> productos = sistema.getListaProductos();
        for (Producto p : productos) {
            comboProducto.add(p.getNombreProducto());
        }

        TextField cantidad = new TextField(5);
        TextField justificacion = new TextField(20);

        // Agregar campos al panel
        panelForm.add(new Label("Nombre Solicitante:"));
        panelForm.add(nombre);
        panelForm.add(new Label("Teléfono:"));
        panelForm.add(telefono);
        panelForm.add(new Label("Correo:"));
        panelForm.add(correo);
        panelForm.add(new Label("Departamento:"));
        panelForm.add(comboDepartamento);
        panelForm.add(new Label("Producto:"));
        panelForm.add(comboProducto);
        panelForm.add(new Label("Cantidad:"));
        panelForm.add(cantidad);
        panelForm.add(new Label("Justificación:"));
        panelForm.add(justificacion);

        // Área de texto
        areaSolicitudes = new TextArea(10, 50);
        areaSolicitudes.setEditable(false);

        // Panel de botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Button btnAgregar = new Button("Agregar");
        Button btnGuardar = new Button("Guardar Solicitud");
        Button btnVolver = new Button("Volver al Menú");
        Button btnBuscar = new Button("Buscar");
        Button btnCambiarEstado = new Button("Cambiar Estado");
        btnCambiarEstado.setVisible(false); // Oculto inicialmente

        panelForm.add(new Label("Agregar Detalle"));
        panelForm.add(btnAgregar);
        panelForm.add(buscar);
        panelForm.add(btnBuscar);

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);
        panelBotones.add(btnCambiarEstado);

        // Organización
        add(panelForm, BorderLayout.NORTH);
        add(areaSolicitudes, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción guardar
        btnGuardar.addActionListener(e -> {
            if (litDetalles.isEmpty()) {
                areaSolicitudes.setText("No se puede guardar la solicitud sin al menos un producto.");
                return;
            }

            String seleccionado = comboDepartamento.getSelectedItem();
            Departamento departamento = Departamento.valueOf(seleccionado);
            GregorianCalendar fechaActual = new GregorianCalendar();

            int id = idSolicitudes++;
            Solicitante solicitante = new Solicitante(id, nombre.getText(), telefono.getText(), correo.getText());
            solicitante.setDepartamento(departamento);

            SolicitudCompra solicitudCompra = new SolicitudCompra(id, solicitante, fechaActual);
            solicitudCompra.agregarlistadetalles(litDetalles);

            listaSolicitudes.add(solicitudCompra);

            // Mostrar todas las solicitudes en el TextArea
            StringBuilder sb = new StringBuilder();
            for (SolicitudCompra s : listaSolicitudes) {
                sb.append(s.toString()).append("\n\n");
            }
            areaSolicitudes.setText(sb.toString());

            // Limpiar para nueva solicitud
            litDetalles.clear();
            nombre.setText("");
            telefono.setText("");
            correo.setText("");
            cantidad.setText("");
            justificacion.setText("");
        });

        // Acción agregar detalle
        btnAgregar.addActionListener(e -> {
            Producto producto = null;
            for (Producto p : productos) {
                if (p.getNombreProducto().equals(comboProducto.getSelectedItem())) {
                    producto = p;
                    break;
                }
            }

            try {
                int cantidadValor = Integer.parseInt(cantidad.getText());
                String justif = justificacion.getText();

                DetalleSolicitud detsol = new DetalleSolicitud(producto, cantidadValor, justif);
                litDetalles.add(detsol);
            } catch (NumberFormatException ex) {
                areaSolicitudes.setText("Cantidad debe ser un número entero.");
            }
        });

        // Acción volver
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuPrincipal(sistema).mostrar();
        });

        // Acción buscar
        btnBuscar.addActionListener(e -> {
            try {
                int idBuscado = Integer.parseInt(buscar.getText().trim());

                solicitudEncontrada = null;
                for (SolicitudCompra s : listaSolicitudes) {
                    if (s.getNumSolicitud() == idBuscado) {
                        solicitudEncontrada = s;
                        btnCambiarEstado.setVisible(true);
                        this.invalidate();
                        this.validate();
                        this.repaint();// mostrar el botón
                        break;
                    }
                }

                if (solicitudEncontrada != null) {
                    areaSolicitudes.setText("Solicitud encontrada:\n\n" + solicitudEncontrada.toString());
                    btnCambiarEstado.setVisible(true); // mostrar el botón
                } else {
                    areaSolicitudes.setText("No se encontró ninguna solicitud con ID: " + idBuscado);
                    btnCambiarEstado.setVisible(false); // ocultar si no se encuentra
                }
            } catch (Exception ex) {
                areaSolicitudes.setText("Por favor ingrese un número válido para buscar.");
                btnCambiarEstado.setVisible(false);
            }
        });

        // Acción cambiar estado
        btnCambiarEstado.addActionListener(e -> {
            if (solicitudEncontrada != null) {
                solicitudEncontrada.cambiarEstadoSolicitud(EstadoSolicitud.APROBADO);
                areaSolicitudes.setText("Estado actualizado a APROBADO:\n\n" + solicitudEncontrada.toString());
                btnCambiarEstado.setVisible(false); // ocultar después de cambiar
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
