package clases.visual;
import clases.SistemaDeCompras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    private SistemaDeCompras sistema;

    public MenuPrincipal(SistemaDeCompras sistema) {
        this.sistema = sistema;
    }
    public MenuPrincipal() {

    }

    public void mostrar() {
        setTitle("MENÚ PRINCIPAL");
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(169, 176, 185)); // gris azulado
        add(mainPanel);

        // Encabezado
        JPanel arriba = new JPanel(new FlowLayout(FlowLayout.LEFT));
        arriba.setBackground(new Color(173, 216, 230)); // celeste claro
//        JLabel logo = new JLabel(new ImageIcon("ruta/del/logo.png")); // logo
        JLabel titulo = new JLabel("MENÚ PRINCIPAL");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
//        header.add(logo);
        arriba.add(titulo);
        mainPanel.add(arriba, BorderLayout.NORTH);

        // Centro





        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setBackground(null);
        Panel centro = new Panel(new FlowLayout(FlowLayout.CENTER,20,30));

        JButton btnProveedores =new JButton("Proveedor");
        btnProveedores.setPreferredSize(new Dimension(160, 160));
        btnProveedores.setFont(new Font("Arial", Font.BOLD, 18));
        btnProveedores.setBackground(new Color(0, 153, 204));
        btnProveedores.setForeground(Color.WHITE);
        btnProveedores.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProveedores.setVerticalTextPosition(SwingConstants.BOTTOM);

        JButton btnProductos = new JButton("Productos");
        btnProductos.setPreferredSize(new Dimension(160, 160));
        btnProductos.setFont(new Font("Arial", Font.BOLD, 18));
        btnProductos.setBackground(new Color(0, 153, 204));
        btnProductos.setForeground(Color.WHITE);
        btnProductos.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(SwingConstants.BOTTOM);

        JButton btnSolicitud = new JButton("Solicitudes");
        btnSolicitud.setPreferredSize(new Dimension(160, 160));
        btnSolicitud.setFont(new Font("Arial", Font.BOLD, 18));
        btnSolicitud.setBackground(new Color(0, 153, 204));
        btnSolicitud.setForeground(Color.WHITE);
        btnSolicitud.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSolicitud.setVerticalTextPosition(SwingConstants.BOTTOM);


        botones.add(btnProveedores);
        botones.add(btnProductos);
        botones.add(btnSolicitud);

        centro.add(botones);
        mainPanel.add(centro, BorderLayout.CENTER);

        // Derecha
        Panel derecha = new Panel(new FlowLayout(FlowLayout.LEFT));
        derecha.setBackground(new Color(169, 176, 185));
        Button btnSalir = new Button("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        derecha.add(btnSalir);
        mainPanel.add(derecha, BorderLayout.SOUTH);

        btnProveedores.addActionListener(e -> {setVisible(false);
            new MenuProveedores(sistema).mostrar();
        });

//        btnProductos.addActionListener(e -> {setVisible(false);
//            new MenuProductos().mostrar();
//        });

       
//
//        btnSolicitud.addActionListener(e -> {setVisible(false);
//            new MenuSolicitudes().mostrar();});
        btnProductos.addActionListener(e -> {
            setVisible(false);
            new MenuProductos(sistema).setVisible(true);
        });


        setVisible(true);



    }
}
