/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control.alumno;

import com.sotda.controlador.principal.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TalleresDispController implements Initializable {

    @FXML
    private VBox vbContenedor;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnTallersIns;
    @FXML
    private Button btnInscribir;
    @FXML
    private Button btnSesion;
    @FXML
    private Button btnInscribirse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
   
    @FXML
    private void inicio(ActionEvent event) {
        Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/inicio.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, parent1);
               
    }

    @FXML
    private void perfil(ActionEvent event) {
    Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/Perfil.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, parent1);
    }

    @FXML
    private void talleresins(ActionEvent event) {
        Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/TaleresInscritos.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, parent1);
    }

    @FXML
    private void inscribir(ActionEvent event) {
        Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/talleres.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, parent1);
    }

    @FXML
    private void sesion(ActionEvent event) {
        Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/FXMLDocument.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, parent1);
    }

    
    @FXML
    private void Inscribirse(ActionEvent event) {
    }

     
}
