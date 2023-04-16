/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta.abstractions;

import java.time.LocalDate;
import java.time.Period;

/**
 * Interfaz que provee esqueleto para los distintos tipos de contrato que puede
 * administrar un proyecto.
 *
 * @author nebel
 */
public abstract class Contrato implements Comparable<Contrato>{

    // ------------------ Variables ------------------
    private String objetivo, tipo, duracion;

    private double valor;

    private LocalDate fechaInicio, fechaFin;

    // ------------------ Constructor ------------------
    public Contrato(String objetivo, String tipo, double valor) {
        this.objetivo = objetivo;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaInicio = LocalDate.now();
    }

    // ------------------- Metodos ---------------------
    /**
     * Metodo que proveera el objetivo del contrato.
     *
     * @return objetivo - String con el objetivo del contrato.
     */
    public String obtenerObjetivo() {
        return objetivo;
    }

    /**
     * Modifica el objetivo del contrato pre - solo el administrador puede
     * modificar el objetivo
     *
     * @param nuevoObjetivo - nuevo objetivo del contrato
     */
    public void modificarObjetivo(String nuevoObjetivo) {
        objetivo = nuevoObjetivo;
    }

    /**
     * Metodo que proveera el tipo del contrato.
     *
     * @return objetivo - String con el tipo del contrato.
     */
    public String obtenerTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo del contrato pre - solo el administrador puede modificar
     * el tipo
     *
     * @param nuevoTipo - nuevo tipo del contrato
     */
    public void modificarTipo(String nuevoTipo) {
        tipo = nuevoTipo;
    }

    /**
     * Metodo que proveera el valor del contrato.
     *
     * @return valor - double con el valor del contrato.
     */
    public double obtenerValor() {
        return valor;
    }

    /**
     * Modifica el valor del contrato pre - solo el administrador puede
     * modificar el valor
     *
     * @param nuevoValor - nuevo valor del contrato
     */
    public void modificarValor(double nuevoValor) {
        valor = nuevoValor;
    }

    /**
     * Metodo que proveera la fecha de inicio del contrato.
     *
     * @return fechaInicio - Date con la fecha de inicio del contrato.
     */
    public LocalDate obtenerFechaInicio() {
        return fechaInicio;
    }

    /**
     * Modifica la fecha de inicio del contrato pre - solo el administrador
     * puede modificar la fecha de inicio
     *
     * @param nuevaFecha - nueva fecha de inicio del contrato
     */
    public void modificarFechaInicio(LocalDate nuevaFecha) {
        fechaInicio = nuevaFecha;
    }

    /**
     * Metodo que proveera la fecha de finalizacion del contrato.
     *
     * @return fechaFin - Date con la fecha de finalizacion del contrato.
     */
    public LocalDate obtenerFechaFin() {
        return fechaFin;
    }

    /**
     * Modifica la fecha de finalizacion del contrato pre - solo el
     * administrador y auxiliar puede modificar la fecha de finalizacion
     *
     * @param nuevaFecha - nueva fecha de finalizacion del contrato
     */
    public void modificarFechaFin(LocalDate nuevaFecha) {
        if (nuevaFecha != null) {
            fechaFin = nuevaFecha;
        }
    }

    /**
     * Metodo que proveera la duracion del contrato. pre - debe haber una fecha
     * de finalizacion para poder obtener la duracion pre - se debe calcular
     * primero la fecha de duracion
     *
     * @return duracion - String con la duracion del contrato con el formato:
     * "El contrato tuvo una duracion de X años Y meses Z dias".
     */
    public String obtenerDuracion() {
        return duracion;
    }

    /**
     * Calcula la duracion de un contrato a partir de la diferencia de la fecha
     * de inicio y la fecha de finalizacion. post - Modifica el valor duracion
     * del contrato.
     */
    public void calcularDuracion() {
        if (fechaFin == null) {
            duracion = "El contrato no ha finalizado";
        } else {
            String duracionCalculada = "";

            Period diferenciaEntreFechas = Period.between(fechaInicio, fechaFin);

            duracionCalculada += "El contrato tuvo una duración de ";

            if (diferenciaEntreFechas.getYears() >= 0) {
                duracionCalculada += diferenciaEntreFechas.getYears() + " años ";
            }
            if (diferenciaEntreFechas.getMonths() >= 0) {
                duracionCalculada += diferenciaEntreFechas.getMonths() + " meses ";
            }
            if (diferenciaEntreFechas.getDays() >= 0) {
                duracionCalculada += diferenciaEntreFechas.getDays() + " días";
            }

            duracion = duracionCalculada;
        }
    }
    
    
    public int compareTo(Contrato contrato){
        if(this.fechaInicio.isBefore(contrato.obtenerFechaInicio()))
            return 1;
        else if(this.fechaInicio.isEqual(contrato.obtenerFechaInicio()))
            return 0;
        else
            return -1;
    }
}
