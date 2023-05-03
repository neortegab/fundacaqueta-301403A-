/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

import com.logic.fundacaqueta.abstractions.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representara un profesional asociado a un proyecto de fundacaqueta que tambien es un Usuario
 * @author nebel
 */
public class Profesional extends Usuario{

    // ------------  Variables  -------------------

    /**
     * Fecha de nacimiento del profesional (se utilizara para calcular edad)
     */
    private LocalDate fechaNacimiento;

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
    
    /**
     * Contrato que posee el profesional en el proyecto.
     */
    private ContratoLaboral contrato;

    // ------------ Constructor -------------------
    public Profesional(String nombreUsuario, String contraseña, String nombre, String correo, int documento, LocalDate fechaNacimiento, String perfil, String cargo) {
        super(nombreUsuario, contraseña, nombre, correo, documento, Usuario.PROFESIONAL);
        this.fechaNacimiento = fechaNacimiento;
        this.perfil = perfil;
        this.cargo = cargo;
        this.actividades = new ArrayList<Actividad>();
    }

    // ------------   Metodos   -------------------

    /**
     * Provee la fecha de nacimiento del profesional
     *
     * @return fechaNacimiento - fecha de nacimiento del profesional
     */
    public LocalDate obtenerFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Modifica la fecha de nacimiento del profesional
     *
     * @param fechaNacimiento - nueva fecha de nacimiento del profesional.
     */
    public void modificarFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Provee el perfil del profesional
     *
     * @return perfil - perfil del profesional
     */
    public String obtenerPerfil() {
        return perfil;
    }

    /**
     * Modifica el perfil del profesional
     *
     * @param perfil - nuevo perfil del profesional.
     */
    public void modificarPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Provee el cargo del profesional
     *
     * @return cargo - cargo del profesional
     */
    public String obtenerCargo() {
        return cargo;
    }

    /**
     * Modifica el cargo del profesional
     *
     * @param cargo - nuevo cargo del profesional.
     */
    public void modificarCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Provee la lista de actividades del profesional
     *
     * @return actividades - actividades del profesional
     */
    public ArrayList<Actividad> obtenerActividades() {
        return actividades;
    }
    
    /**
     * Metodo que agrega una actividad a la lista de actividades del profesional
     * @param actividad - actividad nueva a agregar
     */
    public void agregarActividad(Actividad actividad){
        actividades.add(actividad);
    }
    
    public void modificarActividad(Actividad viejaActividad, Actividad nuevaActividad){
        boolean encontradaActividad = false;
        for(int i = 0; i < actividades.size() && !encontradaActividad; i++){
            if(actividades.get(i).equals(viejaActividad)){  
                actividades.set(i, nuevaActividad);
                encontradaActividad = true;
            }
        }
    }
    /**
     * Modifica la lista de actividades del profesional con una nueva lista
     *
     * @param actividades - nuevas actividades del profesional
     */
    public void modificarActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    /**
     * Obtiene el contrato laboral del profesional
     * @return contrato
     */
    public ContratoLaboral obtenerContrato() {
        return contrato;
    }

    /**
     * Modifica el contrato laboral del profesional
     * pre - solo un administrador puede modificar los contratos
     * @param contrato - nuevo contrato a reemplazar el anterior
     */
    public void modificarContrato(ContratoLaboral contrato) {
        this.contrato = contrato;
    }
    
    
}
