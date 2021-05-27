package modelo.Clases;

import modelo.Clases.Personas;
import modelo.Clases.Tarea;
import modelo.Resultados.Resultado;

import java.time.LocalDate;
import java.util.List;

public interface InterrogaM {
    String getNombreP() ;
    List<Personas> getListaPersonas();
    List <Tarea> getListaTareas();

}
