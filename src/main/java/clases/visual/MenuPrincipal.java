package clases.visual;

import clases.SistemaDeCompras;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends Frame {
    private SistemaDeCompras sistema;

    public MenuPrincipal(SistemaDeCompras sistema) {
        this.sistema = sistema;
        mostrar();
    }

    public void mostrar() {
        setTitle("MENÚ PRINCIPAL");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(new Color(169, 176, 185));

        // Encabezado
        Panel arriba = new Panel(new FlowLayout(FlowLayout.LEFT));
        arriba.setBackground(new Color(173, 216, 230));
        Label titulo = new Label("MENÚ PRINCIPAL");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        arriba.add(titulo);
        add(arriba, BorderLayout.NORTH);

        // Centro
        Panel centro = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        Panel botones = new Panel(new FlowLayout(FlowLayout.LEFT));

        Button btnProveedores = new Button("Proveedor");
        btnProveedores.setPreferredSize(new Dimension(160, 160));
        btnProveedores.setFont(new Font("Arial", Font.BOLD, 18));
        btnProveedores.setBackground(new Color(0, 153, 204));
        btnProveedores.setForeground(Color.WHITE);

        Button btnProductos = new Button("Productos");
        btnProductos.setPreferredSize(new Dimension(160, 160));
        btnProductos.setFont(new Font("Arial", Font.BOLD, 18));
        btnProductos.setBackground(new Color(0, 153, 204));
        btnProductos.setForeground(Color.WHITE);

        Button btnSolicitud = new Button("Solicitudes");
        btnSolicitud.setPreferredSize(new Dimension(160, 160));
        btnSolicitud.setFont(new Font("Arial", Font.BOLD, 18));
        btnSolicitud.setBackground(new Color(0, 153, 204));
        btnSolicitud.setForeground(Color.WHITE);

        botones.add(btnProveedores);
        botones.add(btnProductos);
        botones.add(btnSolicitud);
        centro.add(botones);
        add(centro, BorderLayout.CENTER);

        // Pie
        Panel derecha = new Panel(new FlowLayout(FlowLayout.LEFT));
        derecha.setBackground(new Color(169, 176, 185));
        Button btnSalir = new Button("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        derecha.add(btnSalir);
        add(derecha, BorderLayout.SOUTH);

        // Acción botón Proveedores
        btnProveedores.addActionListener(e -> {
            setVisible(false);
            new MenuProveedores(sistema);
        });

        // Acción para cerrar con la X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
