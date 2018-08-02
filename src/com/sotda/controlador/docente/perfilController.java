/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.docente;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class perfilController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerifil;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Label lbUser;
    @FXML
    private TextField txtnombreDocente;
    @FXML
    private TextField txtNumeroEmpleado;
    @FXML
    private TextField txtHabilidades;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtContra;
    @FXML
    private TextField txtConfirmarContra;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnRegistrar.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        btnCancelar.setGraphic(new ImageView("/com/sotda/imagenes/cancelar.png"));
    }    

    @FXML
    private void inicio(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/docente/perfil.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);       
                  
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
    }

    @FXML
    private void perfil(ActionEvent event) {
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/FXMLDocument.fxml"));
                    verticalBox.getChildren().remove(0);
                    verticalBox.getChildren().remove(0);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                verticalBox.getChildren().add(0, parent1);
    }

    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}
