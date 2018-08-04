/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.docente;

/**
 *
 * @author Esmeralda
 */
public class BeanConsultarDocentes {

    private String nombre;
    private String taller;
    private String espacio;
    private String estado;

    public BeanConsultarDocentes(String nombre, String taller, String espacio, String estado) {
        this.nombre = nombre;
        this.taller = taller;
        this.espacio = espacio;
        this.estado = estado;
    }

    BeanConsultarDocentes() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
