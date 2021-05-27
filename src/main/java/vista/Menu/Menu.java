package vista.Menu;

import java.util.*;

public enum Menu {
    CREAR_PROYECTO("Crar un nuevo proyecto."),
    ABRIR_PROYECTO("Cargar un proyecto guardado."),
    ALTA_PERSONAS("Dar de alta a una persona en el proyecto."),
    ALTA_TAREAS("Dar de alta una tarea en el proyecto."),
    TAREA_FINALIZADA("Marcar una tarea como finalizada."),
    AÑADIR_COLABORADOR("Añadir una persona a una tarea."),
    ELIMINAR_COLABORADOR("Eliminar una persona de una tarea."),
    LISTAR_PERSONAS("Listar personas asignadas de un proyecto."),
    LISTAR_TAREAS("Listar tareas de un proyecto."),
    SALIR("Salir.");


    private String descripcion;
    Menu(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public static Menu getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (Menu opcion : Menu.values()) {
            sb.append(opcion.ordinal() );
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }

    public static int numOpcion(){
        System.out.println(Menu.getMenu());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt() - 1;
        Menu opcionMenu = Menu.getOpcion(opcion);
        System.out.println("Ha elegido: " + opcionMenu);
        return opcion;
    }







}