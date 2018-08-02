/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.alumno;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.utilerias.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esmeralda
 */
public class DaoAlumno {

    static Connection con;
    static PreparedStatement pstm;
    static ResultSet rs;
    boolean resultado = false;

     public static BeanAlumno consultarAlumno() {
        BeanAlumno beanAlumno = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select * from ALUMNO where MATRICULA = ?");
            pstm.setString(1, FXMLDocumentController.user.getUsuario_id());
            rs = pstm.executeQuery();
            while (rs.next()) {
                beanAlumno = new BeanAlumno();
                beanAlumno.setMatricula(rs.getString("MATRICULA"));
                beanAlumno.setNombreAlumno(rs.getString("NOMBRE"));
                beanAlumno.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                beanAlumno.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
                beanAlumno.setCuatrimestre(rs.getInt("CUATRIMESTRE"));
                beanAlumno.setGrupo(rs.getString("GRUPO"));
//                beanAlumno.setCarrera1(rs.getInt("CARRERA"));
            }
        } catch (Exception e) {
            System.out.println("Error consultarAlumno() - Ingreso " + e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoUsuario- validarUsuario() - cerrar" + ex);
            }
        }
        return beanAlumno;
    }
       public List<BeanAlumno> consultarAlumnos() {
        BeanAlumno beanAlumno = null;
        List<BeanAlumno> lista = new ArrayList<>();
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select * from ALUMNO inner join USUARIO on MATRICULA = USUARIO_ID where ESTADO = 1");

            rs = pstm.executeQuery();

            while (rs.next()) {
                beanAlumno = new BeanAlumno();
                beanAlumno.setMatricula(rs.getString("MATRICULA"));
                beanAlumno.setNombreAlumno(rs.getString("NOMBRE"));
                beanAlumno.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                beanAlumno.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
                beanAlumno.setCuatrimestre(rs.getInt("CUATRIMESTRE"));
                beanAlumno.setGrupo(rs.getString("GRUPO"));
                beanAlumno.setCarrera(rs.getString("CARRERA"));

                lista.add(beanAlumno);
            }
        } catch (Exception e) {
            System.out.println("Error ConsultarAlumnos() - Ingreso: " + e);
        } finally {

        }
        return lista;
    }
    public boolean eliminarAlumno(String matricula) {

        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("update usuario set estado = 0 where usuario_id = ?");
            pstm.setString(1, matricula);
            rs = pstm.executeQuery();

        } catch (Exception e) {
            System.out.println("Error consultarAlumno() - Ingreso " + e);
        } finally {

        }

        return true;
    }
}
