package modelo.Resultados;

import java.io.Serializable;

public class Biblioteca extends Software implements Serializable {

    public Biblioteca(String identificador, int horas, boolean interno, String lenguaje, int numLineas, int numModulos) {

        super(identificador, horas, interno, lenguaje, numLineas, numModulos);
    }
}
