/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta.abstractions;
import java.util.Date;

/**
 * Interfaz que provee esquelo para los distintos tipos de usuario que utilizara el sistema
 * @author nebel
 */
public abstract class Usuario {
    
    // ------------------ Variables ------------------
    
    private String nombreUsuario, contraseña, nombre, correo;
    
    private int documento, tipoUsuario;
    
    // ------------------- Constantes ------------------- 
    
    public final static int ADMINISTRADOR = 1;
    public final static int AUXILIAR = 2;
    public final static int PROFESIONAL = 3;
    
    // ------------------ Constructor ------------------
    
    public Usuario(String nombreUsuario, String contraseña, String nombre, String correo, int documento, int tipoUsuario){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
    }
    
    // ------------------- Metodos ---------------------
    
    /**
     * Metodo que provee el tipo de usuario
     * @return tipo - numero con el tipo de usuario
     */
    public int obtenerTipoUsuario(){
        return tipoUsuario;
    }
    
    /**
     * Metodo que provee el nombre y el apellido del usuario
     * @return nombre - cadena con nombre y apellido del usuario
     */
    public String obtenerNombre(){
        return nombre;
    }
    
    /**
     * Metodo que modifica el nombre y el apellido del usuario a uno nuevo
     * @param nuevoNombre - cadena con el nuevo nombre de usuario.
     */
    public void modificarNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    /**
     * Metodo que provee el numero de documento del usuario
     * @return documento - numero de documento del usuario
     */
    public int obtenerDocumento(){
        return this.documento;
    }
    
    /**
     * Metodo que modifica el documento del usuario a uno nuevo
     * @param nuevoDocumento - numero con el nuevo documento del usuario.
     */
    public void modificarDocumento(int nuevoDocumento){
        this.documento = nuevoDocumento;
    }
    
    /**
     * Metodo que provee el correo del usuario
     * @return correo - cadena con correo del usuario
     */
    public String obtenerCorreo(){
        return this.correo;
    }
    
    /**
     * Metodo que modifica el correo del usuario a uno nuevo
     * @param nuevoCorreo - cadena con el nuevo correo de usuario.
     */
    public void modificarCorreo(String nuevoCorreo){
        this.correo = nuevoCorreo;
    }
}
