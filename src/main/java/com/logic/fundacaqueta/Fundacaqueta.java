/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.logic.fundacaqueta;

import java.util.ArrayList;

/**
 * Clase administradora que permitirá revisar toda la información de
 * FundaCaqueta
 *
 * @author nebel
 */
public class Fundacaqueta {

    // ------------  Variables  -------------------
    /**
     * Lista de administradores de Fundacaqueta
     */
    private ArrayList<Administrador> administradores;

    /**
     * Lista de usuarios auxiliares de Fundacaqueta
     */
    private ArrayList<Auxiliar> auxiliares;

    /**
     * Lista de proyectos de Fundacaqueta
     */
    private ArrayList<Proyecto> proyectos;

    // ------------ Constructor -------------------
    public Fundacaqueta() {
    }

    ;

    // ------------   Metodos   -------------------
    /**
     * Provee la lista de usuarios administradores de Fundacaqueta
     * @return administradores
     */
    public ArrayList<Administrador> obtenerAdministradores() {
        return administradores;
    }
    
    /**
     * Agrega un administrador a la lista de administradores
     * @param admin - nuevo administrador a adicionar
     */
    public void agregarAdministrador(Administrador admin){
        administradores.add(admin);
    }
    
    /**
     * Elimina un administrador de la lista de administradores
     * @param index - posicion en la lista del administrador a eliminar
     */
    public void eliminarAdministrador(int index){
        administradores.remove(index);
    }

    /**
     * Modifica la lista de usuarios administradores de Fundacaqueta
     *
     * @param administradores - nueva lista de administradores de Fundacaqueta
     */
    public void modificarAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    /**
     * Provee la lista de usuarios auxiliares de Fundacaqueta
     *
     * @return
     */
    public ArrayList<Auxiliar> obtenerAuxiliares() {
        return auxiliares;
    }
    
    /**
     * Agrega un auxiliar a la lista de auxiliares
     * @param aux - nuevo auxiliar a adicionar
     */
    public void agregarAuxiliares(Auxiliar aux){
        auxiliares.add(aux);
    }

    /**
     * Elimina un auxiliar de la lista de auxiliares
     * @param index - posicion en la lista del auxiliares a eliminar
     */
    public void eliminarAuxiliares(int index){
        auxiliares.remove(index);
    }
    
    /**
     * Modifica la lista de usuarios auxiliares de Fundacaqueta
     *
     * @param auxiliares - nueva lista de auxiliares de Fundacaqueta
     */
    public void modificarAuxiliares(ArrayList<Auxiliar> auxiliares) {
        this.auxiliares = auxiliares;
    }

    /**
     * Provee la lista de Proyectos actual de Fundacaqueta
     *
     * @return
     */
    public ArrayList<Proyecto> obtenerProyectos() {
        return proyectos;
    }

    /**
     * Modifica la lista de proyectos de Fundacaqueta
     *
     * @param proyectos - nueva lista de proyectos
     */
    public void modificarProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
