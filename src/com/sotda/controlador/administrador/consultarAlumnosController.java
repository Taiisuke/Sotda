/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.control.SOTDAV2;
import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.alumno.BeanAlumno;
import com.sotda.modelo.alumno.DaoAlumno;
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
public class consultarAlumnosController implements Initializable {

    @FXML
    private VBox verticalBox;
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
    private Button btnSesion;
   
    @FXML
     private TableView<BeanAlumno> tablaAlumnos;
    @FXML
    private TableColumn<BeanAlumno, String> colNombreAlumno;
    @FXML
    private TableColumn<BeanAlumno, String> colMatricula;
    @FXML
    private TableColumn<BeanAlumno, String> colCarrera;
    @FXML
    private TableColumn<BeanAlumno, String> colGrupo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnPeriodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          btnEliminar.setGraphic(new ImageView("/com/sotda/imagenes/eliminar.png"));
           
        DaoAlumno dao = new DaoAlumno();
        SOTDAV2 principal = new SOTDAV2();
        principal.listaAlumnos = dao.consultarAlumnos();

        colNombreAlumno.setCellValueFactory(new PropertyValueFactory<>("nombreAlumno"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        
        
        
        tablaAlumnos.getItems().clear();
        tablaAlumnos.getItems().addAll(principal.listaAlumnos);
        
        
        // TODO
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
    private void eliminar(ActionEvent event) {
        BeanAlumno bean = tablaAlumnos.getSelectionModel().getSelectedItem();
        DaoAlumno dao = new DaoAlumno();
        if (dao.eliminarAlumno(bean.getMatricula())) {
            System.out.println("eliminado alv");
             btnEliminar.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        
        SOTDAV2 principal = new SOTDAV2();
        principal.listaAlumnos = dao.consultarAlumnos();

        colNombreAlumno.setCellValueFactory(new PropertyValueFactory<>("nombreAlumno"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        
        
        
        tablaAlumnos.getItems().clear();
        tablaAlumnos.getItems().addAll(principal.listaAlumnos);
        
        }
        
    }

    @FXML
    private void periodos(ActionEvent event) {
    }
    
}
