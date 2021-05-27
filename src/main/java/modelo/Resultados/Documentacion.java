package modelo.Resultados;

import java.io.Serializable;

public class Documentacion extends Resultado implements Serializable {

    private String formato;
    private int numPaginas;
    private int espacio;

    public Documentacion(String identificador, int horas, boolean interno, String formato, int numPaginas,
                         int espacio) {

        super(identificador, horas, interno);
        this.formato = formato;
        this.numPaginas = numPaginas;
        this.espacio = espacio;
    }
}
