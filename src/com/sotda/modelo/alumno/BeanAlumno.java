/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.alumno;

import com.sotda.modelo.usuario.BeanUsuario;

/**
 *
 * @author Esmeralda
 */
public class BeanAlumno extends BeanUsuario {

    private String matricula;
    private String nombreAlumno;
    private String primerApellido;
    private String segundoApellido;
    private int cuatrimestre;
    private String grupo;
    private int carrera;

    public BeanAlumno(String matricula, String nombreAlumno, String primerApellido, String segundoApellido, int cuatrimestre, String grupo, int carrera) {
        this.matricula = matricula;
        this.nombreAlumno = nombreAlumno;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cuatrimestre = cuatrimestre;
        this.grupo = grupo;
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public BeanAlumno() {
    }

}
