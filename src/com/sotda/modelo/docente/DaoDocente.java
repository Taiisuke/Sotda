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
 * @author Esmeralda
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
            }
        }
        return resultado;
    }

    public List<BeanConsultarDocentes> consultarDocentes() {
        List<BeanConsultarDocentes> docentes = new ArrayList<>();
        BeanConsultarDocentes docente = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            ps = con.prepareStatement("select NOMBREDOC,PRIMER_APELLIDODOC,SEGUNDO_APELLIDODOC, NOMBRETALLER, NOMBRE_ESPACIO, TALLER.ESTADO as estadoTaller"
                    + "	FROM DOCENTE inner join TALLER on NUM_EMPLEADO = TALLER.DOCENTE"
                    + "		inner join ESPACIO on ESPACIO_ID = TALLER.ESPACIO_ASIGNADO");
            rs = ps.executeQuery();
            while (rs.next()) {
                docente = new BeanConsultarDocentes();
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

            }
        }
        return docentes;
    }

}
