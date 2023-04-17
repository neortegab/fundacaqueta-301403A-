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
     * Lista de profesionales de Fundacaqueta
     */
    private ArrayList<Profesional> profesionales;

    /**
     * Lista de proyectos de Fundacaqueta
     */
    private ArrayList<Proyecto> proyectos;

    // ------------ Constructor -------------------
    public Fundacaqueta() {
        this.administradores = new ArrayList<Administrador>();
        this.auxiliares = new ArrayList<Auxiliar>();
        this.profesionales = new ArrayList<Profesional>();
        this.proyectos = new ArrayList<Proyecto>();
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
     *
     * @param admin - nuevo administrador a adicionar
     */
    public void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    /**
     * Elimina un administrador de la lista de administradores
     *
     * @param index - posicion en la lista del administrador a eliminar
     */
    public void eliminarAdministrador(int index) {
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
     *
     * @param aux - nuevo auxiliar a adicionar
     */
    public void agregarAuxiliares(Auxiliar aux) {
        auxiliares.add(aux);
    }

    /**
     * Elimina un auxiliar de la lista de auxiliares
     *
     * @param index - posicion en la lista del auxiliares a eliminar
     */
    public void eliminarAuxiliares(int index) {
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
     * Metodo que provee la lista de todos los profesionales vinculados al proyecto
     * @return profesionales
     */
    public ArrayList<Profesional> obtenerProfesionales(){
        if(!proyectos.isEmpty()){
            for(Proyecto proyecto : proyectos)
                for(Profesional profesional : proyecto.obtenerProfesionales())
                    profesionales.add(profesional);
        }
        return profesionales;
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
     * Agrega un proyecto a la lista de proyectos
     * @param proyecto - nuevo proyecto a agregar
     */
    public void agregarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
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
