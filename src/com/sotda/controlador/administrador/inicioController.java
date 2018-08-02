/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.talleres.BeanConsultaTalleres;
import com.sotda.modelo.talleres.DaoTalleres;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class inicioController implements Initializable {

    @FXML
    private Button btnAltaTaller;
    @FXML
    private Button btnConsultarGrupo;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnTalleres;
    @FXML
    private Button btnDocente;
    @FXML
    private Button btnEspacio;
    @FXML
    private Button btnAlumno;
    @FXML
    private Button btnModificar;
    @FXML
    private TableView<BeanConsultaTalleres> tablaTaller;
    @FXML
    private TableColumn<BeanConsultaTalleres, String> colNombreTaller;
    @FXML
    private TableColumn<BeanConsultaTalleres, String> ColCupoMax;
    @FXML
    private TableColumn<BeanConsultaTalleres, String> colNombreDocente;
    @FXML
    private TableColumn<BeanConsultaTalleres, String> colEspacio;
  
    @FXML
    private TableView<?> tablaGrupo;
    @FXML
    private TableColumn<?, ?> colNumGrupo;
    @FXML
    private TableColumn<?, ?> colHorario;
    @FXML
    private TableColumn<?, ?> colNumero;
    @FXML
    private Button btnEliminar;
    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnPeriodos;
    @FXML
    private Button btnSesion;
    @FXML
    private TableColumn<BeanConsultaTalleres, Integer> colEstadoTaller;
    @FXML
    private TableColumn<?, ?> colEstadoGrupo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnModificar.setGraphic(new ImageView("/com/sotda/imagenes/modificar.png"));
        btnEliminar.setGraphic(new ImageView("/com/sotda/imagenes/eliminar.png"));
        btnConsultarGrupo.setGraphic(new ImageView("/com/sotda/imagenes/consultar.png"));
        btnAltaTaller.setGraphic(new ImageView("/com/sotda/imagenes/crear.png"));   
        colNombreTaller.setCellValueFactory(new PropertyValueFactory <>("nombreTaller"));
        ColCupoMax.setCellValueFactory(new PropertyValueFactory <>("cupoMaximo"));
        colNombreDocente.setCellValueFactory(new PropertyValueFactory <>("nombreDocente"));
        colEspacio.setCellValueFactory(new PropertyValueFactory <>("espacioAsignado"));
        colEstadoTaller.setCellValueFactory(new PropertyValueFactory <>("tallerEstado"));
        consultaDatos();
        
// TODO
    }

 public void consultaDatos(){
     DaoTalleres dao=new DaoTalleres();
     tablaTaller.getItems().clear();
     tablaTaller.getItems().addAll(dao.consultaTalleres());

 }

    @FXML
    private void altaTaller(ActionEvent event) { 
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/altaTaller.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);          
           
          
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
        
        
       
    }     

    @FXML
    private void consultarGrupo(ActionEvent event) {
        
         
    }

    @FXML
    private void inicio(ActionEvent event) {
    }

    @FXML
    private void talleres(ActionEvent event) {
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
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
        
    }

    @FXML
    private void espacio(ActionEvent event) {
         Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/consultarEspacios.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);          
           
          
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
        
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
        }catch (IndexOutOfBoundsException e){
            
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
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void periodos(ActionEvent event) {
         Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/periodos.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);          
           
          
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException e){
            
        }
        verticalBox.getChildren().add(0, pare);
    }

}
