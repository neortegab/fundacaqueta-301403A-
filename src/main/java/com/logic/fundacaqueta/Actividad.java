/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

/**
 * Clase que representa una actividad realizada en un proyecto
 * @author nebel
 */
public class Actividad {
    
    // ------------  Variables  -------------------
    
    /**
     * Representa el nombre de la actividad
     */
    private String nombre;
    
    /**
     * Descripción breve de la actividad.
     */
    private String descripcion;
    
    /**
     * Indica a cual area pertenece una actividad (Ingenieria, contabilidad, etc.)
     */
    private String area;
    
    // ------------ Constructor -------------------
    
    public Actividad(String nombre, String descripcion, String area) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.area = area;
    }

    // ------------   Metodos   -------------------
    
    /**
     * Provee el nombre de la actividad.
     * @return String con el nombre de la actividad.
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la actividad.
     * @param nombre - nuevo nombre de la actividad
     */
    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Provee la descripcion de la actividad.
     * @return String con la descripcion de la actividad.
     */
    public String obtenerDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripcion de la actividad.
     * @param descripcion - nueva descripcion de la actividad
     */
    public void modificarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Provee el area de la actividad.
     * @return String con el area de la actividad.
     */
    public String obtenerArea() {
        return area;
    }

    /**
     * Modifica el area de la actividad.
     * @param area - nueva area de la actividad
     */
    public void modificarArea(String area) {
        this.area = area;
    }

}
