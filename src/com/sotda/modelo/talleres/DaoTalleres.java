/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.modelo.talleres;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.docente.BeanConsultarDocentes;
import com.sotda.utilerias.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tadeo
 */
public class DaoTalleres {

    BeanConsultaTalleres bean = null;

    static Connection con;
    static PreparedStatement pstm;
    static ResultSet rs;
    boolean resultado = false;

    public List<BeanConsultaTalleres> consultaTalleres() {
        BeanConsultaTalleres bean = null;

        List<BeanConsultaTalleres> talleres = new ArrayList<>();
        try {
            String estado="";
            con = ConexionSQL.getConnectionSQL();
            pstm = con.prepareStatement("select taller.NOMBRE,CUPO_MAXIMO,DOCENTE.NOMBRE as nombreProf,espacio.nombre_espacio,taller.estado as tallerEstado from TALLER inner join ESPACIO on ESPACIO_ASIGNADO=ESPACIO_ID inner join DOCENTE on DOCENTE =NUM_EMPLEADO");
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                if(rs.getInt("tallerEstado")==1){
                    estado="Activo";
                }else{
                    estado="inactivo";
                }
                bean = new BeanConsultaTalleres(rs.getString("nombre"), rs.getString("nombreProf"), rs.getString("nombre_Espacio"), rs.getInt("cupo_Maximo"),estado);
                talleres.add(bean);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (Exception ex) {

            }
        }
        return talleres;
    }
}
