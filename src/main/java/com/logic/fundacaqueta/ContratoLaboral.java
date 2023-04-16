/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic.fundacaqueta;

import com.logic.fundacaqueta.abstractions.Contrato;

/**
 * Clase que representa un contrato laboral entre un proyecto y un profesional
 * @author nebel
 */
public class ContratoLaboral extends Contrato{
    
    public ContratoLaboral(String objetivo, String tipo, double valor) {
        super(objetivo, tipo, valor);
    }
    
}
