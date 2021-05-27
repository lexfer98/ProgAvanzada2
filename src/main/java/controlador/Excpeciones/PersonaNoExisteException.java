package controlador.Excpeciones;

public class PersonaNoExisteException extends Exception{
    public PersonaNoExisteException(){
        super("No existe la persona");
    }
}
