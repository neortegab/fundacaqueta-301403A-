/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un proyecto realizado por FUNDACAQUETA
 *
 * @author nebel
 */
public class Proyecto {

    // ------------  Variables  -------------------
    /**
     * Nombre del proyecto
     */
    private String nombre;

    /**
     * Fechas de inicio y finalizacion del proyecto 
     * La fecha de finalizacion puede ser nula.
     */
    private LocalDate fechaInicio, fechaFin;

    /**
     * Lugar en el cual está siendo ejecutado el proyecto.
     */
    private String lugarEjecucion;

    /**
     * Tipo de proyecto (Inversion social o salud).
     */
    private String tipo;

    /**
     * Lista de los contratos del proyecto
     */
    private ArrayList<ContratoColaboracion> contratos;

    /**
     * Lista de los profesionales del proyecto.
     */
    private ArrayList<Profesional> profesionales;
    
    /**
     * Lista de todas las actividades realizadas por los profesionales pertenecientes al proyecto;
     */
    private ArrayList<Actividad> actividades;

    // ------------------- Constantes ------------------- 
    /**
     * Constante para definir que un proyecto es de tipo Inversion Social
     */
    public final static String INVERSION_SOCIAL = "Inversion social";

    /**
     * Constante para definir que un proyecto es de tipo Inversion Social
     */
    public final static String SALUD = "Salud";

    // ------------------ Constructor ------------------
    public Proyecto(String nombre, String lugarEjecucion, String tipo) {
        this.nombre = nombre;
        this.lugarEjecucion = lugarEjecucion;
        this.fechaInicio = LocalDate.now();
        this.contratos = new ArrayList<ContratoColaboracion>();
        this.profesionales = new ArrayList<Profesional>();
        this.actividades = new ArrayList<Actividad>();
        establecerTipo(tipo);
    }

    // ------------------- Metodos ---------------------
    /**
     * Metodo para establecer el tipo de proyecto en el metodo constructor segun el que le llegue por parametro
     * @param tipo
     */
    private void establecerTipo(String tipo) {
        if (tipo.equals(INVERSION_SOCIAL)) {
            this.tipo = INVERSION_SOCIAL;
        }
        if (tipo.equals(SALUD)) {
            this.tipo = SALUD;
        }
    }

    /**
     * Metodo que devuelve el nombre del proyecto
     * @return nombre del proyecto
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Metodo que modifica el nombre del proyecto
     * @param nombre - nuevo nombre del proyecto
     */
    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve la fecha de inicio del proyecto
     * @return fechaInicio del proyecto
     */
    public LocalDate obtenerFechaInicio() {
        if(!contratos.isEmpty())
            fechaInicio = contratos.get(0).obtenerFechaInicio();
        
        return fechaInicio;
    }

    /**
     * Metodo que modifica la fecha de inicio del proyecto
     * pre - solo un administrador puede modificar una fecha de inicio de un proyecto despues de haberse creado el proyecto
     * @param fechaInicio - nueva fecha de inicio del proyecto
     */
    public void modificarFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo que devuelve la fecha de finalizacion del proyecto
     * @return fechaFin del proyecto
     */
    public LocalDate obtenerFechaFin() {
        if(!contratos.isEmpty()){
            ContratoColaboracion ultimoContrato = contratos.get(contratos.size()-1);
            if(ultimoContrato.obtenerFechaFin() != null){
                fechaFin = ultimoContrato.obtenerFechaFin();
            }
        } 
        return fechaFin;
    }

    /**
     * Metodo que modifica la fecha de finalizacion del proyecto
     * @param fechaFin - fecha en la cual se finalizo el proyecto
     */
    public void modificarFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Metodo que provee el lugar de ejecucion del proyecto
     * @return lugar de ejecucion
     */
    public String obtenerLugarEjecucion() {
        return lugarEjecucion;
    }

    /**
     * Metodo que modifica el lugar de ejecucion del proyecto
     * @param lugarEjecucion - nuevo lugar de ejecucion del proyecto
     */
    public void modificarLugarEjecucion(String lugarEjecucion) {
        this.lugarEjecucion = lugarEjecucion;
    }

    /**
     * Metodo que devuelve la lista de contratos del proyecto
     * @return contratos
     */
    public ArrayList<ContratoColaboracion> obtenerContratos() {
        return contratos;
    }
    
    /**
     * Metodo que agrega un nuevo contrato a la lista de contratos y ordena la lista segun su fecha de inicio
     * El contrato con la fecha de inicio mas antigua debe siempre permanecer en el tope
     * @param nuevoContrato - nuevo contrato a añadir
     */
    public void agregarContrato(ContratoColaboracion nuevoContrato){
        contratos.add(nuevoContrato);
        contratos.sort(null);
    }

    /**
     * Elimina el contrato en el indice especificado
     * @param index - indice del contrato a remover
     */
    public void eliminarContrato(int index){
        contratos.remove(index);
    }
    /**
     * Metodo que modifica la lista de contratos del proyecto con una nueva lista
     * @param contratos - nueva lista de contratos.
     */
    public void modificarContratos(ArrayList<ContratoColaboracion> contratos) {
        this.contratos = contratos;
    }

    /**
     * Metodo que devuelve la lista de profesionales del proyecto
     * @return profesionales
     */
    public ArrayList<Profesional> obtenerProfesionales() {
        return profesionales;
    }
    
    /**
     * Metodo que agrega un profesional a la lista de profesionales
     * @param profesional - profesional a agregar
     */
    public void agregarProfesional(Profesional profesional){
        profesionales.add(profesional);
    }
    
    /**
     * Elimina el profesional en el indice especificado
     * @param index - indice del profesional a remover
     */
    public void eliminarProfesional(int index){
        profesionales.remove(index);
    }

    /**
     * Metodo que modifica la lista de profesionales del proyecto con una nueva lista.
     * @param profesionales - nueva lista de profesionales
     */
    public void modificarProfesionales(ArrayList<Profesional> profesionales) {
        this.profesionales = profesionales;
    }

    /**
     * Metodo que devuelve la lista de actividades del proyecto
     * @return actividades
     */
    public ArrayList<Actividad> obtenerActividades() {
        if(!profesionales.isEmpty()){
            for(Profesional profesional : profesionales)
                for(Actividad actividad : profesional.obtenerActividades())
                    actividades.add(actividad);
        }
        return actividades;
    }

    /**
     * Metodo que modifica la lista de actividades del proyecto con una nueva lista.
     * @param actividades - nueva lista de actividades
     */
    public void modificarActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    /**
     * Metodo que provee el tipo del proyecto sea INVERSION SOCIAL o SALUD
     * @return tipo
     */
    public String obtenerTipo() {
        return tipo;
    }

}
