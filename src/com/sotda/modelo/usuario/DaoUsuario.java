/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.usuario;

import com.sotda.modelo.alumno.BeanAlumno;
import com.sotda.utilerias.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cc7
 */
public class DaoUsuario {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    public boolean resultado = false;

    public boolean registrarUsuario(BeanAlumno bean, String contra) {
        CallableStatement cstm = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            cstm = con.prepareCall("{call pa_Registrar_Usuario(?,?,?,?,?,?,?,?)}");
            cstm.setString(1, bean.getMatricula());
            cstm.setString(2, bean.getNombreAlumno());
            cstm.setString(3, bean.getPrimerApellido());
            cstm.setString(4, bean.getSegundoApellido());
            cstm.setInt(5, bean.getCuatrimestre());
//            cstm.setInt(6, bean.getCarrera());
            cstm.setString(7, bean.getGrupo());
            cstm.setString(8, contra);
            resultado = cstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error registrarUsuario() - Ingreso " + e);
        } finally {
            try {
                con.close();
                cstm.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoUsuario- registrarUsuario() - cerrar" + ex);
            }
        }
        return resultado;
    }

    public BeanUsuario validarUsuario(String usuario, String contra) {
        BeanUsuario user = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select * from USUARIO where USUARIO = ? and CONTRA = ?");
            pstm.setString(1, usuario);
            pstm.setString(2, contra);
            rs = pstm.executeQuery();

            while (rs.next()) {
                user = new BeanUsuario();
                //no hace nada
                resultado = true;
                user.setId(rs.getInt("ID"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setEstado(rs.getInt("ESTADO"));
                user.setUsuario_id(rs.getString("USUARIO_ID"));
                user.setTipo(rs.getInt("TIPO"));
                System.out.println(rs.getString("USUARIO_ID"));
            }
        } catch (Exception e) {
            System.out.println("Error validarUsuario() - Ingreso " + e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoUsuario- validarUsuario() - cerrar" + ex);
            }
        }
        return user;
    }

}
