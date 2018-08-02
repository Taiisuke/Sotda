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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class inicioController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerifil;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private TableView<?> tbGrupos;
    @FXML
    private TableColumn<?, ?> colNombreTaller;
    @FXML
    private TableColumn<?, ?> ColGrupo;
    @FXML
    private TableView<?> tablaGrupo;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colAsistencia;
    @FXML
    private TableColumn<?, ?> colHorario;
    @FXML
    private TableColumn<?, ?> colGrupo;
    @FXML
    private TableColumn<?, ?> colLiberado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void inicio(ActionEvent event) {
    }

    @FXML
    private void perfil(ActionEvent event) {
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
    
}
