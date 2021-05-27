package vista;

import java.io.File;

public interface InterrogaV {

    File getRuta();

    String getNomProyecto();

    String getCorreo();

    void mensaje(String msj);

    String getNomPersona();

    String getTitulo();

    String getDescripcion();

    String getResponsable();

    int getPrioridad();

    String getFechaIni();

    String getFechaFin();

    boolean getFinalizado();

    String getIdentificador();

    int getHoras();

    //Boolean getInterno();

    double getCoste();

    String getFactura();

    String getNombreTarea();

    String getNombreColaborador();
}
