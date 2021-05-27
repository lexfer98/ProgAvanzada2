package vista;


import controlador.Controlador;
import modelo.Clases.InterrogaM;
import modelo.Clases.Personas;
import modelo.Clases.Tarea;





import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;

public class ImplVista implements InterrogaV {
    private Controlador controlador;
    private InterrogaM modelo;


    //Ventana
    private JFrame ventana;
    //Paneles
    private JPanel jpMenuProyecto;
    private JPanel jpMenuInicio;
    private JPanel jpNuevaPersona;
    private JPanel jpNuevaTarea;
    private JPanel jpAnyadirPersonaTarea;
    private JPanel jpEliminarPersonaTarea;
    private JPanel jpModificarCoste;
    private JPanel jpModificarFacturacion;
    private JPanel jpFinalizarTarea;
    private JPanel jpListarPersonas;
    private JPanel jpListarTareas;
    private JPanel jpCosteProyecto;
    private JPanel jpSalir;

    private JPanel jpError;

    //JTextFields
    JTextField nombreProyecto;
    JTextField nombrePersona;
    JTextField nombreTarea;
    JTextField descripcionTarea;
    JTextField prioridadTarea;
    JTextField resultadoTarea;
    JTextField fechaIniTarea;
    JTextField fechaFinTarea;
    JTextField costeTarea;
    JTextField tipoFacTarea;
    JTextField finalizado;
    JTextField identificador;
    JTextField horas;
    JTextField titulo;
    JTextField responsable;
    JTextField correo;
    JTextField nombreColaborador;
    JTextField porcentaje;
    JTextField interno;

    //JCheckBox
    JCheckBox jbDocum;
    JCheckBox jbProg;
    JCheckBox jbBiblio;
    JCheckBox jbPagW;
    JCheckBox jbConInt;
    JCheckBox jbDesc;
    JCheckBox jbUrg;

    public ImplVista() {
    }

    public void setModelo(InterrogaM modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void cambiarPaneles(JPanel panel1, JPanel panel2) {
        panel1.setVisible(false);
        panel2.setVisible(true);
    }

    private void GUI() {
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);

            ventana = new JFrame("Aplicación");

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                String ruta = selectedFile.getAbsolutePath();
                controlador.abrirProyecto(ruta);
                new CreaMenuInicio();
            } else if (returnValue == JFileChooser.CANCEL_OPTION) {
                new CreaMenuNombreProyecto();
            }
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.getContentPane().setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));

            ventana.pack();
            ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }

    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }

    @Override
    public String getNomProyecto() {
        return nombreProyecto.getText();
    }

    @Override
    public String getCorreo() {
        return correo.getText();
    }

    @Override
    public void mensaje(String msj) {


    }

    @Override
    public String getNomPersona() {
        return nombrePersona.getText();
    }

    @Override
    public String getTitulo() {
        return titulo.getText();
    }

    @Override
    public String getDescripcion() {
        return descripcionTarea.getText();
    }

    @Override
    public String getResponsable() {
        return responsable.getText();
    }

    @Override
    public int getPrioridad() {
        return Integer.parseInt(prioridadTarea.getText());
    }

    @Override
    public String getFechaIni() {
        return fechaIniTarea.getText();
    }

    @Override
    public String getFechaFin() {
        return fechaFinTarea.getText();
    }

    @Override
    public boolean getFinalizado() {
        return Boolean.parseBoolean(finalizado.getText());
    }

    @Override
    public String getIdentificador() {
        return identificador.getText();
    }

    @Override
    public int getHoras() {
        return Integer.parseInt(horas.getText());
    }

//    @Override
//    public Boolean getInterno() {
//        return interno.getBoolean();
//    }

    @Override
    public double getCoste() {
        return Integer.parseInt(costeTarea.getText());
    }

    @Override
    public String getFactura() {
        return tipoFacTarea.getText();
    }

    @Override
    public String getNombreTarea() {
        return nombreTarea.getText();
    }

    @Override
    public String getNombreColaborador() {
        return nombreColaborador.getText();
    }

    @Override
    public File getRuta() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Elige un directorio para guardar el proyecto: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("Has seleccionado el directorio: " + jfc.getSelectedFile());
            }
        }
        return jfc.getSelectedFile();
    }

    class CreaMenuNombreProyecto extends JPanel {
        public CreaMenuNombreProyecto() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpMenuProyecto = new JPanel();
            jpMenuProyecto.setBackground(Color.YELLOW);

            EscuchadorProyecto escuchadorProyecto = new EscuchadorProyecto();

            nombreProyecto = new JTextField(10);

            JLabel nombreLabel = new JLabel("Nombre del proyecto: ");

            JButton jbCrear = new JButton("Crear");
            jbCrear.addActionListener(escuchadorProyecto);
            jbCrear.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorProyecto);

            jpMenuProyecto.add(nombreLabel);
            jpMenuProyecto.add(nombreProyecto);
            jpMenuProyecto.add(jbCrear);
            jpMenuProyecto.add(jbVolver);

            ventana.getContentPane().add(jpMenuProyecto);
            jpMenuProyecto.setVisible(true);
        }
    }

    class EscuchadorProyecto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Crear")) {
                try {
                    controlador.crearProyecto(nombreProyecto.toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                new CreaMenuInicio();
                cambiarPaneles(jpMenuProyecto, jpMenuInicio);
            } else {
                if (texto.equals("Volver")) {
                    cambiarPaneles(jpMenuProyecto, jpMenuInicio);
                }
            }
        }
    }

    class CreaMenuInicio extends JPanel {
        public CreaMenuInicio() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpMenuInicio = new JPanel();
            jpMenuInicio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Menu Principal"));
            jpMenuInicio.setBackground(Color.cyan);

            EscuchadoraMenu escuchadora = new EscuchadoraMenu();

            JCheckBox jbPersona = new JCheckBox("Dar de alta una persona en el proyecto.");
            jbPersona.setBackground(Color.YELLOW);
            jbPersona.addActionListener(escuchadora);
            jpMenuInicio.add(jbPersona);

            JCheckBox jbTarea = new JCheckBox("Dar de alta una tarea en el proyecto.");
            jbTarea.setBackground(Color.orange);
            jbTarea.addActionListener(escuchadora);
            jpMenuInicio.add(jbTarea);

            JCheckBox jbModificarCoste = new JCheckBox("Modificar el coste de una tarea.");
            jbModificarCoste.setBackground(Color.RED);
            jbModificarCoste.addActionListener(escuchadora);
            jpMenuInicio.add(jbModificarCoste);

            JCheckBox jbModificarTipoFac = new JCheckBox("Modificar el tipo de facturación de una tarea.");
            jbModificarTipoFac.setBackground(Color.GREEN);
            jbModificarTipoFac.addActionListener(escuchadora);
            jpMenuInicio.add(jbModificarTipoFac);

            JCheckBox jbFinalizarTarea = new JCheckBox("Finalizar una tarea.");
            jbFinalizarTarea.setBackground(Color.BLUE);
            jbFinalizarTarea.addActionListener(escuchadora);
            jpMenuInicio.add(jbFinalizarTarea);

            JCheckBox jbAsignarPersonaTarea = new JCheckBox("Asignar una persona a una tarea.");
            jbAsignarPersonaTarea.setBackground(Color.YELLOW);
            jbAsignarPersonaTarea.addActionListener(escuchadora);
            jpMenuInicio.add(jbAsignarPersonaTarea);

            JCheckBox jbEliminarPersonaTarea = new JCheckBox("Eliminar una persona de una tarea.");
            jbEliminarPersonaTarea.setBackground(Color.ORANGE);
            jbEliminarPersonaTarea.addActionListener(escuchadora);
            jpMenuInicio.add(jbEliminarPersonaTarea);

            JCheckBox jbListarPersonas = new JCheckBox("Listar personas del proyecto.");
            jbListarPersonas.setBackground(Color.RED);
            jbListarPersonas.addActionListener(escuchadora);
            jpMenuInicio.add(jbListarPersonas);

            JCheckBox jbListarTareas = new JCheckBox("Listar tareas del proyecto.");
            jbListarTareas.setBackground(Color.GREEN);
            jbListarTareas.addActionListener(escuchadora);
            jpMenuInicio.add(jbListarTareas);

            JCheckBox jbCosteProyecto = new JCheckBox("Coste total del proyecto.");
            jbCosteProyecto.setBackground(Color.BLUE);
            jbCosteProyecto.addActionListener(escuchadora);
            jpMenuInicio.add(jbCosteProyecto);

            JCheckBox jbSalir = new JCheckBox("Salir.");
            jbSalir.setBackground(Color.YELLOW);
            jbSalir.addActionListener(escuchadora);
            jpMenuInicio.add(jbSalir);

            ButtonGroup grupo = new ButtonGroup();
            grupo.add(jbPersona);
            grupo.add(jbTarea);
            grupo.add(jbModificarCoste);
            grupo.add(jbModificarTipoFac);
            grupo.add(jbFinalizarTarea);
            grupo.add(jbAsignarPersonaTarea);
            grupo.add(jbEliminarPersonaTarea);
            grupo.add(jbListarPersonas);
            grupo.add(jbListarTareas);
            grupo.add(jbCosteProyecto);
            grupo.add(jbSalir);

            jpMenuInicio.setLayout(new BoxLayout(jpMenuInicio, BoxLayout.PAGE_AXIS));
            ventana.getContentPane().add(jpMenuInicio);
            ventana.setMinimumSize(new Dimension(600, 400));
            ventana.pack();

            jpMenuInicio.setVisible(true);
        }
    }

    class EscuchadoraMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox boton = (JCheckBox) e.getSource();
            String texto = boton.getText();

            switch (texto) {
                case "Dar de alta una persona en el proyecto.":
                    new CreaMenuNuevaPersona();
                    cambiarPaneles(jpMenuInicio, jpNuevaPersona);
                    break;
                case "Dar de alta una tarea en el proyecto.":
                    new CreaMenuNuevaTarea();
                    cambiarPaneles(jpMenuInicio, jpNuevaTarea);
                    break;
                case "Modificar el coste de una tarea.":
                    new CreaModifCoste();
                    cambiarPaneles(jpMenuInicio, jpModificarCoste);
                    break;
                case "Modificar el tipo de facturación de una tarea.":
                    new CreaModifTipoFac();
                    cambiarPaneles(jpMenuInicio, jpModificarFacturacion);
                    break;
                case "Finalizar una tarea.":
                    new CreaFinalizarTarea();
                    cambiarPaneles(jpMenuInicio, jpFinalizarTarea);
                    break;
                case "Asignar una persona a una tarea.":
                    new CreaAsignarPersona();
                    cambiarPaneles(jpMenuInicio, jpAnyadirPersonaTarea);
                    break;
                case "Eliminar una persona de una tarea.":
                    new CreaEliminarPersona();
                    cambiarPaneles(jpMenuInicio, jpEliminarPersonaTarea);
                    break;
                case "Listar personas del proyecto.":
                    new CreaListarPersonas();
                    cambiarPaneles(jpMenuInicio, jpListarPersonas);
                    break;
                case "Listar tareas del proyecto.":
                    new CreaListarTareas();
                    cambiarPaneles(jpMenuInicio, jpListarTareas);
                    break;
//                case "Coste total del proyecto.":
//                    new CreaCosteProyecto();
//                    cambiarPaneles(jpMenuInicio, jpCosteProyecto);
//                    break;
                case "Salir.":
                    new CreaSalir();
                    cambiarPaneles(jpMenuInicio, jpSalir);
                    break;
            }
        }
    }

    class CreaMenuNuevaPersona extends JPanel {
        public CreaMenuNuevaPersona() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpNuevaPersona = new JPanel();
            jpNuevaPersona.setBackground(Color.YELLOW);

            EscuchadorPersona escuchadorPersona = new EscuchadorPersona();

            nombrePersona = new JTextField(10);
            JLabel nombreLabel = new JLabel("Nombre: ");
            jpNuevaPersona.add(nombreLabel);
            jpNuevaPersona.add(nombrePersona);

            correo = new JTextField(20);
            JLabel correoLabel = new JLabel("Correo: ");
            jpNuevaPersona.add(correoLabel);
            jpNuevaPersona.add(correo);

            JButton Anyade = new JButton("Añade");
            Anyade.addActionListener(escuchadorPersona);
            Anyade.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorPersona);

            jpNuevaPersona.add(Anyade);
            jpNuevaPersona.add(jbVolver);

            ventana.getContentPane().add(jpNuevaPersona);
            ventana.setMinimumSize(new Dimension(400, 400));
            ventana.pack();
            jpNuevaPersona.setVisible(false);
        }
    }

    class EscuchadorPersona implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Añade")) {
                controlador.altaPersona();
                cambiarPaneles(jpNuevaPersona, jpMenuInicio);
            } else {
                if (texto.equals("Volver")) {
                    cambiarPaneles(jpNuevaPersona, jpMenuInicio);
                }
            }
        }
    }

    class CreaMenuNuevaTarea extends JPanel {
        public CreaMenuNuevaTarea() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpNuevaTarea = new JPanel();
            jpNuevaTarea.setBackground(Color.YELLOW);

            EscuchadorTarea escuchadorTarea = new EscuchadorTarea();

            nombreTarea = new JTextField(20);
            JLabel nombreLabel = new JLabel("NOMBRE: ");
            jpNuevaTarea.add(nombreLabel);
            jpNuevaTarea.add(nombreTarea);

            descripcionTarea = new JTextField(20);
            JLabel descripLabel = new JLabel("DESCRIPCION: ");
            jpNuevaTarea.add(descripLabel);
            jpNuevaTarea.add(descripcionTarea);

            prioridadTarea = new JTextField(10);
            JLabel prioridadLabel = new JLabel("PRIORIDAD (1-5): ");
            jpNuevaTarea.add(prioridadLabel);
            jpNuevaTarea.add(prioridadTarea);

            JLabel resultadoLabel = new JLabel("RESULTADO TAREA: ");
            jpNuevaTarea.add(resultadoLabel);

            jbDocum = new JCheckBox("Documentación.");
            jbDocum.setBackground(Color.BLUE);
            jpNuevaTarea.add(jbDocum);

            jbProg = new JCheckBox("Programa.");
            jbProg.setBackground(Color.ORANGE);
            jpNuevaTarea.add(jbProg);

            jbBiblio = new JCheckBox("Biblioteca.");
            jbBiblio.setBackground(Color.RED);
            jpNuevaTarea.add(jbBiblio);

            jbPagW = new JCheckBox("Página web.");
            jbPagW.setBackground(Color.GREEN);
            jpNuevaTarea.add(jbPagW);

            ButtonGroup grupo = new ButtonGroup();
            grupo.add(jbDocum);
            grupo.add(jbProg);
            grupo.add(jbBiblio);
            grupo.add(jbPagW);

            fechaFinTarea = new JTextField(20);
            JLabel fechaLabel = new JLabel("FECHA FIN: ");
            jpNuevaTarea.add(fechaLabel);
            jpNuevaTarea.add(fechaFinTarea);

            costeTarea = new JTextField(20);
            JLabel costeLabel = new JLabel("COSTE TAREA: ");
            jpNuevaTarea.add(costeLabel);
            jpNuevaTarea.add(costeTarea);

            JLabel factLabel = new JLabel("TIPO DE FACTURACIÓN TAREA: ");
            jpNuevaTarea.add(factLabel);

            jbConInt = new JCheckBox("Consumo Interno.");
            jbConInt.setBackground(Color.BLUE);
            jpNuevaTarea.add(jbConInt);

            jbDesc = new JCheckBox("Descuento.");
            jbDesc.setBackground(Color.ORANGE);
            jpNuevaTarea.add(jbDesc);

            jbUrg = new JCheckBox("Urgente.");
            jbUrg.setBackground(Color.RED);
            jpNuevaTarea.add(jbUrg);

            porcentaje = new JTextField(20);
            JLabel porcentajeLabel = new JLabel("Introduce porcentaje para Descuento o Urgente: ");
            jpNuevaTarea.add(porcentajeLabel);
            jpNuevaTarea.add(porcentajeLabel);
            jpNuevaTarea.add(porcentaje);

            ButtonGroup grupo2 = new ButtonGroup();
            grupo2.add(jbConInt);
            grupo2.add(jbDesc);
            grupo2.add(jbUrg);

            JButton jbAnyade = new JButton("Añade");
            jbAnyade.addActionListener(escuchadorTarea);
            jbAnyade.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorTarea);

            jpNuevaTarea.add(jbAnyade);
            jpNuevaTarea.add(jbVolver);
            ventana.getContentPane().add(jpNuevaTarea);
            ventana.getContentPane().setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.X_AXIS));
            ventana.pack();

            jpNuevaTarea.setVisible(true);
        }
    }

    class EscuchadorTarea implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Añade")) {
                controlador.altaTarea();
                cambiarPaneles(jpNuevaTarea, jpMenuInicio);
            } else {
                if (texto.equals("Volver")) {
                    cambiarPaneles(jpNuevaTarea, jpMenuInicio);
                }
            }
        }
    }

    class CreaListarPersonas extends JPanel {
        public CreaListarPersonas() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpListarPersonas = new JPanel();
            jpListarPersonas.setBackground(Color.YELLOW);

            EscuchadorListarPersonas escuchadorListar = new EscuchadorListarPersonas();

            ArrayList<Personas> listaPersonas = (ArrayList<Personas>) modelo.getListaPersonas();

            if (listaPersonas.size() == 0) {
                JTextArea texto = new JTextArea();
                texto.append("No hay personas en el proyecto.");
                jpListarPersonas.add(texto);
            } else {
                DefaultListModel model = new DefaultListModel();
                JList<String> lista = new JList<>(model);

                for (int i = 0; i < listaPersonas.size(); i++) {
                    model.addElement(listaPersonas.get(i).getNombre());
                    model.addElement("Tareas asignadas: ");
                    for (Tarea t : listaPersonas.get(i).getTareasAsignadas()) {
                        model.addElement(t.getClave());
                    }
                }
                jpListarPersonas.add(lista);
            }

            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorListar);
            jpListarPersonas.add(jbVolver);

            ventana.add(jpListarPersonas, BorderLayout.CENTER);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

    class EscuchadorListarPersonas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Volver")) {
                cambiarPaneles(jpListarPersonas, jpMenuInicio);
            }
        }
    }

    class CreaListarTareas extends JPanel {
        public CreaListarTareas() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpListarTareas = new JPanel();
            jpListarTareas.setBackground(Color.YELLOW);

            EscuchadorListarTareas escuchadorListar = new EscuchadorListarTareas();

            ArrayList<Tarea> listaTareas = (ArrayList<Tarea>) modelo.getListaTareas();

            if (listaTareas.size() == 0) {
                JTextArea texto = new JTextArea();
                texto.append("No hay tareas en el proyecto.");
                jpListarTareas.add(texto);
            } else {
                DefaultListModel model = new DefaultListModel();
                JList<String> lista = new JList<>(model);

                for (int i = 0; i < listaTareas.size(); i++) {
                    Tarea tarea = listaTareas.get(i);
                    model.addElement(tarea.getTitulo());
                    for (Personas p : tarea.getColaboradores()) {
                        model.addElement(p.getClave());
                    }
                    model.addElement("Coste: " + tarea.getCoste());
                    if (tarea.isFinalizado())
                        model.addElement("La tarea finalizó el " + tarea.getFechaFin());
                    else if (tarea.getFechaFin() == null)
                        model.addElement("La tarea no está finalizada");
                    else
                        model.addElement("La tarea finaliza el " + tarea.getFechaFin());
                }
                jpListarTareas.add(lista);
            }

            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorListar);
            jpListarTareas.add(jbVolver);

            ventana.add(jpListarTareas, BorderLayout.CENTER);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

    class EscuchadorListarTareas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Volver")) {
                cambiarPaneles(jpListarTareas, jpMenuInicio);
            }
        }
    }

    class CreaModifCoste extends JPanel {
        public CreaModifCoste() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpModificarCoste = new JPanel();
            jpModificarCoste.setBackground(Color.YELLOW);

//            EscuchadorModifCoste escuchadorModifCoste = new EscuchadorModifCoste();

            nombreTarea = new JTextField(20);
            JLabel nombreLabel = new JLabel("NOMBRE TAREA: ");
            jpModificarCoste.add(nombreLabel);
            jpModificarCoste.add(nombreTarea);

            costeTarea = new JTextField(20);
            JLabel costeLabel = new JLabel("COSTE TAREA: ");
            jpModificarCoste.add(costeLabel);
            jpModificarCoste.add(costeTarea);

            JButton jbCambiar = new JButton("Cambiar");
//            jbCambiar.addActionListener(escuchadorModifCoste);
            jbCambiar.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
//            jbVolver.addActionListener(escuchadorModifCoste);

            jpModificarCoste.add(jbCambiar);
            jpModificarCoste.add(jbVolver);

            ventana.add(jpModificarCoste, BorderLayout.CENTER);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

//    class EscuchadorModifCoste implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton boton = (JButton) e.getSource();
//            String texto = boton.getText();
//
//            if (texto.equals("Cambiar")) {
//                controlador.modificarCoste();
//                cambiarPaneles(jpModificarCoste, jpMenuInicio);
//            } else if (texto.equals("Volver")) {
//                cambiarPaneles(jpModificarCoste, jpMenuInicio);
//            }
//        }
//    }

    class CreaModifTipoFac extends JPanel {
        public CreaModifTipoFac() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpModificarFacturacion = new JPanel();
            jpModificarFacturacion.setBackground(Color.YELLOW);

//            EscuchadorModifTipoFac escuchadorModifTipoFac = new EscuchadorModifTipoFac();

            nombreTarea = new JTextField(20);
            JLabel nombreLabel = new JLabel("NOMBRE TAREA: ");
            jpModificarFacturacion.add(nombreLabel);
            jpModificarFacturacion.add(nombreTarea);

            JLabel factLabel = new JLabel("TIPO DE FACTURACIÓN TAREA: ");
            jpModificarFacturacion.add(factLabel);

            jbConInt = new JCheckBox("Consumo Interno.");
            jbConInt.setBackground(Color.BLUE);
            jpModificarFacturacion.add(jbConInt);

            jbDesc = new JCheckBox("Descuento.");
            jbDesc.setBackground(Color.ORANGE);
            jpModificarFacturacion.add(jbDesc);

            jbUrg = new JCheckBox("Urgente.");
            jbUrg.setBackground(Color.RED);
            jpModificarFacturacion.add(jbUrg);

            porcentaje = new JTextField(20);
            JLabel porcentajeLabel = new JLabel("Introduce porcentaje para Descuento o Urgente: ");
            jpModificarFacturacion.add(porcentajeLabel);
            jpModificarFacturacion.add(porcentajeLabel);
            jpModificarFacturacion.add(porcentaje);

            ButtonGroup grupo2 = new ButtonGroup();
            grupo2.add(jbConInt);
            grupo2.add(jbDesc);
            grupo2.add(jbUrg);

//            JButton jbCambiar = new JButton("Cambiar");
//            jbCambiar.addActionListener(escuchadorModifTipoFac);
//            jbCambiar.setBackground(Color.CYAN);
//            JButton jbVolver = new JButton("Volver");
//            jbVolver.setBackground(Color.CYAN);
//            jbVolver.addActionListener(escuchadorModifTipoFac);

//            jpModificarFacturacion.add(jbCambiar);
//            jpModificarFacturacion.add(jbVolver);

            ventana.add(jpModificarFacturacion, BorderLayout.CENTER);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

//    class EscuchadorModifTipoFac implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton boton = (JButton) e.getSource();
//            String texto = boton.getText();
//
//            if (texto.equals("Cambiar")) {
//                controlador.modificarTipo();
//                cambiarPaneles(jpModificarFacturacion, jpMenuInicio);
//            } else if (texto.equals("Volver")) {
//                cambiarPaneles(jpModificarFacturacion, jpMenuInicio);
//            }
//        }
//    }

    class CreaFinalizarTarea extends JPanel {
        public CreaFinalizarTarea() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpFinalizarTarea = new JPanel();
            jpFinalizarTarea.setBackground(Color.YELLOW);

            EscuchadorFinalizarTarea escuchadorFinalizarTarea = new EscuchadorFinalizarTarea();

            nombreTarea = new JTextField(20);
            JLabel nombreLabel = new JLabel("NOMBRE TAREA: ");
            jpFinalizarTarea.add(nombreLabel);
            jpFinalizarTarea.add(nombreTarea);

            fechaFinTarea = new JTextField(20);
            JLabel fechaLabel = new JLabel("FECHA FIN: ");
            jpFinalizarTarea.add(fechaLabel);
            jpFinalizarTarea.add(fechaFinTarea);

            JButton jbFinalizar = new JButton("Finalizar ahora");
            jbFinalizar.addActionListener(escuchadorFinalizarTarea);
            jbFinalizar.setBackground(Color.CYAN);
            JButton jbPonerFechaFin = new JButton("Establecer  fecha fin");
            jbPonerFechaFin.addActionListener(escuchadorFinalizarTarea);
            jbPonerFechaFin.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorFinalizarTarea);

            jpFinalizarTarea.add(jbFinalizar);
            jpFinalizarTarea.add(jbPonerFechaFin);
            jpFinalizarTarea.add(jbVolver);

            ventana.add(jpFinalizarTarea, BorderLayout.CENTER);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

    class EscuchadorFinalizarTarea implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            switch (texto) {
                case "Finalizar ahora":
                    controlador.tareaFinalizada();
                    cambiarPaneles(jpFinalizarTarea, jpMenuInicio);
                    break;
//                case "Establecer fecha fin":
//                    controlador.setFechaFin();
//                    cambiarPaneles(jpFinalizarTarea, jpMenuInicio);
//                    break;
                case "Volver":
                    cambiarPaneles(jpFinalizarTarea, jpMenuInicio);
                    break;
            }
        }
    }

    class CreaAsignarPersona extends JPanel {
        public CreaAsignarPersona() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpAnyadirPersonaTarea = new JPanel();
            jpAnyadirPersonaTarea.setBackground(Color.YELLOW);

            EscuchadorAsignarPersona escuchadorAsignarPersona = new EscuchadorAsignarPersona();

            nombreTarea = new JTextField(20);
            JLabel tareaLabel = new JLabel("NOMBRE TAREA: ");
            jpAnyadirPersonaTarea.add(tareaLabel);
            jpAnyadirPersonaTarea.add(nombreTarea);

            nombrePersona = new JTextField(10);
            JLabel personaLabel = new JLabel("NOMBRE PERSONA: ");
            jpAnyadirPersonaTarea.add(personaLabel);
            jpAnyadirPersonaTarea.add(nombrePersona);

            JButton Anyade = new JButton("Añade");
            Anyade.addActionListener(escuchadorAsignarPersona);
            Anyade.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorAsignarPersona);

            jpAnyadirPersonaTarea.add(Anyade);
            jpAnyadirPersonaTarea.add(jbVolver);

            ventana.getContentPane().add(jpAnyadirPersonaTarea);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

    class EscuchadorAsignarPersona implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Añade")) {
                controlador.anyadirColaborador();
                cambiarPaneles(jpAnyadirPersonaTarea, jpMenuInicio);
            } else if (texto.equals("Volver")) {
                cambiarPaneles(jpAnyadirPersonaTarea, jpMenuInicio);
            }
        }
    }

    class CreaEliminarPersona extends JPanel {
        public CreaEliminarPersona() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpEliminarPersonaTarea = new JPanel();
            jpEliminarPersonaTarea.setBackground(Color.YELLOW);

            EscuchadorEliminarPersona escuchadorEliminarPersona = new EscuchadorEliminarPersona();

            nombreTarea = new JTextField(20);
            JLabel tareaLabel = new JLabel("NOMBRE TAREA: ");
            jpEliminarPersonaTarea.add(tareaLabel);
            jpEliminarPersonaTarea.add(nombreTarea);

            nombrePersona = new JTextField(10);
            JLabel personaLabel = new JLabel("NOMBRE PERSONA: ");
            jpEliminarPersonaTarea.add(personaLabel);
            jpEliminarPersonaTarea.add(nombrePersona);

            JButton jbEliminar = new JButton("Eliminar");
            jbEliminar.addActionListener(escuchadorEliminarPersona);
            jbEliminar.setBackground(Color.CYAN);
            JButton jbVolver = new JButton("Volver");
            jbVolver.setBackground(Color.CYAN);
            jbVolver.addActionListener(escuchadorEliminarPersona);

            jpEliminarPersonaTarea.add(jbEliminar);
            jpEliminarPersonaTarea.add(jbVolver);

            ventana.getContentPane().add(jpEliminarPersonaTarea);
            ventana.pack();
            ventana.setVisible(true);
        }
    }

    class EscuchadorEliminarPersona implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("Eliminar")) {
                controlador.eliminarColaborador();
                cambiarPaneles(jpEliminarPersonaTarea, jpMenuInicio);
            } else if (texto.equals("Volver")) {
                cambiarPaneles(jpEliminarPersonaTarea, jpMenuInicio);
            }
        }
    }

//    class CreaCosteProyecto extends JPanel {
//        public CreaCosteProyecto() {
//            super();
//            crearPanel();
//        }

//        private void crearPanel() {
//            jpCosteProyecto = new JPanel();
//            jpCosteProyecto.setBackground(Color.YELLOW);
//
//            EscuchadorCoste escuchadorCoste = new EscuchadorCoste();
//
//            JTextArea textoCoste = new JTextArea();
//            textoCoste.append("El coste total del proyecto es: ");
//            textoCoste.append(Double.toString(modelo.calcularImporte()));
//            jpCosteProyecto.add(textoCoste);
//
//            JButton jbVolver = new JButton("Volver");
//            jbVolver.setBackground(Color.CYAN);
//            jbVolver.addActionListener(escuchadorCoste);
//            jpCosteProyecto.add(jbVolver);
//
//            ventana.add(jpCosteProyecto, BorderLayout.CENTER);
//            ventana.pack();
//            ventana.setVisible(true);
//        }
//    }

    //    class EscuchadorCoste implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton boton = (JButton) e.getSource();
//            String texto = boton.getText();
//
//            if (texto.equals("Volver")) {
//                cambiarPaneles(jpCosteProyecto, jpMenuInicio);
//            }
//        }
//    }
//
    class CreaSalir extends JPanel {
        public CreaSalir() {
            super();
            crearPanel();
        }

        private void crearPanel() {
            jpSalir = new JPanel();
            jpSalir.setBackground(Color.YELLOW);

            EscuchadorSalir escuchadorSalir = new EscuchadorSalir();



            JButton jbSalir = new JButton("Salir");
            jbSalir.setBackground(Color.CYAN);
            jbSalir.addActionListener(escuchadorSalir);

            jpSalir.add(jbSalir);

            ventana.getContentPane().add(jpSalir);
            jpSalir.setVisible(true);
        }
    }

    class EscuchadorSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            switch (texto) {

                case "Salir":
                    try {
                        controlador.salir();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case "Volver":
                    cambiarPaneles(jpSalir, jpMenuInicio);
                    break;
            }
        }
    }
}

