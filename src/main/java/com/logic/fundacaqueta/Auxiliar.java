/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

import com.logic.fundacaqueta.abstractions.Usuario;

/**
 * Clase que representa un usuario auxiliar en el sistema
 * @author nebel
 */
public class Auxiliar extends Usuario{
    
    public Auxiliar(String nombreUsuario, String contraseña, String nombre, String correo, int documento) {
        super(nombreUsuario, contraseña, nombre, correo, documento, Usuario.AUXILIAR);
    }
    
}
