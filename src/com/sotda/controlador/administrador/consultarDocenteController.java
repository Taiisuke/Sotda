/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.docente.BeanConsultarDocentes;
import com.sotda.modelo.docente.DaoDocente;
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
public class consultarDocenteController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnAltaDocente;
    @FXML
    private Button btnConsultarDocente;
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
    private TableColumn<BeanConsultarDocentes, String> colEstado;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn<BeanConsultarDocentes, String> colNombreDocente;
    @FXML
    private TableColumn<BeanConsultarDocentes, String> ColTaller;
    @FXML
    private TableColumn<BeanConsultarDocentes, String> colEspacio;
    @FXML
    private TableView<BeanConsultarDocentes> tablaDocente;
    @FXML
    private Button btnPeriodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEliminar.setGraphic(new ImageView("/com/sotda/imagenes/eliminar.png"));
        btnAltaDocente.setGraphic(new ImageView("/com/sotda/imagenes/crear.png"));
        btnConsultarDocente.setGraphic(new ImageView("/com/sotda/imagenes/consultar.png"));
        btnModificar.setGraphic(new ImageView("/com/sotda/imagenes/modificar.png"));
        
        colNombreDocente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ColTaller.setCellValueFactory(new PropertyValueFactory<>("taller"));
        colEspacio.setCellValueFactory(new PropertyValueFactory<>("espacio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        consultar();
    }

    @FXML
    private void altaDocente(ActionEvent event) {
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
    private void consultarDocente(ActionEvent event) {
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
    private void inicio(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/consultarDocentes.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

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
        } catch (IndexOutOfBoundsException e) {

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
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    public void consultar() {
        DaoDocente dao = new DaoDocente();
        tablaDocente.getItems().clear();
        tablaDocente.getItems().addAll(dao.consultarDocentes());
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
