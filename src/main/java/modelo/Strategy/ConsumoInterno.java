package modelo.Strategy;

public class ConsumoInterno implements Facturacion{
    @Override
    public double coste(double coste){
        return coste;
    }
}
