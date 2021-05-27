package modelo.Clases;

import controlador.Excpeciones.FechaNoValidaException;
import controlador.Excpeciones.PersonaExistenteException;
import controlador.Excpeciones.PersonaNoExisteException;
import modelo.Clases.Personas;
import modelo.Clases.Tarea;
import modelo.Resultados.Resultado;
import modelo.Strategy.Facturacion;

import java.time.LocalDate;

public interface CambioM {
    void altaPersona(String nom, String correo);
    void altaTarea(String titulo, String descripcion, String responsable,
                          int prioridad, LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado,
                          double coste, Facturacion factura) throws FechaNoValidaException;
    void tareaFinalizada(String nombre);
    void anyadirColaborador(String tarea, String nombre) throws PersonaExistenteException;
    void eliminarColaborador(String tarea, String nombre) throws PersonaNoExisteException;
    void listarPersonas();
    void listarTareas();
//    void modificarCoste();
//    void modificarTipo();

}
