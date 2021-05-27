package controlador.Excpeciones;

public class PersonaExistenteException extends Exception{
    public PersonaExistenteException(){
        super("La persona ya existe en una tarea");
    }
}
