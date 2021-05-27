package modelo.Clases;

import modelo.Genericidad.tieneClave;
import modelo.Genericidad.tieneLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personas implements Serializable, tieneLista, tieneClave {

    private String nombre;
    private String correo;
    private List<Tarea> tareasAsignadas = new ArrayList<>();



    public Personas(String nombre, String correo){

        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<Tarea> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public void anyadirTarea(Tarea nombre){
        tareasAsignadas.add(nombre);
    }
    public void eliminarTarea(Tarea nombre){
        tareasAsignadas.remove(nombre);
    }

    public boolean contieneTarea(Tarea t){
        for(Tarea tar:tareasAsignadas){
            if (tar.equals(t)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                " ,correo=" + correo +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personas)) return false;
        Personas personas = (Personas) o;
        return Objects.equals(nombre, personas.nombre);
    }


    @Override
    public List getLista() {
        return tareasAsignadas;
    }

    @Override
    public Object getClave() {
        return nombre;
    }
}