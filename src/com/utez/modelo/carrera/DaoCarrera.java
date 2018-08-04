/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.carrera;

import com.sotda.modelo.docente.BeanConsultarDocentes;
import com.sotda.utilerias.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ferna
 */
public class DaoCarrera {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public ObservableList<BeanCarrera> consultarCarreras() {
        ObservableList<BeanCarrera> carreras = FXCollections.observableArrayList();
        BeanCarrera carrera = null;
        try {
            con = ConexionSQL.getConnectionSQL();
            ps = con.prepareStatement("select * from carrera");
            rs = ps.executeQuery();
            while (rs.next()) {
                carrera = new BeanCarrera(rs.getInt("Carrera_ID"),rs.getString("carrera"));
                carreras.add(carrera);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (Exception ex) {

            }
        }
        return carreras;
    }
}
