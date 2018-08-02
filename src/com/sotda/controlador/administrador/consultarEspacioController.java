/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.espacio.BeanEspacio;
import com.sotda.modelo.espacio.DaoEspacio;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class consultarEspacioController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPeriodos;
    @FXML
    private Button btnTalleres;
    @FXML
    private Button btnDocente;
    @FXML
    private Button btnEspacio;
    @FXML
    private Button btnAlumno;
    @FXML
    private Button btnsSesion;
    @FXML
    private TextField txtEspacio;
    @FXML
    private TableView<BeanEspacio> tablaEspacio;
    @FXML
    private TableColumn<BeanEspacio, String> colNombreEspacio;
    @FXML
    private TableColumn<BeanEspacio, Integer> colEstado;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        btnRegistrar.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        btnEliminar.setGraphic(new ImageView("/com/sotda/imagenes/eliminar.png"));
        btnCancelar.setGraphic(new ImageView("/com/sotda/imagenes/cancelar.png"));
        btnModificar.setGraphic(new ImageView("/com/sotda/imagenes/modificar.png"));
        consultar();
         colNombreEspacio.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

    }


    private void consultarEspacio(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/consultarEspacios.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, pare);

    }

    @FXML
    private void inicio(ActionEvent event) {
         Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/inicio.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);       
                  
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
    }

    @FXML
    private void talleres(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/inicio.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);       
                  
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
    }

    @FXML
    private void docente(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/docentes.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, pare);
    }

    @FXML
    private void espacio(ActionEvent event) {
    }

    @FXML
    private void alumno(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/alumnos.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, pare);
    }

    @FXML
    private void sesion(ActionEvent event) {
        
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
        try {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Éxito");
            alerta.setHeaderText("Registar");
            alerta.setContentText("Espacio registrado correctamente");
            alerta.show();

        } catch (Exception e) {
            Logger.getLogger(altaDocenteController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @FXML
    private void periodos(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }
 public List<BeanEspacio> consultar(){
        DaoEspacio dao=new DaoEspacio();
        tablaEspacio.getItems().clear();
        tablaEspacio.getItems().addAll(dao.consultarEspacios());
        return null;
 
    }
}
