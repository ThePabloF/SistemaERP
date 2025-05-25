package clases.visual;


import clases.SistemaDeCompras;

public class Main {
    public static void main(String[] args) {
        SistemaDeCompras sistema = new SistemaDeCompras();
        new MenuPrincipal(sistema).mostrar();
    }
}