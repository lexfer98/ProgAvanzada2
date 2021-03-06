package modelo.Clases;

import controlador.Excpeciones.FechaNoValidaException;
import controlador.Excpeciones.PersonaExistenteException;
import controlador.Excpeciones.PersonaNoExisteException;
import modelo.Strategy.Facturacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto implements Serializable {

    private String nombre;
    private List<Personas> listaPersonas = new ArrayList<>();
    private List<Tarea> listaTareas = new ArrayList<>();

    public Proyecto(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Personas> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Personas> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void altaPersona(String nom, String correo) {
        Personas p = new Personas(nom, correo);
        listaPersonas.add(p);
    }

    public void altaTarea(String titulo, String descripcion, String responsable,
                           int prioridad, LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado, double coste, Facturacion factura) throws FechaNoValidaException {
        if (FechaInicio.compareTo(FechaFin) > 0) throw new FechaNoValidaException();
        Tarea t = new Tarea(titulo, descripcion, responsable, prioridad, FechaInicio, FechaFin, finalizado, coste, factura);
        listaTareas.add(t);
    }




    public void tareaFinalizada(String nombre) {
        for (Tarea t : listaTareas) {
            if (t.getTitulo().equals(nombre)) {
                t.finalizarTarea();
            }
        }
    }

    //cambiar por bucle avanzado
    public void anyadirColaborador(String tarea, String nombre) throws PersonaExistenteException{
        for(Personas p : listaPersonas){
            if(p.getNombre().equals(nombre)){
                for (Tarea t : listaTareas){
                    if(t.getTitulo().equals(tarea)){
                        if(p.contieneTarea(t) == false &&
                                t.contienePersona(p) == false) {
                            p.anyadirTarea(t);
                            t.anyadirColaborador(p);
                        } else{
                            throw new PersonaExistenteException();
                        }
                    }
                }
            }
        }
        //listaPersonas.get(j).a??adirTarea(listaTareas.get(i));
        //listaTareas.get(i).a??adirColaborador(listaPersonas.get(j));


    }



    public void eliminarColaborador(String tarea, String nombre) throws PersonaNoExisteException  {
        for(Personas p : listaPersonas){
            if(p.getNombre().equals(nombre)){
                for (Tarea t : listaTareas){
                    if(t.getTitulo().equals(tarea)){
                        if(p.contieneTarea(t) == true &&
                                t.contienePersona(p) == true) {
                            p.eliminarTarea(t);
                            t.eliminarColaborador(p);
                        } else{
                            throw new PersonaNoExisteException();
                        }
                    }
                }
            }
        }
        //listaPersonas.get(j).eliminarTarea(listaTareas.get(i));
        //listaTareas.get(i).eliminarColaborador(listaPersonas.get(j));


    }

    public void listarPersonas(){
        System.out.println("Las personas asignadas a este proyecto son: ");
        for(int i = 0; i < listaPersonas.size(); i++){
            System.out.print(listaPersonas.get(i).getNombre() + "; ");
        }
        System.out.println(" ");


    }

    public void listarTareas() {
        if (listaTareas.size() == 0) {
            System.out.println("No existen tareas en este proyecto.");
        } else {
            System.out.println("Las tareas existen en este proyecto son : \n");


            for (int i = 0; i < listaTareas.size(); i++) {
                System.out.println("Titulo: " + listaTareas.get(i).getTitulo() + ", Personal: " + listaTareas.get(i).getColaboradores().toString() +
                        ", Finalizada: " + listaTareas.get(i).isFinalizado() + listaTareas.get(i).calcularImporte());
            }
        }
    }

}