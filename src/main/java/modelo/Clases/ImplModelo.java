package modelo.Clases;

import controlador.Excpeciones.FechaNoValidaException;
import controlador.Excpeciones.PersonaExistenteException;
import controlador.Excpeciones.PersonaNoExisteException;
import modelo.Resultados.Resultado;
import modelo.Strategy.Facturacion;
import vista.InformaV;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplModelo implements Serializable, CambioM, InterrogaM {

    private String nombre;
    private ArrayList<Personas> listaPersonas = new ArrayList<>();
    private List<Tarea> listaTareas = new ArrayList<>();
    private InformaV vista;
    private ImplModelo p;
    public ImplModelo()  {
        super();
    }

    public void setVista(InformaV vista) {
        this.vista = vista;
    }

    public String getNombreP() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Personas> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Personas> listaPersonas) {
        this.listaPersonas = (ArrayList<Personas>) listaPersonas;
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
                          int prioridad, LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado,
                          double coste, Facturacion factura) throws FechaNoValidaException {
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
                        //listaPersonas.get(j).añadirTarea(listaTareas.get(i));
                        //listaTareas.get(i).añadirColaborador(listaPersonas.get(j));


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



    public void crearProyecto(String nombre) {
        p = new ImplModelo();
        p.setNombre(nombre);

    }
    public void abrirProyecto(String ruta) throws IOException, ClassNotFoundException {
        System.out.println("La ruta es:" + ruta);
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.p = (ImplModelo) ois.readObject();
        ois.close();
    }
    @Override
    public void salir() throws IOException {
        FileOutputStream fos = new FileOutputStream(nombre);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject( this.p);
        oos.close();
    }


}