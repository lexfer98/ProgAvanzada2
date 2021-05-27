package modelo.Genericidad;

import java.util.LinkedList;
import java.util.List;

public class UtilidadesParaListas {

    public static <Object extends tieneLista> List<Object> elementosConListaVacia(List<Object> listaCandidata) {
        List<Object> ListasVacias = new LinkedList<>();
        for (Object e : listaCandidata) {
            if (e.getLista().isEmpty())
                ListasVacias.add(e);
        }
        return ListasVacias;
    }
    public static <E extends tieneClave> boolean estaRepetido (E elemento, List<E> lista) {
        for(E e : lista){
            if (e.getClave().equals(elemento.getClave())){
                return false;
            }
        }
        return true;
    }
}





