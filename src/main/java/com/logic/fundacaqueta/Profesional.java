/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;
import java.util.Date;
import java.util.ArrayList;

/**
 * Clase que representara un profesional asociado a un proyecto de fundacaqueta
 * @author nebel
 */
public class Profesional {
    
    // ------------  Variables  -------------------

    /**
     * Nombre y apellido del profesional
     */
    private String nombre;
    
    /**
     * Numero de documento del profesional
     */
    private int documento;
    
    /**
     * Fecha de nacimiento del profesional (se utilizara para calcular edad)
     */
    private Date fechaNacimiento;
    
    /**
     * Perfil del profesional (carrera o profesion).
     */
    private String perfil;
    
    /**
     * Cargo que emplea el profesional en el proyecto.
     */
    private String cargo;
    
    /**
     * Actividades que desempeña el profesional en un proyecto.
     */
    private ArrayList<Actividad> actividades;
    
    // ------------ Constructor -------------------
    
    public Profesional(String nombre, int documento, Date fechaNacimiento, String perfil, String cargo){
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.perfil = perfil;
        this.cargo = cargo;
        this.actividades = new ArrayList<Actividad>();
    }
    
    // ------------   Metodos   -------------------

    /**
     * Provee el nombre y apellido del profesional
     * @return nombre - nombre y apellido del profesional
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre y apellido del profesional
     * @param nombre - nueva cadena con nombre y apellido del profesional.
     */
    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Provee el numero del documento del profesional
     * @return documento - documento del profesional
     */
    public int obtenerDocumento() {
        return documento;
    }

    /**
     * Modifica el documento del profesional
     * @param documento - nuevo numero de documento del profesional.
     */
    public void modificarDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Provee la fecha de nacimiento del profesional
     * @return fechaNacimiento - fecha de nacimiento del profesional
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Modifica la fecha de nacimiento del profesional
     * @param fechaNacimiento - nueva fecha de nacimiento del profesional.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Provee la fecha de nacimiento del profesional
     * @return fechaNacimiento - fecha de nacimiento del profesional
     */
    public String obtenerPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    
}
