/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.user_interface.fundacaqueta;

//Java imports
import java.util.ArrayList;
import java.time.Period;
import java.time.LocalDate;
import javax.swing.DefaultListModel;

//Logic imports
import com.logic.fundacaqueta.Fundacaqueta;
import com.logic.fundacaqueta.Proyecto;
import com.logic.fundacaqueta.Profesional;
import com.logic.fundacaqueta.Actividad;
import com.logic.fundacaqueta.ContratoColaboracion;
import com.logic.fundacaqueta.ContratoLaboral;

//Interface imports
import com.user_interface.fundacaqueta.Interfaces.Proyecto.*;
import com.user_interface.fundacaqueta.Interfaces.Profesional.*;
import com.user_interface.fundacaqueta.Interfaces.Actividad.*;
import com.user_interface.fundacaqueta.Interfaces.Contrato.*;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
/**
 *
 * @author nebel
 */
public class InterfazAdmin extends javax.swing.JFrame {

    private Fundacaqueta fundacaqueta;
    
    private Proyecto proyectoSeleccionado;
    
    private Profesional profesionalSeleccionado;
    
    private ContratoColaboracion contratoSeleccionado;
    
    public final static int ELIMINAR_PROFESIONAL = 1;
    /**
     * Creates new form InterfazAdmin
     */
    public InterfazAdmin(Fundacaqueta fundacaqueta) {
        initComponents();
        this.fundacaqueta = fundacaqueta;
        this.profesionalSeleccionado = null;
        this.contratoSeleccionado = null;
        showProjects();
    }
    
    public Profesional obtenerProfesionalSeleccionado(){
        return profesionalSeleccionado;
    }
    
    private void showProjects(){
        ArrayList<Proyecto> proyectos = fundacaqueta.obtenerProyectos();
        DefaultListModel nombresProyectos = new DefaultListModel();
        for(Proyecto proyecto : proyectos){
            nombresProyectos.addElement(proyecto.obtenerNombre());
        }
        ListProyectos.setModel(nombresProyectos);
        ListProyectos.setSelectedValue(proyectos.get(0).obtenerNombre(),true);
        proyectoSeleccionado = proyectos.get(0);
    }
    
    public void updateProjects(){
        if(fundacaqueta.obtenerProyectos().size()>0)
            showProjects();
        else{
            DefaultListModel nombresProyectos = new DefaultListModel();
            ListProyectos.setModel(nombresProyectos);
        }
    }
    
    private void showProfessionals(){
        if(proyectoSeleccionado!=null){
            ArrayList<Profesional> profesionales = proyectoSeleccionado.obtenerProfesionales();
            DefaultListModel nombreProfesionales = new DefaultListModel();
            for(Profesional profesional : profesionales){
                nombreProfesionales.addElement(profesional.obtenerNombre());
            }
            ListProfesionales.setModel(nombreProfesionales);
        }
    }
    
    public Proyecto obtainSelectedProject(){
        if(proyectoSeleccionado == null){
            String nombreProyectoSeleccionado = ListProyectos.getSelectedValue();
            if(nombreProyectoSeleccionado != null){
                for(Proyecto proyecto : fundacaqueta.obtenerProyectos()){
                    if(proyecto.obtenerNombre().equals(nombreProyectoSeleccionado))
                        return proyectoSeleccionado = proyecto;
                }
            }
        }
        return proyectoSeleccionado;
    }
    
    private Profesional obtainSelectedProfessional(){
        String nombreProfesionalSeleccionado = ListProfesionales.getSelectedValue();
        if(nombreProfesionalSeleccionado != null)
            for(Profesional profesional : obtainSelectedProject().obtenerProfesionales()){
                if(profesional.obtenerNombre().equals(nombreProfesionalSeleccionado))
                    profesionalSeleccionado = profesional;
            }
        return profesionalSeleccionado;
    }
    
    private Actividad obtainSelectedActivity(){
        Actividad actividadSeleccionada = null;
        
        String nombreActividadSeleccionada = ListActividadesProy.getSelectedValue();
        for(Actividad actividad : proyectoSeleccionado.obtenerActividades()){
            if(actividad.obtenerNombre().equals(nombreActividadSeleccionada))
                actividadSeleccionada = actividad;
        }
        
        return actividadSeleccionada;
    }
    
    public Actividad obtainSelectedProfessionalActivity(){
        Actividad actividadSeleccionada = null;
        if(profesionalSeleccionado != null){
            String nombreActividadSeleccionada = ListActividadesProf.getSelectedValue();
            for(Actividad actividad : profesionalSeleccionado.obtenerActividades()){
                if(actividad.obtenerNombre().equals(nombreActividadSeleccionada))
                    actividadSeleccionada = actividad;
            }
        }
        return actividadSeleccionada;
    }
    
    public ContratoColaboracion obtainSelectedContrato(){
        String objetivoContrato = ListContratosProy.getSelectedValue();
        for (ContratoColaboracion contrato : proyectoSeleccionado.obtenerContratos()) {
            if (contrato.obtenerObjetivo().equals(objetivoContrato)) {
                return contratoSeleccionado = contrato;
            }
        }
        return contratoSeleccionado;
    }
    
    private void showProfessionalActivities(){
        profesionalSeleccionado = obtainSelectedProfessional();
        DefaultListModel nombreActividades = new DefaultListModel();
        if(profesionalSeleccionado != null){
            for(Actividad actividad : profesionalSeleccionado.obtenerActividades()){
                nombreActividades.addElement(actividad.obtenerNombre());
            }
        }
        ListActividadesProf.setModel(nombreActividades);   
    }
    
    private void showProjectActivities(){
        DefaultListModel nombreActividades = new DefaultListModel();
        proyectoSeleccionado = obtainSelectedProject();
        if(proyectoSeleccionado != null){
            ArrayList<Actividad> actividadesProyecto = proyectoSeleccionado.obtenerActividades();
            if(!actividadesProyecto.isEmpty()){
                for(int i = 0; i < actividadesProyecto.size(); i++){
                    nombreActividades.addElement(actividadesProyecto.get(i).obtenerNombre());
                }
            }
        }
        ListActividadesProy.setModel(nombreActividades);
    }
    
    private void showProjectContracts(){
        DefaultListModel objetivosContratos = new DefaultListModel();
        if(proyectoSeleccionado!=null){
            for(ContratoColaboracion contrato : proyectoSeleccionado.obtenerContratos()){
                objetivosContratos.addElement(contrato.obtenerObjetivo());
            }
        }
        ListContratosProy.setModel(objetivosContratos);
    }
    
    private void showDetailsProject(){
        proyectoSeleccionado = obtainSelectedProject();
        if(proyectoSeleccionado != null){
            TxtLugarEjecucion.setText(proyectoSeleccionado.obtenerLugarEjecucion());
            TxtTipo.setText(proyectoSeleccionado.obtenerTipo());
            TxtFechaInicio.setText(proyectoSeleccionado.obtenerFechaInicio().toString());
            TxtFechaFin.setText("No ha finalizado");
            if(proyectoSeleccionado.obtenerFechaFin() != null)
                TxtFechaFin.setText(proyectoSeleccionado.obtenerFechaFin().toString());
        }
        else{
            TxtLugarEjecucion.setText("");
            TxtTipo.setText("");
            TxtFechaInicio.setText("");
            TxtFechaFin.setText("");
        }
    }
    
    private void showDetailsProfessional(){
        profesionalSeleccionado = obtainSelectedProfessional();
        if(profesionalSeleccionado != null){
            TxtCargo.setText(profesionalSeleccionado.obtenerCargo());
            TxtPerfil.setText(profesionalSeleccionado.obtenerPerfil());
            String edadProfesional = "";
            Period edad = Period.between(profesionalSeleccionado.obtenerFechaNacimiento(), LocalDate.now());
            edadProfesional = edad.getYears() + " años";
            TxtEdad.setText(edadProfesional);
        }
        else{
            TxtCargo.setText("");
            TxtPerfil.setText("");
            TxtEdad.setText("");
        }
    }
    
    private void showDetailsProfessionalActivity(){
        Actividad actividadSeleccionada = obtainSelectedProfessionalActivity();
        if(actividadSeleccionada!=null){
            TxtDescripcionActividadProf.setText(actividadSeleccionada.obtenerDescripcion());
            TxtAreaActividadProf.setText(actividadSeleccionada.obtenerArea());
        } 
        else {
            TxtDescripcionActividadProf.setText("");
            TxtAreaActividadProf.setText("");
        }
    }
    
    private void showDetailsProjectActivity(){
        Actividad actividadSeleccionada = obtainSelectedActivity();
        if(actividadSeleccionada!=null){
            TxtDescripcionActividadesProy.setText(actividadSeleccionada.obtenerDescripcion());
            TxtAreaActividadesProy.setText(actividadSeleccionada.obtenerArea());
        }
        else{
            TxtDescripcionActividadesProy.setText("");
            TxtAreaActividadesProy.setText("");
        }
    }
    
    private void showDetailsContract(){
        contratoSeleccionado = obtainSelectedContrato();
        TxtTipoContrato.setText(contratoSeleccionado.obtenerTipo());
        TxtValorContrato.setText(Double.toString(contratoSeleccionado.obtenerValor()));
        TxtFechaInicioContrato.setText(contratoSeleccionado.obtenerFechaInicio().toString());
        TxtDuracion.setText(contratoSeleccionado.obtenerDuracion());
    }
    
    public void filtrarProyectosPorFechas(String fechaInicio, String fechaFin){
        LocalDate fechaInicioProyectos = formatearFecha(fechaInicio);
        LocalDate fechaFinProyectos = formatearFecha(fechaFin);
        DefaultListModel proyectosPorFecha = new DefaultListModel();
        
        if(fechaInicioProyectos!=null){    
            ListModel<String> proyectosEnVista = ListProyectos.getModel();
            for(int i = 0; i < proyectosEnVista.getSize(); i++){
                Proyecto proyectoBuscado = fundacaqueta.obtenerProyectoPorNombre(proyectosEnVista.getElementAt(i));
                if(proyectoBuscado!=null){
                    boolean fechaInicioEstaDentroRango = proyectoBuscado.obtenerFechaInicio().isAfter(fechaInicioProyectos)
                            || proyectoBuscado.obtenerFechaInicio().isEqual(fechaInicioProyectos);
                    
                    boolean fechaFinEstaDentroRango = true;
                    
                    if(fechaFinProyectos!=null)
                        fechaFinEstaDentroRango = proyectoBuscado.obtenerFechaFin()==null 
                            || proyectoBuscado.obtenerFechaFin().isBefore(fechaFinProyectos)
                            || proyectoBuscado.obtenerFechaFin().isEqual(fechaFinProyectos);
                    
                    if(fechaInicioEstaDentroRango && fechaFinEstaDentroRango)
                        proyectosPorFecha.add(i, proyectoBuscado.obtenerNombre());
                }
            }
        }
        ListProyectos.setModel(proyectosPorFecha);
    }
    
    private LocalDate formatearFecha(String fecha){
        if(fecha.equals(""))
            return null;
        
        String[] divisionFecha = fecha.split("/");
        int dias = Integer.parseInt(divisionFecha[0]);
        int meses = Integer.parseInt(divisionFecha[1]);
        int años = Integer.parseInt(divisionFecha[2]);
        
        boolean fechaValida = dias<=31 && meses <= 12 && años>=0;
        
        if(fechaValida)
            return LocalDate.of(años, meses, dias);
        else{
            String error = "La fecha indicada " + dias + "/" + meses + "/" + años + "es invalida";
            JOptionPane.showMessageDialog(this, error, "Fecha Invalida", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void filtrarProyectosSegunValor(double valor, String condicion){
        DefaultListModel<String> nuevosProyectosEnPantalla = new DefaultListModel<String>();
        ArrayList proyectosPorValor = fundacaqueta.obtenerProyectoPorValor(valor, condicion);
        for(int i = 0; i < ListProyectos.getModel().getSize() && proyectosPorValor.size()>0; i++){
            Proyecto proyectoActual = fundacaqueta.obtenerProyectoPorNombre(ListProyectos.getModel().getElementAt(i));
            if(proyectosPorValor.contains(proyectoActual))
                nuevosProyectosEnPantalla.addElement(proyectoActual.obtenerNombre());
        }
        ListProyectos.setModel(nuevosProyectosEnPantalla);
    }
    
    public void filtrarProyectosRangoDeValores(double valorMin, double valorMax){
        DefaultListModel<String> nuevosProyectosEnPantalla = new DefaultListModel<String>();
        ArrayList proyectosEnRango = fundacaqueta.obtenerProyectoPorRangoDeValores(valorMin, valorMax);
        for(int i = 0; i < ListProyectos.getModel().getSize(); i++){
            if(proyectosEnRango.contains(fundacaqueta.obtenerProyectoPorNombre(ListProyectos.getModel().getElementAt(i))))
                nuevosProyectosEnPantalla.addElement(ListProyectos.getModel().getElementAt(i));
        }
        ListProyectos.setModel(nuevosProyectosEnPantalla);
    }
    
    public void agregarProfesional(String nombreUsuario, String contraseña, String nombres, String correo, int documento, LocalDate fechaNacimiento, String perfil, String cargo){
        proyectoSeleccionado.agregarProfesional(new Profesional(nombreUsuario, contraseña, nombres, correo, documento, fechaNacimiento, perfil, cargo));
        showProfessionals();
    }
    
    public void editarProfesional(String nombreUsuario, String contraseña, String nombres, String correo, int documento, LocalDate fechaNacimiento, String perfil, String cargo){
        profesionalSeleccionado.modificarNombreUsuario(nombreUsuario);
        profesionalSeleccionado.modificarContraseña(contraseña);
        profesionalSeleccionado.modificarNombre(nombres);
        profesionalSeleccionado.modificarCorreo(correo);
        profesionalSeleccionado.modificarDocumento(documento);
        profesionalSeleccionado.modificarFechaNacimiento(fechaNacimiento);
        profesionalSeleccionado.modificarPerfil(perfil);
        profesionalSeleccionado.modificarCargo(cargo);
        showProfessionals();
    }
    
    public void eliminarProfesional(int action){
        if(action == ELIMINAR_PROFESIONAL){
            proyectoSeleccionado.eliminarProfesional(ListProfesionales.getSelectedIndex());
            profesionalSeleccionado = null;
            showProfessionals();
            showProfessionalActivities();
            showProjectContracts();
            showProjectActivities();
        }
    }

    public void agregarActividad(String nombre, String descripcion, String area){
        if(profesionalSeleccionado != null){
            profesionalSeleccionado.agregarActividad(new Actividad(nombre, descripcion, area));
            showProfessionalActivities();
            showProjectActivities();
        }
    }
    
    public void editarActividad(String nombre, String descripcion, String area){
        if(profesionalSeleccionado != null){
            Actividad nuevaActividad = new Actividad(nombre, descripcion, area);      
            profesionalSeleccionado.modificarActividad(obtainSelectedProfessionalActivity(), nuevaActividad);
            this.showProfessionalActivities();
            this.showProjectActivities();
        }
    }
    
    public void eliminarActividad(){
        profesionalSeleccionado.removerActividad(obtainSelectedProfessionalActivity());
        showProfessionalActivities();
        showProjectActivities();
    }
    
    public void agregarContratoAProyecto(String objetivo, String tipo, double valor){
        proyectoSeleccionado.agregarContrato(new ContratoColaboracion(objetivo, tipo, valor));
        showProjectContracts();
    }
    
    public void editarContratoProfesional(String objetivo, String tipo, double valor, LocalDate fechaInicio, LocalDate fechaFin){
        profesionalSeleccionado.modificarContrato(new ContratoLaboral(objetivo, tipo, valor));
        profesionalSeleccionado.obtenerContrato().modificarFechaInicio(fechaInicio);
        profesionalSeleccionado.obtenerContrato().modificarFechaFin(fechaFin);
    }
    
    public void editarContratoColaboracion(String objetivo, String tipo, double valor, LocalDate fechaInicio, LocalDate fechaFin){
        ContratoColaboracion nuevoContrato = new ContratoColaboracion(objetivo, tipo, valor);
        nuevoContrato.modificarFechaInicio(fechaInicio);
        nuevoContrato.modificarFechaFin(fechaFin);
        proyectoSeleccionado.modificarContrato(obtainSelectedContrato(), nuevoContrato);
        contratoSeleccionado = nuevoContrato;
        showDetailsContract();
    }
    
    public void eliminarContrato(){
        int indexContrato = ListContratosProy.getSelectedIndex();
        proyectoSeleccionado.eliminarContrato(indexContrato);
        showProjectContracts();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProyectos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SPaneProyectos = new javax.swing.JScrollPane();
        ListProyectos = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        TxtTipo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtLugarEjecucion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtFechaInicio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtFechaFin = new javax.swing.JTextField();
        PanelProfesionales = new javax.swing.JPanel();
        SPaneProfesionales = new javax.swing.JScrollPane();
        ListProfesionales = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtCargo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtPerfil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtEdad = new javax.swing.JTextField();
        PanelActividadesProfesional = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SPaneActividadesProf = new javax.swing.JScrollPane();
        ListActividadesProf = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        TxtDescripcionActividadProf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtAreaActividadProf = new javax.swing.JTextField();
        PanelActividadesProy = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtDescripcionActividadesProy = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TxtAreaActividadesProy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListActividadesProy = new javax.swing.JList<>();
        PanelContratosProy = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TxtDuracion = new javax.swing.JTextField();
        TxtValorContrato = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TxtFechaInicioContrato = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TxtTipoContrato = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListContratosProy = new javax.swing.JList<>();
        BarOptions = new javax.swing.JMenuBar();
        MenuProyectos = new javax.swing.JMenu();
        MenuBttnAgregarProyecto = new javax.swing.JMenuItem();
        MenuBttnEditarProyecto = new javax.swing.JMenuItem();
        MenuBttnEliminarProyecto = new javax.swing.JMenuItem();
        MenuBttnFiltrarProyectos = new javax.swing.JMenuItem();
        MenuProfesionales = new javax.swing.JMenu();
        MenuBttnAgregarProfesional = new javax.swing.JMenuItem();
        MenuBttnEditarProfesional = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        MenuActividades = new javax.swing.JMenu();
        MenuBttnAgregarActividad = new javax.swing.JMenuItem();
        MenuBttnEditarActividad = new javax.swing.JMenuItem();
        MenuBttnEliminarActividad = new javax.swing.JMenuItem();
        MenuContratos = new javax.swing.JMenu();
        menuContratoProfesional = new javax.swing.JMenu();
        MenuBttnVerContrato = new javax.swing.JMenuItem();
        menuEditarContratoProfesional = new javax.swing.JMenuItem();
        menuContratoProyecto = new javax.swing.JMenu();
        MenuBttnAgregarContrato = new javax.swing.JMenuItem();
        menuEditarContratoProyecto = new javax.swing.JMenuItem();
        EliminarContrato = new javax.swing.JMenuItem();
        MenuUsuarios = new javax.swing.JMenu();
        MenuBttnAdminUsuarios = new javax.swing.JMenuItem();
        MenuOpciones = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelProyectos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Proyectos");

        ListProyectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProyectosValueChanged(evt);
            }
        });
        SPaneProyectos.setViewportView(ListProyectos);

        jLabel6.setText("Lugar ejecucion:");

        TxtTipo.setEditable(false);
        TxtTipo.setEnabled(false);

        jLabel7.setText("Tipo");

        TxtLugarEjecucion.setEditable(false);
        TxtLugarEjecucion.setEnabled(false);

        jLabel8.setText("Fecha inicio:");

        TxtFechaInicio.setEditable(false);
        TxtFechaInicio.setEnabled(false);

        jLabel9.setText("Fecha fin:");

        TxtFechaFin.setEditable(false);
        TxtFechaFin.setEnabled(false);

        javax.swing.GroupLayout PanelProyectosLayout = new javax.swing.GroupLayout(PanelProyectos);
        PanelProyectos.setLayout(PanelProyectosLayout);
        PanelProyectosLayout.setHorizontalGroup(
            PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaInicio))
                    .addGroup(PanelProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtLugarEjecucion))
                    .addGroup(PanelProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTipo))
                    .addGroup(PanelProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addComponent(SPaneProyectos))
                .addContainerGap())
        );
        PanelProyectosLayout.setVerticalGroup(
            PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPaneProyectos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtLugarEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        PanelProfesionales.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ListProfesionales.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProfesionalesValueChanged(evt);
            }
        });
        SPaneProfesionales.setViewportView(ListProfesionales);

        jLabel3.setText("Profesionales");

        jLabel10.setText("Cargo: ");

        TxtCargo.setEditable(false);
        TxtCargo.setEnabled(false);

        jLabel11.setText("Perfil:");

        TxtPerfil.setEditable(false);
        TxtPerfil.setEnabled(false);

        jLabel12.setText("Edad:");

        TxtEdad.setEditable(false);
        TxtEdad.setEnabled(false);

        PanelActividadesProfesional.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Actividades del profesional");

        ListActividadesProf.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListActividadesProfValueChanged(evt);
            }
        });
        SPaneActividadesProf.setViewportView(ListActividadesProf);

        jLabel13.setText("Descripcion:");

        TxtDescripcionActividadProf.setEditable(false);
        TxtDescripcionActividadProf.setEnabled(false);

        jLabel14.setText("Area:");

        TxtAreaActividadProf.setEditable(false);
        TxtAreaActividadProf.setEnabled(false);

        javax.swing.GroupLayout PanelActividadesProfesionalLayout = new javax.swing.GroupLayout(PanelActividadesProfesional);
        PanelActividadesProfesional.setLayout(PanelActividadesProfesionalLayout);
        PanelActividadesProfesionalLayout.setHorizontalGroup(
            PanelActividadesProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActividadesProfesionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActividadesProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActividadesProfesionalLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(SPaneActividadesProf, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(PanelActividadesProfesionalLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDescripcionActividadProf))
                    .addGroup(PanelActividadesProfesionalLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtAreaActividadProf))))
        );
        PanelActividadesProfesionalLayout.setVerticalGroup(
            PanelActividadesProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActividadesProfesionalLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(SPaneActividadesProf, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelActividadesProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TxtDescripcionActividadProf, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelActividadesProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtAreaActividadProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelProfesionalesLayout = new javax.swing.GroupLayout(PanelProfesionales);
        PanelProfesionales.setLayout(PanelProfesionalesLayout);
        PanelProfesionalesLayout.setHorizontalGroup(
            PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfesionalesLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(SPaneProfesionales, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelActividadesProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelProfesionalesLayout.setVerticalGroup(
            PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProfesionalesLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(SPaneProfesionales, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TxtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(PanelProfesionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(TxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelActividadesProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelActividadesProy.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Actividades del proyecto");

        TxtDescripcionActividadesProy.setEditable(false);
        TxtDescripcionActividadesProy.setEnabled(false);

        jLabel16.setText("Area:");

        TxtAreaActividadesProy.setEditable(false);
        TxtAreaActividadesProy.setEnabled(false);

        jLabel15.setText("Descripcion:");

        ListActividadesProy.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListActividadesProyValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListActividadesProy);

        javax.swing.GroupLayout PanelActividadesProyLayout = new javax.swing.GroupLayout(PanelActividadesProy);
        PanelActividadesProy.setLayout(PanelActividadesProyLayout);
        PanelActividadesProyLayout.setHorizontalGroup(
            PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActividadesProyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActividadesProyLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelActividadesProyLayout.createSequentialGroup()
                                .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtAreaActividadesProy, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(TxtDescripcionActividadesProy)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelActividadesProyLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelActividadesProyLayout.setVerticalGroup(
            PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActividadesProyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActividadesProyLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtDescripcionActividadesProy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelActividadesProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtAreaActividadesProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelContratosProy.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Contratos del proyecto");

        jLabel19.setText("Fecha inicio:");

        TxtDuracion.setEditable(false);
        TxtDuracion.setEnabled(false);

        TxtValorContrato.setEditable(false);
        TxtValorContrato.setEnabled(false);

        jLabel17.setText("Tipo");

        TxtFechaInicioContrato.setEditable(false);
        TxtFechaInicioContrato.setEnabled(false);

        jLabel20.setText("Duracion:");

        TxtTipoContrato.setEditable(false);
        TxtTipoContrato.setEnabled(false);

        jLabel18.setText("Valor");

        ListContratosProy.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListContratosProyValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListContratosProy);

        javax.swing.GroupLayout PanelContratosProyLayout = new javax.swing.GroupLayout(PanelContratosProy);
        PanelContratosProy.setLayout(PanelContratosProyLayout);
        PanelContratosProyLayout.setHorizontalGroup(
            PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContratosProyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContratosProyLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTipoContrato))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContratosProyLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtValorContrato))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContratosProyLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechaInicioContrato))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContratosProyLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDuracion)))
                .addContainerGap())
        );
        PanelContratosProyLayout.setVerticalGroup(
            PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContratosProyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtValorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(TxtFechaInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContratosProyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuProyectos.setText("Proyectos");

        MenuBttnAgregarProyecto.setText("Agregar");
        MenuBttnAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnAgregarProyectoActionPerformed(evt);
            }
        });
        MenuProyectos.add(MenuBttnAgregarProyecto);

        MenuBttnEditarProyecto.setText("Modificar");
        MenuBttnEditarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnEditarProyectoActionPerformed(evt);
            }
        });
        MenuProyectos.add(MenuBttnEditarProyecto);

        MenuBttnEliminarProyecto.setText("Eliminar");
        MenuBttnEliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnEliminarProyectoActionPerformed(evt);
            }
        });
        MenuProyectos.add(MenuBttnEliminarProyecto);

        MenuBttnFiltrarProyectos.setText("Filtrar");
        MenuBttnFiltrarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnFiltrarProyectosActionPerformed(evt);
            }
        });
        MenuProyectos.add(MenuBttnFiltrarProyectos);

        BarOptions.add(MenuProyectos);

        MenuProfesionales.setText("Profesionales");

        MenuBttnAgregarProfesional.setText("Agregar");
        MenuBttnAgregarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnAgregarProfesionalActionPerformed(evt);
            }
        });
        MenuProfesionales.add(MenuBttnAgregarProfesional);

        MenuBttnEditarProfesional.setText("Editar");
        MenuBttnEditarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnEditarProfesionalActionPerformed(evt);
            }
        });
        MenuProfesionales.add(MenuBttnEditarProfesional);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        MenuProfesionales.add(Eliminar);

        BarOptions.add(MenuProfesionales);

        MenuActividades.setText("Actividades");

        MenuBttnAgregarActividad.setText("Agregar");
        MenuBttnAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnAgregarActividadActionPerformed(evt);
            }
        });
        MenuActividades.add(MenuBttnAgregarActividad);

        MenuBttnEditarActividad.setText("Editar");
        MenuBttnEditarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnEditarActividadActionPerformed(evt);
            }
        });
        MenuActividades.add(MenuBttnEditarActividad);

        MenuBttnEliminarActividad.setText("Eliminar");
        MenuBttnEliminarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnEliminarActividadActionPerformed(evt);
            }
        });
        MenuActividades.add(MenuBttnEliminarActividad);

        BarOptions.add(MenuActividades);

        MenuContratos.setText("Contratos");

        menuContratoProfesional.setText("Profesional");

        MenuBttnVerContrato.setText("Ver contrato");
        MenuBttnVerContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnVerContratoActionPerformed(evt);
            }
        });
        menuContratoProfesional.add(MenuBttnVerContrato);

        menuEditarContratoProfesional.setText("Editar");
        menuEditarContratoProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarContratoProfesionalActionPerformed(evt);
            }
        });
        menuContratoProfesional.add(menuEditarContratoProfesional);

        MenuContratos.add(menuContratoProfesional);

        menuContratoProyecto.setText("Proyecto");

        MenuBttnAgregarContrato.setText("Agregar");
        MenuBttnAgregarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBttnAgregarContratoActionPerformed(evt);
            }
        });
        menuContratoProyecto.add(MenuBttnAgregarContrato);

        menuEditarContratoProyecto.setText("Editar");
        menuEditarContratoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarContratoProyectoActionPerformed(evt);
            }
        });
        menuContratoProyecto.add(menuEditarContratoProyecto);

        EliminarContrato.setText("Eliminar");
        EliminarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarContratoActionPerformed(evt);
            }
        });
        menuContratoProyecto.add(EliminarContrato);

        MenuContratos.add(menuContratoProyecto);

        BarOptions.add(MenuContratos);

        MenuUsuarios.setText("Usuarios");

        MenuBttnAdminUsuarios.setText("Administrar");
        MenuUsuarios.add(MenuBttnAdminUsuarios);

        BarOptions.add(MenuUsuarios);

        MenuOpciones.setText("Opciones");

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuItemSalir);

        BarOptions.add(MenuOpciones);

        setJMenuBar(BarOptions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelProfesionales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelActividadesProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelContratosProy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelProfesionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelContratosProy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelActividadesProy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListProfesionalesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListProfesionalesValueChanged
        // TODO add your handling code here:
        showDetailsProfessional();
        showProfessionalActivities();
    }//GEN-LAST:event_ListProfesionalesValueChanged

    private void ListActividadesProfValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListActividadesProfValueChanged
        // TODO add your handling code here:
        showDetailsProfessionalActivity();
    }//GEN-LAST:event_ListActividadesProfValueChanged

    private void MenuBttnAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnAgregarProyectoActionPerformed
        // TODO add your handling code here:
        AgregarProyecto addProject = new AgregarProyecto(fundacaqueta, this);
        addProject.setVisible(true);
        
    }//GEN-LAST:event_MenuBttnAgregarProyectoActionPerformed

    private void ListActividadesProyValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListActividadesProyValueChanged
        // TODO add your handling code here:
        showDetailsProjectActivity();
    }//GEN-LAST:event_ListActividadesProyValueChanged

    private void ListContratosProyValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListContratosProyValueChanged
        // TODO add your handling code here:
        showDetailsContract();
    }//GEN-LAST:event_ListContratosProyValueChanged

    private void MenuBttnEditarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnEditarProyectoActionPerformed
        // TODO add your handling code here:
        EditarProyecto editar = new EditarProyecto(fundacaqueta, this);
        editar.setVisible(true);
    }//GEN-LAST:event_MenuBttnEditarProyectoActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void MenuBttnEliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnEliminarProyectoActionPerformed
        // TODO add your handling code here:
        EliminarProyecto eliminar = new EliminarProyecto(fundacaqueta, this);
        eliminar.setVisible(true);
    }//GEN-LAST:event_MenuBttnEliminarProyectoActionPerformed

    private void MenuBttnFiltrarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnFiltrarProyectosActionPerformed
        // TODO add your handling code here:
        FiltrarProyecto filtros = new FiltrarProyecto(this);
        filtros.setVisible(true);
    }//GEN-LAST:event_MenuBttnFiltrarProyectosActionPerformed

    private void MenuBttnAgregarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnAgregarProfesionalActionPerformed
        // TODO add your handling code here:
        AgregarProfesional agregar = new AgregarProfesional(this);
        agregar.setVisible(true);
    }//GEN-LAST:event_MenuBttnAgregarProfesionalActionPerformed

    private void MenuBttnEditarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnEditarProfesionalActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado==null)
            JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional del proyecto para poder editar", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            EditarProfesional editar = new EditarProfesional(this);
            editar.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnEditarProfesionalActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado==null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder eliminar", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            EliminarProfesional ep = new EliminarProfesional(this);
            ep.setVisible(true);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void ListProyectosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListProyectosValueChanged
        // TODO add your handling code here:
        showDetailsProject();
        showProfessionals();
        showProjectActivities();
        showProjectContracts();
        if(profesionalSeleccionado != null)
            ListProfesionales.setSelectedValue(profesionalSeleccionado.obtenerNombre(), true);
    }//GEN-LAST:event_ListProyectosValueChanged

    private void MenuBttnAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnAgregarActividadActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder agregar una actividad", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            AgregarActividad aa = new AgregarActividad(this);
            aa.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnAgregarActividadActionPerformed

    private void MenuBttnEditarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnEditarActividadActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder editar una actividad", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        if(obtainSelectedProfessionalActivity()== null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar una actividad de un profesional para poder editarla", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            EditarActividad ea = new EditarActividad(this);
            ea.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnEditarActividadActionPerformed

    private void MenuBttnEliminarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnEliminarActividadActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder eliminar una actividad", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        if(obtainSelectedProfessionalActivity()== null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar una actividad de un profesional para poder eliminarla", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            EliminarActividad ea = new EliminarActividad(this);
            ea.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnEliminarActividadActionPerformed

    private void MenuBttnAgregarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnAgregarContratoActionPerformed
        // TODO add your handling code here:
        if(proyectoSeleccionado == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un proyecto para poder agregar un contrato", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            AgregarContrato ac = new AgregarContrato(this);
            ac.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnAgregarContratoActionPerformed

    private void menuEditarContratoProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarContratoProfesionalActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado == null){
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder editar su contrato", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            EditarContratoLaboral ecl = new EditarContratoLaboral(this);
            ecl.setVisible(true);
        }
    }//GEN-LAST:event_menuEditarContratoProfesionalActionPerformed

    private void MenuBttnVerContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBttnVerContratoActionPerformed
        // TODO add your handling code here:
        if(profesionalSeleccionado == null){
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un profesional del proyecto para poder visualizar su contrato", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            VerContratoLaboral vcl = new VerContratoLaboral(this);
            vcl.setVisible(true);
        }
    }//GEN-LAST:event_MenuBttnVerContratoActionPerformed

    private void menuEditarContratoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarContratoProyectoActionPerformed
        // TODO add your handling code here:
        if(proyectoSeleccionado == null){
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un proyecto para poder modificar uno de sus contratos", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        if(obtainSelectedContrato() == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un contrato del proyecto para poder modificarlo", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            EditarContratoColaboracion ecc = new EditarContratoColaboracion(this);
            ecc.setVisible(true);
        }
    }//GEN-LAST:event_menuEditarContratoProyectoActionPerformed

    private void EliminarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarContratoActionPerformed
        // TODO add your handling code here:
        if(proyectoSeleccionado == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un proyecto para poder eliminar uno de sus contratos", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
    
        if(obtainSelectedContrato() == null)
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un contrato del proyecto para poder eliminarlo", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        else{
            EliminarContrato ec = new EliminarContrato(this);
            ec.setVisible(true);
        }
    }//GEN-LAST:event_EliminarContratoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarOptions;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem EliminarContrato;
    private javax.swing.JList<String> ListActividadesProf;
    private javax.swing.JList<String> ListActividadesProy;
    private javax.swing.JList<String> ListContratosProy;
    private javax.swing.JList<String> ListProfesionales;
    private javax.swing.JList<String> ListProyectos;
    private javax.swing.JMenu MenuActividades;
    private javax.swing.JMenuItem MenuBttnAdminUsuarios;
    private javax.swing.JMenuItem MenuBttnAgregarActividad;
    private javax.swing.JMenuItem MenuBttnAgregarContrato;
    private javax.swing.JMenuItem MenuBttnAgregarProfesional;
    private javax.swing.JMenuItem MenuBttnAgregarProyecto;
    private javax.swing.JMenuItem MenuBttnEditarActividad;
    private javax.swing.JMenuItem MenuBttnEditarProfesional;
    private javax.swing.JMenuItem MenuBttnEditarProyecto;
    private javax.swing.JMenuItem MenuBttnEliminarActividad;
    private javax.swing.JMenuItem MenuBttnEliminarProyecto;
    private javax.swing.JMenuItem MenuBttnFiltrarProyectos;
    private javax.swing.JMenuItem MenuBttnVerContrato;
    private javax.swing.JMenu MenuContratos;
    private javax.swing.JMenu MenuOpciones;
    private javax.swing.JMenu MenuProfesionales;
    private javax.swing.JMenu MenuProyectos;
    private javax.swing.JMenu MenuUsuarios;
    private javax.swing.JPanel PanelActividadesProfesional;
    private javax.swing.JPanel PanelActividadesProy;
    private javax.swing.JPanel PanelContratosProy;
    private javax.swing.JPanel PanelProfesionales;
    private javax.swing.JPanel PanelProyectos;
    private javax.swing.JScrollPane SPaneActividadesProf;
    private javax.swing.JScrollPane SPaneProfesionales;
    private javax.swing.JScrollPane SPaneProyectos;
    private javax.swing.JTextField TxtAreaActividadProf;
    private javax.swing.JTextField TxtAreaActividadesProy;
    private javax.swing.JTextField TxtCargo;
    private javax.swing.JTextField TxtDescripcionActividadProf;
    private javax.swing.JTextField TxtDescripcionActividadesProy;
    private javax.swing.JTextField TxtDuracion;
    private javax.swing.JTextField TxtEdad;
    private javax.swing.JTextField TxtFechaFin;
    private javax.swing.JTextField TxtFechaInicio;
    private javax.swing.JTextField TxtFechaInicioContrato;
    private javax.swing.JTextField TxtLugarEjecucion;
    private javax.swing.JTextField TxtPerfil;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JTextField TxtTipoContrato;
    private javax.swing.JTextField TxtValorContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuContratoProfesional;
    private javax.swing.JMenu menuContratoProyecto;
    private javax.swing.JMenuItem menuEditarContratoProfesional;
    private javax.swing.JMenuItem menuEditarContratoProyecto;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables
}
