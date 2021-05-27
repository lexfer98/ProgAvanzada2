package controlador;

import com.sun.org.apache.xpath.internal.operations.Bool;
import controlador.Excpeciones.*;
import modelo.Clases.CambioM;
import vista.InterrogaV;
import vista.Menu.Menu;
import modelo.Clases.*;
import modelo.Resultados.Resultado;
import modelo.Strategy.ConsumoInterno;
import modelo.Strategy.Descuento;
import modelo.Strategy.Facturacion;
import modelo.Strategy.Urgente;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ImplControlador implements Serializable, Controlador {

    ImplModelo p;
    private CambioM modelo;
    private InterrogaV vista;



//   public void crearProyecto(){
//       String nombre = vista.getNomProyecto();
//       p = new ImplModelo();
//       p.setNombre(nombre);
//   }
//    public void abrirProyecto(String ruta) throws IOException, ClassNotFoundException {
//       FileInputStream fis = new FileInputStream(ruta);
//       ObjectInputStream ois = new ObjectInputStream(fis);
//       p = (ImplModelo) ois.readObject();
//       ois.close();
//   }



    @Override


    public void altaPersona(){
       String nom = vista.getNomPersona();
       String correo = vista.getCorreo();
       modelo.altaPersona(nom, correo);
       vista.mensaje(new String("Cliente Dado de alta"));


   }

    public void altaTarea() {

       String titulo = vista.getTitulo();
       String descripcion = vista.getDescripcion();
       String responsable = vista.getResponsable();
       int prioridad = vista.getPrioridad();
       String fechaIni = vista.getFechaIni();
       LocalDate FechaInicio = LocalDate.parse(fechaIni);
       String fechaFin = vista.getFechaFin();
       Boolean finalizado = vista.getFinalizado();
       LocalDate FechaFin = LocalDate.parse(fechaFin);
       String identificador = vista.getIdentificador();
       int horas = vista.getHoras();
       //Boolean interno = vista.getInterno();
       //Resultado result = new Resultado(identificador, horas, interno);
       double coste = vista.getCoste();
       String factura = vista.getFactura();
       Facturacion fact = new ConsumoInterno();
       if (factura.equals("Descuento")){
           fact = new Descuento();
       }
       else if (factura.equals("Urgente")){
           fact = new Urgente();
       }
       try {
           modelo.altaTarea(titulo, descripcion, responsable, prioridad, FechaInicio, FechaFin, finalizado,
                    coste, fact);

       } catch (FechaNoValidaException e) {
           e.printStackTrace();
       }
   }

    public void tareaFinalizada(){
       String nombreTarea = vista.getNombreTarea();
       modelo.tareaFinalizada(nombreTarea);
   }


    public void anyadirColaborador(){
       String nombreTarea = vista.getNombreTarea();
       String nombreColaborador = vista.getNombreColaborador();
       try {
           modelo.anyadirColaborador(nombreTarea, nombreColaborador);

       } catch (PersonaExistenteException e) {
           e.printStackTrace();
       }

   }

    public void eliminarColaborador(){
        String nombreTarea = vista.getNombreTarea();
        String nombreColaborador = vista.getNombreColaborador();
        try {
            modelo.eliminarColaborador(nombreTarea, nombreColaborador);
        } catch (PersonaNoExisteException e) {
            e.printStackTrace();
        }
    }

    public void listarPersonas(){
        modelo.listarPersonas();
    }

    public void listarTareas(){
        modelo.listarTareas();


    }
    @Override
    public void crearProyecto(String nombre) throws IOException {
        modelo.crearProyecto(nombre);
    }

    @Override
    public void abrirProyecto(String ruta) throws IOException, ClassNotFoundException {
        modelo.abrirProyecto(ruta);
    }

    public void salir() throws IOException {

        modelo.salir();

    }

    public void setModelo(CambioM modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaV vista) {
        this.vista = vista;
    }

}
