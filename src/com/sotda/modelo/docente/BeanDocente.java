/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.docente;

import com.sotda.modelo.usuario.BeanUsuario;

/**
 *
 * @author Esmeralda
 */
public class BeanDocente extends BeanUsuario{
    private int num_empleado;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String habilidades_tecnicas;
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
     public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BeanDocente(int num_empleado, String nombre, String primer_apellido, String segundo_apellido, String habilidades_tecnicas,String correo,String contra) {
        this.num_empleado = num_empleado;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.habilidades_tecnicas = habilidades_tecnicas;
        this.correo=correo;
        this.contra = contra;
    }
    
    
    @Override
    public String getUsuario_id() {
        return usuario_id;
    }

    

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getHabilidades_tecnicas() {
        return habilidades_tecnicas;
    }

    public void setHabilidades_tecnicas(String habilidades_tecnicas) {
        this.habilidades_tecnicas = habilidades_tecnicas;
    }
    
    
    
}
