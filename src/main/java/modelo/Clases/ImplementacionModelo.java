package modelo.Clases;


import controlador.Excpeciones.FechaNoValidaException;
import controlador.Excpeciones.PersonaExistenteException;
import controlador.Excpeciones.PersonaNoExisteException;
import modelo.Strategy.Facturacion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionModelo implements Serializable, CambioModelo2, InterrogaM {

    private Proyecto p;

    public ImplementacionModelo()  {
        super();
    }


    public String getNombreP() {
        return p.getNombre();
    }


    public List<Personas> getListaPersonas() {
        return p.getListaPersonas();
    }



    public List<Tarea> getListaTareas() {
        return p.getListaTareas();
    }


    public void altaPersona(String nom, String correo) {
        p.altaPersona(nom, correo);

    }

    public void altaTarea(String titulo, String descripcion, String responsable,
                          int prioridad, LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado,
                          double coste, Facturacion factura) throws FechaNoValidaException {

        p.altaTarea(titulo,  descripcion,  responsable,
         prioridad,  FechaInicio,  FechaFin,  finalizado, coste,  factura);


    }



    public void tareaFinalizada(String nombre) {
        p.tareaFinalizada(nombre);

    }

    //cambiar por bucle avanzado
    public void anyadirColaborador(String tarea, String nombre) throws PersonaExistenteException{
       p.anyadirColaborador(tarea, nombre);

    }



    public void eliminarColaborador(String tarea, String nombre) throws PersonaNoExisteException  {
        p.eliminarColaborador(tarea, nombre);

    }

    public void  listarPersonas(){
        p.listarPersonas();
    }

    public void listarTareas() {
        p.listarTareas();
    }



    public void crearProyecto(String nombre) {
        p = new Proyecto(nombre);


    }
    public void abrirProyecto(String ruta) throws IOException, ClassNotFoundException {
        System.out.println("La ruta es:" + ruta);
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        p = (Proyecto) ois.readObject();
        ois.close();
    }


    public void salir(String ruta) throws IOException {
        System.out.println("Ruta Salir" + ruta);
        String nombre = ruta.concat("\\").concat(p.getNombre());
        System.out.println("Nombre Salir" + nombre);
        FileOutputStream fos = new FileOutputStream(nombre);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();
    }


}