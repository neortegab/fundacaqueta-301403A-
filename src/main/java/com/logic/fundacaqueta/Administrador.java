/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;
import com.logic.fundacaqueta.abstractions.Usuario;

/**
 * Clase que representa a un usuario administrador
 * @author nebel
 */
public class Administrador extends Usuario {
    public Administrador(String nombreUsuario, String contraseña, String nombre, String correo, int documento){
        super(nombreUsuario, contraseña, nombre, correo, documento, Usuario.ADMINISTRADOR);
    }
}
