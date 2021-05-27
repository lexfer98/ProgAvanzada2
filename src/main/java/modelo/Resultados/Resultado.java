package modelo.Resultados;

import java.io.Serializable;

public class Resultado implements Serializable {


    private String identificador;
    private int horas;
    private boolean interno;

    @Override
    public String toString() {
        return "Resultado{" +
                "identificador='" + identificador + '\'' +
                ", horas=" + horas +
                ", interno=" + interno +
                '}';
    }

    public Resultado(String identificador, int horas, boolean interno){

        this.identificador = identificador;
        this.horas = horas;
        this.interno = interno;
    }
}
