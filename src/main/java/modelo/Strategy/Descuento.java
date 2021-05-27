package modelo.Strategy;

public class Descuento implements Facturacion {
    public double coste(double coste){
        return coste-coste*0.25;
    }
}
