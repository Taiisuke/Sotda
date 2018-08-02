/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cc7
 */
public class ConexionSQL {
    private static Connection con = null;
    private static final String USER = "sa";
    private static final String PWD = "root";
    private static final String DBNAME = "SOTDAV2";
    private static final String PUERTO = "1433";
    
    private static StringBuilder connectionSQL = new StringBuilder();
    
    public static Connection getConnectionSQL(){
        
        
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SOTDAV2;user=sa;password=root";
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Conectado.");
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
        return con;
    }
    
     public static void main(String[] args) throws SQLException {
        Connection con = ConexionSQL.getConnectionSQL();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
