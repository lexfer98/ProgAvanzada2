package modelo.Resultados;

import java.io.Serializable;

public class PaginaWeb extends Resultado implements Serializable {

    private boolean estatica;
    private String lenguaje;
    private String backend;

    public PaginaWeb(String identificador, int horas, boolean interno, boolean estatica, String lenguaje,
                     String backend) {


        super(identificador, horas, interno);
        this.estatica = estatica;
        this.lenguaje = lenguaje;
        this.backend = backend;
    }
}
