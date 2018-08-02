/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.talleres;

/**
 *
 * @author tadeo
 */
public class BeanConsultaTalleres {
    
    private String nombreTaller,nombreDocente,espacioAsignado;
    private int cupoMaximo;
    private String tallerEstado;

    public BeanConsultaTalleres(String nombreTaller, String nombreDocente, String espacioAsignado, int cupoMaximo, String tallerEstado) {
        this.nombreTaller = nombreTaller;
        this.nombreDocente = nombreDocente;
        this.espacioAsignado = espacioAsignado;
        this.cupoMaximo = cupoMaximo;
        this.tallerEstado = tallerEstado;
    }

    public String getTallerEstado() {
        return tallerEstado;
    }

    public void setTallerEstado(String tallerEstado) {
        this.tallerEstado = tallerEstado;
    }

  

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getEspacioAsignado() {
        return espacioAsignado;
    }

    public void setEspacioAsignado(String espacioAsignado) {
        this.espacioAsignado = espacioAsignado;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
    
    
    
}
