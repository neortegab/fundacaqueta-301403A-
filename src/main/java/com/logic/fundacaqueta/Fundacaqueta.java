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
     * Obtiene un usuario administrador segun un nombre de usuario buscado
     * @param nombreUsuario - nombre de usuario del usuario que desea buscarse
     * @return administrador con el nombre de usuario indicado.
     */
    public Administrador obtenerAdministrador(String nombreUsuario){
        Administrador adminBuscado = null;
        
        for(int i = 0; i < administradores.size(); i++){
            if(administradores.get(i).obtenerNombreUsuario().equals(nombreUsuario)){
                adminBuscado = administradores.get(i);
                break;
            }
        }
        
        return adminBuscado;
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
     * Metodo que modifica un administrador de la lista de administradores
     * @param adminAntiguo - administrador con la informacion antigua
     * @param nuevoAdmin  - administrador con la nueva informacion
     */
    public void modificarAdministrador(Administrador adminAntiguo, Administrador nuevoAdmin){
        if(!administradores.isEmpty()){
            for(int i = 0; i < administradores.size(); i++){
                if(administradores.get(i).equals(adminAntiguo)){
                    administradores.set(i, nuevoAdmin);
                    break;
                }
            }
        }
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
     * Obtiene un usuario auxiliar segun un nombre de usuario buscado
     * @param nombreUsuario - nombre de usuario del usuario que desea buscarse
     * @return auxiliar con el nombre de usuario indicado.
     */
    public Auxiliar obtenerAuxiliar(String nombreUsuario){
        Auxiliar auxBuscado = null;
        
        for(int i = 0; i < auxiliares.size(); i++){
            if(auxiliares.get(i).obtenerNombreUsuario().equals(nombreUsuario)){
                auxBuscado = auxiliares.get(i);
                break;
            }
        }
        
        return auxBuscado;
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
     * Metodo que modifica un auxiliar de la lista de auxiliares
     * @param auxAntiguo - auxiliar con la informacion antigua
     * @param nuevoAux  - auxiliar con la nueva informacion
     */
    public void modificarAuxiliar(Auxiliar auxAntiguo, Auxiliar nuevoAux){
        if(!auxiliares.isEmpty()){
            for(int i = 0; i < auxiliares.size(); i++){
                if(auxiliares.get(i).equals(auxAntiguo)){
                    auxiliares.set(i, nuevoAux);
                    break;
                }
            }
        }
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
    
    public Proyecto obtenerProyectoPorNombre(String nombre){
        Proyecto proyectoBuscado = null;
        if(!proyectos.isEmpty()){
            for(Proyecto proyecto : proyectos){
                if(proyecto.obtenerNombre().equals(nombre))
                    proyectoBuscado = proyecto;
            }
            
        }
        return proyectoBuscado;
    }
    /**
     * Metodo que filtra los proyectos existentes segun un valor y una condicion
     * @param valor - valor que filtrara los proyectos
     * @param condicion - "menor que" "mayor que" o "igual" es la condicion con la que se compara el valor del proyecto con el valor por parametro
     * @return lista de proyectos filtradas o una lista vacia si no hay ninguno
     */
    public ArrayList<Proyecto> obtenerProyectoPorValor(double valor, String condicion){
        ArrayList<Proyecto> proyectosFiltrados = new ArrayList<Proyecto>();
        if(condicion.equals("menor que")){
            for(Proyecto proyecto : proyectos)
                if(proyecto.obtenerValor() < valor)
                    proyectosFiltrados.add(proyecto);
        }
        else if(condicion.equals("mayor que")){
            for(Proyecto proyecto : proyectos)
                if(proyecto.obtenerValor() > valor)
                    proyectosFiltrados.add(proyecto);
        }
        else{
            for(Proyecto proyecto : proyectos)
                if(proyecto.obtenerValor() == valor)
                    proyectosFiltrados.add(proyecto);
        }
        return proyectosFiltrados;
    }
    
    /**
     * Metodo que filtra los proyectos cuyo valor este dentro de un rango de valores
     * @param valorMin - valor minimo segun el rango buscado
     * @param valorMax - valor maximo segun el rango buscado
     * @return una lista de proyectos en la cual el valor de cada proyecto esta dentro del valor especificado.
     */
    public ArrayList<Proyecto> obtenerProyectoPorRangoDeValores(double valorMin, double valorMax){
        ArrayList<Proyecto> proyectosFiltrados = new ArrayList<Proyecto>();
        for(Proyecto proyecto : proyectos){
            if(proyecto.obtenerValor() >= valorMin && proyecto.obtenerValor() <= valorMax)
                proyectosFiltrados.add(proyecto);
        }
        return proyectosFiltrados;
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
