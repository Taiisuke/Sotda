/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class altaTallerController implements Initializable {

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
    private VBox verticalBox;
    @FXML
    private TextField txtTaller;
    @FXML
    private TextField txtCupo;
    @FXML
    private ComboBox<?> txtEspacio;
    @FXML
    private TextField txtDocente;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnImagen;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnPeriodos;
    @FXML
    private Button btnsesion;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TableColumn<?, ?> colDia1;
    @FXML
    private Button btnHorarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnConsultarGrupo.setGraphic(new ImageView("/com/sotda/imagenes/consultar.png"));
        btnAltaTaller.setGraphic(new ImageView("/com/sotda/imagenes/crear.png"));
        btnImagen.setGraphic(new ImageView("/com/sotda/imagenes/crear.png"));
        btnCancelar.setGraphic(new ImageView("/com/sotda/imagenes/cancelar.png"));
        btnRegistrar.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        // TODO
    }

    @FXML
    private void altaTaller(ActionEvent event) {
    }

    @FXML
    private void consultarGrupo(ActionEvent event) {
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
    private void inicio(ActionEvent event) {
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
    private void registrar(ActionEvent event) {
        try {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Éxito");
            alerta.setHeaderText("Registar");
            alerta.setContentText("Taller registrado correctamente");
            alerta.show();

        } catch (Exception e) {
            Logger.getLogger(altaTallerController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @FXML
    private void periodos(ActionEvent event) {
    }

    @FXML
    private void imagen(ActionEvent event) {
    }

    @FXML
    private void horario(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

}
