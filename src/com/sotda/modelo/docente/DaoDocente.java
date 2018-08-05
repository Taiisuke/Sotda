/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.docente;

import com.sotda.utilerias.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferna
 */
public class DaoDocente {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean guardarDocente(BeanDocente mi) {
        System.out.println(mi.getCorreo());
        CallableStatement cs = null;
        boolean resultado = false;
        try {
            con = ConexionSQL.getConnectionSQL();
            cs = con.prepareCall("{call pa_Registrar_Docente(?,?,?,?,?,?,?)}");
            cs.setInt(1, mi.getNum_empleado());
            cs.setString(2, mi.getNombre());
            cs.setString(3, mi.getPrimer_apellido());
            cs.setString(4, mi.getSegundo_apellido());
            cs.setString(5, mi.getHabilidades_tecnicas());
            cs.setString(6, mi.getCorreo());
            cs.setString(7, mi.getContra());
            resultado = cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                cs.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return resultado;
    }

    public List<BeanConsultarDocentes> consultarDocentes() {
        List<BeanConsultarDocentes> docentes = new ArrayList<>();
        BeanConsultarDocentes docente = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            ps = con.prepareStatement("select NUM_EMPLEADO,NOMBREDOC,PRIMER_APELLIDODOC,SEGUNDO_APELLIDODOC, NOMBRETALLER, NOMBRE_ESPACIO, TALLER.ESTADO as estadoTaller"
                    + "	FROM DOCENTE inner join TALLER on NUM_EMPLEADO = TALLER.DOCENTE"
                    + "		inner join ESPACIO on ESPACIO_ID = TALLER.ESPACIO_ASIGNADO" +
"				inner join USUARIO on USUARIO_ID = NUM_EMPLEADO where USUARIO.ESTADO = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                docente = new BeanConsultarDocentes();
                docente.setIdDocente(rs.getInt("NUM_EMPLEADO"));
                docente.setNombre(rs.getString("NOMBREDOC")+ " " + rs.getString("PRIMER_APELLIDODOC")+" "+rs.getString("SEGUNDO_APELLIDODOC"));
                docente.setTaller(rs.getString("NOMBRETALLER"));
                docente.setEspacio(rs.getString("NOMBRE_ESPACIO"));
                docente.setEstado(rs.getString("estadoTaller"));
                docentes.add(docente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException exe) {
                exe.getMessage();
            }
        }
        return docentes;
    }

    public boolean modificarDocente(BeanDocente beanDocente){
        boolean resultado = false;
        CallableStatement cs = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            cs = con.prepareCall("{call pa_modificar_docente(?,?,?,?,?,?,?)}");
            cs.setString(1, Integer.toString(beanDocente.getNum_empleado()));
            cs.setString(2, beanDocente.getNombre());
            cs.setString(3, beanDocente.getPrimer_apellido());
            cs.setString(4, beanDocente.getSegundo_apellido());
            cs.setString(5, beanDocente.getHabilidades_tecnicas());
            cs.setString(6, beanDocente.getCorreo());
            cs.setString(7, beanDocente.getContra());
            resultado = cs.executeUpdate() > 0;
            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                if (cs != null) {
                   cs.close(); 
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return resultado;
    }
    
    public BeanDocente consultarUnDocente(int numeroEmpleado){
        BeanDocente docente = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            ps = con.prepareStatement("select * from DOCENTE inner join USUARIO on USUARIO_ID = NUM_EMPLEADO where NUM_EMPLEADO = ?");
            ps.setString(1,Integer.toString(numeroEmpleado));
            rs = ps.executeQuery();
            while (rs.next()) {
                docente = new BeanDocente();
                docente.setNum_empleado(rs.getInt("NUM_EMPLEADO"));
                docente.setNombre(rs.getString("NOMBREDOC"));
                docente.setPrimer_apellido(rs.getString("PRIMER_APELLIDODOC"));
                docente.setSegundo_apellido(rs.getString("SEGUNDO_APELLIDODOC"));
                docente.setHabilidades_tecnicas(rs.getString("HABILIDADES_TECNICAS"));
                docente.setCorreo(rs.getString("CORREO"));
                docente.setId(rs.getInt("ID"));
                docente.setUsuario(rs.getString("USUARIO"));
                docente.setContra(rs.getString("CONTRA"));
                docente.setTipo(rs.getInt("TIPO"));
                docente.setUsuario_id("USUARIO_ID");
                docente.setEstado(rs.getInt("ESTADO"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException exe) {
                exe.getMessage();
            }
        }
        return docente;
    }
    
    public boolean eliminarDocente(){
        boolean resultado = false;
        
        return resultado;
    }
}
