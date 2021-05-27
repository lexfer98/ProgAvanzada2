//import controlador.Excpeciones.FechaNoValidaException;
//import controlador.Excpeciones.PersonaExistenteException;
//import controlador.Excpeciones.PersonaNoExisteException;
//import modelo.Clases.Personas;
//import modelo.Clases.ImplementacionModelo;
//import modelo.Clases.Tarea;
//import modelo.Resultados.Resultado;
//import modelo.Strategy.*;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AplicationTest {
//
//    ImplementacionModelo p = new ImplModelo();
//
//    @Test
//    void altaPersona(){
//        p.setNombre("Proyecto");
//        //Comprobocacion 1
//        Personas per = new Personas("Antonio", "molon@gmail.com");
//        ArrayList<Personas> resultado = new ArrayList<>();
//        resultado.add(per);
//        p.altaPersona("Antonio", "molon@gmail.com");
//
//        Personas[] vecSol = new Personas[2];
//        Personas[] vecComparar = new Personas[2];
//
//        //Pasarle a vecSol odo lo que tiene el vector resultado
//        resultado.toArray(vecSol);
//        //Pasarle lo que haga getList a vecComparar
//        p.getListaPersonas().toArray(vecComparar);
//        //Comparo
//        assertArrayEquals(vecSol, vecComparar);
//
//
//        //Comprobacion 2
//        per = new Personas("Doraemon", "gato@gmail.com");
//        resultado.add(per);
//
//        p.altaPersona("Doraemon", "gato@gmail.com");
//        resultado.toArray(vecSol);
//
//        p.getListaPersonas().toArray(vecComparar);
//
//        assertArrayEquals(vecSol, vecComparar);
//    }
//    @Test
//    void altaTarea() throws FechaNoValidaException {
//        p = new ImplModelo();
//        p.setNombre("Proyecto");
//
//        Resultado res = new Resultado("cor2", 5, true);
//        Urgente urg = new Urgente();
//        Tarea t = new Tarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//
//        ArrayList<Tarea> resultado = new ArrayList<>();
//        resultado.add(t);
//
//        Tarea[] vecSol = new Tarea[2];
//        resultado.toArray(vecSol);
//
//        p.altaTarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,10.0, urg);
//        Tarea[] vecComp = new Tarea[2];
//        p.getListaTareas().toArray(vecComp);
//
//        assertArrayEquals(vecSol, vecComp);
//
//        //assertThrows(FechaNoValidaException.class, ()-> t.setFechaFin(LocalDate.now()));
//
//    }
//
//    @Test
//    void tareaFinalizada() throws FechaNoValidaException {
//
//        p = new ImplModelo();
//        p.setNombre("Proyecto");
//
//        Urgente urg = new Urgente();
//        Resultado res = new Resultado("cor2", 5, true);
//        Tarea t = new Tarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//
//        p.altaTarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//
//        assertFalse(t.isFinalizado());
//
//        t.finalizarTarea();
//        p.tareaFinalizada("Correr");
//        assertTrue(t.isFinalizado());
//
//
//
//    }
//
//    @Test
//    void anyadirColaborador() throws PersonaExistenteException, FechaNoValidaException {
//
//        p = new ImplModelo();
//        p.setNombre("Proyecto");
//
//
//        Personas per = new Personas("Alex", "alex@gmail.com");
//        Urgente urg = new Urgente();
//        Resultado res = new Resultado("cor2", 5, true);
//        Tarea t = new Tarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//
//
//
//        p.altaTarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false, 10.0, urg);
//
//        p.anyadirColaborador("Correr","Alex");
//        t.anyadirColaborador(per);
//        boolean sol = t.contienePersona(per);
//        System.out.println(sol);
//
//        assertTrue(sol);
//        //assertFalse(t.contienePersona(per1));
//
//
//
//
//
//
//
//    }
//
//    @Test
//    void eliminarColaborador() throws PersonaExistenteException, PersonaNoExisteException, FechaNoValidaException {
//
//        p = new ImplModelo();
//        p.setNombre("Proyecto");
//
//        Urgente urg = new Urgente();
//        Personas per = new Personas("Alex", "alex@gmail.com");
//        Resultado res = new Resultado("cor2", 5, true);
//        Tarea t = new Tarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//        p.altaTarea("Correr", "hay que correr", null, 2, LocalDate.now(),
//                LocalDate.now(),false,  10.0, urg);
//
//        p.anyadirColaborador("Alex", "correr");
//        t.eliminarColaborador(per);
//        assertFalse(t.contienePersona(per));
//
//        p.eliminarColaborador("Alex", "correr");
//        assertFalse(t.contienePersona(per));
//
//
//
//
//
//
//    }
//
//}
