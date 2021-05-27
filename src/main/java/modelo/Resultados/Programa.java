package modelo.Resultados;

import java.io.Serializable;

public class Programa extends Software implements Serializable {

    public Programa(String identificador, int horas, boolean interno, String lenguaje, int numLineas, int numModulos) {

        super(identificador, horas, interno, lenguaje, numLineas, numModulos);
    }
}
