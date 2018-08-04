/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.periodo;

/**
 *
 * @author Ferna
 */
public class BeanPeriodo {
    private String fechaInicio;
    private String fechaFinal;
    private String tipoPeriodo;

    public BeanPeriodo() {
    }

    public BeanPeriodo(String fechaInicio, String fechaFinal, String tipoPeriodo) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.tipoPeriodo = tipoPeriodo;
    }
    
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }
    
    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }
    
    
}
