/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

import java.util.Date;

/**
 * Interfaz que provee esqueleto para los distintos tipos de contrato que puede
 * administrar un proyecto.
 *
 * @author nebel
 */
public interface Contrato {

    /**
     * Metodo que proveera el objetivo del contrato.
     *
     * @return objetivo - String con el objetivo del contrato.
     */
    public String obtenerObjetivo();

    /**
     * Modifica el objetivo del contrato pre - solo el administrador puede
     * modificar el objetivo
     *
     * @param nuevoObjetivo - nuevo objetivo del contrato
     */
    public void modificarObjetivo(String nuevoObjetivo);

    /**
     * Metodo que proveera el tipo del contrato.
     *
     * @return objetivo - String con el tipo del contrato.
     */
    public String obtenerTipo();

    /**
     * Modifica el tipo del contrato pre - solo el administrador puede modificar
     * el tipo
     *
     * @param nuevoTipo - nuevo tipo del contrato
     */
    public void modificarTipo(String nuevoTipo);

    /**
     * Metodo que proveera el valor del contrato.
     *
     * @return valor - int con el valor del contrato.
     */
    public int obtenerValor();

    /**
     * Modifica el valor del contrato pre - solo el administrador puede
     * modificar el valor
     *
     * @param nuevoValor - nuevo valor del contrato
     */
    public void modificarValor(int nuevoValor);

    /**
     * Metodo que proveera la fecha de inicio del contrato.
     *
     * @return fechaInicio - Date con la fecha de inicio del contrato.
     */
    public Date obtenerFechaInicio();

    /**
     * Modifica la fecha de inicio del contrato pre - solo el administrador
     * puede modificar la fecha de inicio
     *
     * @param nuevaFecha - nueva fecha de inicio del contrato
     */
    public void modificarFechaInicio(Date nuevaFecha);

    /**
     * Metodo que proveera la fecha de finalizacion del contrato.
     *
     * @return fechaFin - Date con la fecha de finalizacion del contrato.
     */
    public Date obtenerFechaFin();

    /**
     * Modifica la fecha de finalizacion del contrato pre - solo el
     * administrador y auxiliar puede modificar la fecha de finalizacion
     *
     * @param nuevaFecha - nueva fecha de finalizacion del contrato
     */
    public void modificarFechaFin(Date nuevaFecha);

    /**
     * Metodo que proveera la duracion del contrato. pre - debe haber una fecha
     * de finalizacion para poder obtener la duracion pre - se debe calcular
     * primero la fecha de duracion
     *
     * @return duracion - String con la duracion del contrato con el formato:
     * "El contrato tuvo una duracion de X años Y meses Z dias".
     */
    public String obtenerDuracion();

    /**
     * Calcula la duracion de un contrato a partir de la diferencia de la fecha
     * de inicio y la fecha de finalizacion. post - Modifica el valor duracion
     * del contrato.
     */
    public void calcularDuracion();
}
