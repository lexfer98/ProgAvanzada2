package principal;

import controlador.ImplControlador;
import modelo.Clases.ImplementacionModelo;
import vista.ImplVista;
import vista.ImplVista;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Principal {
    public static void main(String args[]) {
        ImplVista vista = new ImplVista();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplControlador controlador = new ImplControlador();
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setControlador(controlador);
        vista.setModelo(modelo);
        vista.creaGUI();
    }
}
