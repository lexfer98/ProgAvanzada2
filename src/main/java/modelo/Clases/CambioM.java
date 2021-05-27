//package modelo.Clases;
//
//import controlador.Excpeciones.FechaNoValidaException;
//import controlador.Excpeciones.PersonaExistenteException;
//import controlador.Excpeciones.PersonaNoExisteException;
//import modelo.Strategy.Facturacion;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//
//public interface CambioM {
//    void altaPersona(String nom, String correo);
//    void altaTarea(String titulo, String descripcion, String responsable,
//                          int prioridad, LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado,
//                          double coste, Facturacion factura) throws FechaNoValidaException;
//    void tareaFinalizada(String nombre);
//    void anyadirColaborador(String tarea, String nombre) throws PersonaExistenteException;
//    void eliminarColaborador(String tarea, String nombre) throws PersonaNoExisteException;
//    void listarPersonas();
//    List<Tarea> listarTareas();
////    void modificarCoste();
////    void modificarTipo();
//    void crearProyecto(String nombre) throws IOException;
//    void abrirProyecto(String ruta) throws IOException, ClassNotFoundException;
//    void salir() throws IOException;
//}
