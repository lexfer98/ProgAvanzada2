package controlador;

import modelo.Clases.ImplementacionModelo;

import java.io.IOException;

public interface Controlador {
    void altaPersona();
    void altaTarea();
    void tareaFinalizada();
    void anyadirColaborador();
    void eliminarColaborador();
    void listarPersonas();
    void listarTareas();
    void salir() throws IOException;
    void abrirProyecto(String ruta) throws IOException, ClassNotFoundException;
    void crearProyecto(String nombre) throws IOException;



}
