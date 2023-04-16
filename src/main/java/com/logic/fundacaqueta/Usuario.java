/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

/**
 *
 * @author nebel
 */
public interface Usuario {
    
    // ------------------- Constantes ------------------- 
    
    public final static int ADMINISTRADOR = 1;
    public final static int AUXILIAR = 2;
    public final static int PROFESIONAL = 3;
    
    // ------------------- Metodos -------------------
    
    /**
     * Metodo que provee el tipo de usuario
     * @return tipo - numero con el tipo de usuario
     */
    public int obtenerTipoUsuario();
    
    /**
     * Metodo que provee el nombre y el apellido del usuario
     * @return nombre - cadena con nombre y apellido del usuario
     */
    public String obtenerNombre();
    
    /**
     * Metodo que modifica el nombre y el apellido del usuario a uno nuevo
     * @param nuevoNombre - cadena con el nuevo nombre de usuario.
     */
    public void modificarNombre(String nuevoNombre);
    
    /**
     * Metodo que provee el numero de documento del usuario
     * @return documento - numero de documento del usuario
     */
    public int obtenerDocumento();
    
    /**
     * Metodo que modifica el documento del usuario a uno nuevo
     * @param nuevoDocumento - numero con el nuevo documento del usuario.
     */
    public void modificarDocumento(int nuevoDocumento);
    
    /**
     * Metodo que provee el correo del usuario
     * @return correo - cadena con correo del usuario
     */
    public String obtenerCorreo();
    
    /**
     * Metodo que modifica el correo del usuario a uno nuevo
     * @param nuevoCorreo - cadena con el nuevo correo de usuario.
     */
    public void modificarCorreo(String nuevoCorreo);
}
