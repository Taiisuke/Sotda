/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control;

import com.sotda.modelo.alumno.BeanAlumno;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Esmeralda
 */
public class SOTDAV2 extends Application {
       public static List <BeanAlumno> listaAlumnos = new ArrayList <BeanAlumno> ();
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/com/sotda/vista/FXMLDocument.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/consultarDocentes.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("SOTDA");
        stage.getIcons().add(new Image(getClass().getResource("/com/sotda/imagenes/halcon_png.png").toExternalForm()));
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
