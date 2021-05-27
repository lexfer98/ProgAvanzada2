package controlador.Excpeciones;

public class FechaNoValidaException extends Exception{
    public FechaNoValidaException(){
        super("La fecha fin no puede ser antes que la fecha inicio");
    }

}
