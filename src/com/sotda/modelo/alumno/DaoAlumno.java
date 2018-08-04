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
                beanAlumno.setCarrera(rs.getInt("CARRERA"));
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
                beanAlumno.setCarrera(rs.getInt("CARRERA"));

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
    
    public List<BeanTalleresInscritos> consultarTallerIncrito() {
        List<BeanTalleresInscritos> listaTalleres = new ArrayList<>();
        BeanTalleresInscritos beanTaller = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select NOMBRETALLER,NUM,concat(DOCENTE.NOMBRE,' ',Docente.PRIMER_APELLIDO,' ',DOCENTE.SEGUNDO_APELLIDO) as nombreCompleto,concat(PRIMER_DIA,' ',PRIMER_HORARIO_INICIO,' ',PRIMER_HORARIO_FIN,' ',SEGUNDO_DIA,' ',SEGUNDO_HORARIO_INICIO,' ',SEGUNDO_HORARIO_FIN) as Horario,nombreEstadoGrupo"
                    + " from USUARIO inner join ALUMNO on MATRICULA = USUARIO_ID "
                    + "	inner join ALUMNO_GRUPO on MATRICULA_ALUMNO = MATRICULA "
                    + "		inner join GRUPO on GRUPO_ID = GRUPO_TALLER "
                    + "			inner join ESTADO_GRUPO on GRUPO.ESTADO = idEstado_grupo"
                    + "				inner join TALLER on taller.TALLER_ID = GRUPO.TALLER_ID"
                    + "					inner join DOCENTE on NUM_EMPLEADO = DOCENTE"
                    + "						where MATRICULA = ?;");
            pstm.setString(1, FXMLDocumentController.user.getUsuario_id());
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRETALLER"));
                System.out.println(rs.getString("NUM"));
                System.out.println(rs.getString("nombreCompleto"));
                System.out.println(rs.getString("Horario"));
                System.out.println(rs.getString("nombreEstadoGrupo"));
                beanTaller = new BeanTalleresInscritos();
                beanTaller.setNombreTaller(rs.getString("NOMBRETALLER"));
                beanTaller.setGrupo(rs.getInt("NUM"));
                beanTaller.setDocente(rs.getString("nombreCompleto"));
                beanTaller.setHorario(rs.getString("Horario"));
                beanTaller.setEstado(rs.getString("nombreEstadoGrupo"));
                listaTalleres.add(beanTaller);
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
        return listaTalleres;
    }
}
