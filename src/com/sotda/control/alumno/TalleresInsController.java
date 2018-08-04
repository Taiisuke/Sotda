/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control.alumno;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.alumno.BeanTalleresInscritos;
import com.sotda.modelo.alumno.DaoAlumno;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TalleresInsController implements Initializable {

    @FXML
    private VBox vbContenedor;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnTalleres;
    @FXML
    private Button btnDescargar;
    @FXML
    private TableView<BeanTalleresInscritos> tableTaller;
    @FXML
    private TableColumn<BeanTalleresInscritos, String> nombreTaller;
    @FXML
    private TableColumn<BeanTalleresInscritos, String> grupoTaller;
    @FXML
    private TableColumn<BeanTalleresInscritos, String> docenteTaller;
    @FXML
    private TableColumn<BeanTalleresInscritos, String> horarioTaller;
    @FXML
    private TableColumn<BeanTalleresInscritos, String> estadoGrupo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnDescargar.setGraphic(new ImageView("/com/sotda/imagenes/download.png"));
       nombreTaller.setCellValueFactory(new PropertyValueFactory<>("nombreTaller"));
        grupoTaller.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        docenteTaller.setCellValueFactory(new PropertyValueFactory<>("docente"));
        horarioTaller.setCellValueFactory(new PropertyValueFactory<>("horario"));
        estadoGrupo.setCellValueFactory(new PropertyValueFactory<>("estado"));
        pintarTabla();
    }    
    public void pintarTabla(){
        DaoAlumno daoAlumno = new DaoAlumno();
        List<BeanTalleresInscritos> listaPintar = daoAlumno.consultarTallerIncrito();
        tableTaller.getItems().clear();
        tableTaller.getItems().addAll(listaPintar);
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
    private void cerrarSesion(ActionEvent event) {
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
    private void talleres(ActionEvent event) {
    }

    @FXML
    private void descargar(ActionEvent event) {
    }

    
}
