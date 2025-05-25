package clases.usuarios;

import clases.Usuario;
import clases.enums.Departamento;

public class Solicitante extends Usuario {
    private Departamento departamento;


    public Solicitante(int id, String nombre, String telefono, String correo) {
        super(id, nombre, telefono, correo);
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "departamento=" + departamento +
                '}';
    }
}
