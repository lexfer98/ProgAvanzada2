package modelo.Strategy;

public class Urgente implements Facturacion {
    public double coste(double coste){
        return coste*1.2;
    }
}
