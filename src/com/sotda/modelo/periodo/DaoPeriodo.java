/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.periodo;

import com.sotda.modelo.usuario.BeanUsuario;
import com.sotda.utilerias.ConexionSQL;
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
public class DaoPeriodo {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    public boolean registrarPeriodo(BeanPeriodo beanPeriodo) {
        boolean resultado = false;
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("insert into PERIODO(FechaInicio,FechaFinal, TIPOP)values(?,?,?)");
            pstm.setString(1, beanPeriodo.getFechaInicio());
            pstm.setString(2, beanPeriodo.getFechaFinal());
            pstm.setInt(3, Integer.parseInt(beanPeriodo.getTipoPeriodo()));
            resultado = pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error registrarPeriodo() - Ingreso " + e);
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoUsuario- registrarPeriodo() - cerrar" + ex);
            }
        }
        return resultado;
    }

    public List<BeanPeriodo> consultarPeriodos() {
        List<BeanPeriodo> listaPeriodos = new ArrayList<>();
        BeanPeriodo beanPeriodo = null;
        String tipo = " ";
        try {
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select * from periodo");
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getInt("TIPOP") == 1) {
                    tipo = "Inscripción";
                } else {
                    tipo = "Liberación";
                }
                beanPeriodo = new BeanPeriodo(rs.getString("FechaInicio"), rs.getString("FechaFinal"),tipo);
                listaPeriodos.add(beanPeriodo);
            }
        } catch (Exception e) {
            System.out.println("Error consultarPeriodos() - Ingreso " + e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoUsuario- consultarPeriodos() - cerrar" + ex);
            }
        }
        return listaPeriodos;
    }
}
