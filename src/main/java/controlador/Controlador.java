package controlador;

import modelo.Clases.ImplModelo;

import java.io.IOException;

public interface Controlador {
    void crearProyecto();
    void abrirProyecto(String ruta) throws IOException, ClassNotFoundException;
    void altaPersona();
    void altaTarea();
    void tareaFinalizada();
    void anyadirColaborador();
    void eliminarColaborador();
//    void modificarCoste();
//    void modificarTipo();
//    void setFechaFin();
    void listarPersonas();
    void listarTareas();
//    void salir(ImplModelo p) throws IOException;

}
