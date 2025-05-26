package clases;

import clases.enums.CategoriaProducto;

import clases.enums.EstadoSolicitud;
import clases.productos.Producto;
import clases.productos.ProductoNoIva;
import clases.solicitudes.DetalleSolicitud;
import clases.solicitudes.SolicitudCompra;
import clases.usuarios.Solicitante;
import clases.visual.Proveedor;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SistemaDeCompras {
    List<Proveedor> listaProveedores = new ArrayList();
    List<DetalleSolicitud> listaDetalleSolicitud = new ArrayList();
    List<SolicitudCompra> listaSolicitudesCompra = new ArrayList();
    List<Producto> listaProductos = new ArrayList();

    public List<Producto> getListaProductos() {
        return this.listaProductos;
    }
    public SistemaDeCompras() {


        Proveedor proveedor1 = new Proveedor(100,"LNS","0982717217","lns@gmail.com");
        Proveedor proveedor2 = new Proveedor(101,"ImpreShop","0981231231","impre@gmail.com");
        Proveedor proveedor3 = new Proveedor(102,"OfiShop","0931231127","oficinaShop@gmail.com");

        listaProveedores.add(proveedor1);
        listaProveedores.add(proveedor2);
        listaProveedores.add(proveedor3);
        Producto producto1 = new ProductoNoIva(100,"Grapadora",7.50, CategoriaProducto.OFICINA,proveedor1);
        Producto producto2 = new ProductoNoIva(101,"Impresora",170.50,CategoriaProducto.HARDWARE,proveedor2);
        Producto producto3 = new ProductoNoIva(102,"Escoba",4,CategoriaProducto.LIMPIEZA,proveedor3);

        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);

        DetalleSolicitud detalleSolicitud1 = new DetalleSolicitud(producto1,3,"Necesario");
        DetalleSolicitud detalleSolicitud2 = new DetalleSolicitud(producto2,1,"Necesario");
        DetalleSolicitud detalleSolicitud3 = new DetalleSolicitud(producto3,2,"Necesario");

        listaDetalleSolicitud.add(detalleSolicitud1);
        listaDetalleSolicitud.add(detalleSolicitud2);
        listaDetalleSolicitud.add(detalleSolicitud3);

        GregorianCalendar fechaActual = new GregorianCalendar();

        Solicitante solicitante1 = new Solicitante(300,"Juan","0982717217","juan@mail.com");
        Solicitante solicitante2 = new Solicitante(301,"Paul","0982717217","paul@mail.com");
        Solicitante solicitante3 = new Solicitante(302, "Diego","0982790380","diego@mail.com");


        SolicitudCompra solicitudCompra1 = new SolicitudCompra(400,solicitante1,fechaActual);
        SolicitudCompra solicitudCompra2 = new SolicitudCompra(401,solicitante2,fechaActual);
        SolicitudCompra solicitudCompra3 = new SolicitudCompra(402,solicitante3,fechaActual);

        solicitudCompra1.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);
        solicitudCompra2.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);
        solicitudCompra3.setEstadoSolicitud(EstadoSolicitud.SOLICITADA);

        solicitudCompra1.agregarDetalle(detalleSolicitud1);
        solicitudCompra2.agregarDetalle(detalleSolicitud2);
        solicitudCompra3.agregarDetalle(detalleSolicitud3);

        listaSolicitudesCompra.add(solicitudCompra1);
        listaSolicitudesCompra.add(solicitudCompra2);
        listaSolicitudesCompra.add(solicitudCompra3);

    }
    public void agregarProveedores(clases.visual.Proveedor proveedor) {
        listaProveedores.add(proveedor);
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

}
