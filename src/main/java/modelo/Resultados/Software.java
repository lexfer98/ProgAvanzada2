package modelo.Resultados;

import java.io.Serializable;

public class Software extends Resultado implements Serializable {
    private String lenguaje;
    private int numLineas;
    private int numModulos;

    public Software(String identificador, int horas, boolean interno, String lenguaje,int numLineas, int numModulos){

        super(identificador, horas, interno);
        this.lenguaje = lenguaje;
        this.numLineas = numLineas;
        this.numModulos = numModulos;
    }
}
