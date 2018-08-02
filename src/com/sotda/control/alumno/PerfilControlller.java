/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control.alumno;

import com.sotda.modelo.usuario.BeanUsuario;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author tadeo
 */
public class PerfilControlller implements Initializable {

    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerfil;
    private VBox vbContenedor;
    @FXML
    private Label nombUsuer;
    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnTalleres;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCuatrimestre;
    @FXML
    private TextField txtGrupo;
    @FXML
    private TextField txtContra;
    @FXML
    private TextField txtConfirmarContra;
    @FXML
    private TextField txtCarrera;
    @FXML
    private TextField txtNContra;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       consultarDatos();
    }

    @FXML
    private void inicio(ActionEvent event) {
        Parent parent1 = null;
        try {

            parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/inicio.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException ex) {

        }
        verticalBox.getChildren().add(0, parent1);

    }

    @FXML
    private void perfil(ActionEvent event) {
        Parent parent1 = null;
        try {
            parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/Perfil.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, parent1);
    }

    private void talleresins(ActionEvent event) {
        Parent parent1 = null;
        try {
            parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/TaleresInscritos.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, parent1);
    }

    private void inscribir(ActionEvent event) {
        Parent parent1 = null;
        try {
            parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/talleres.fxml"));
            verticalBox.getChildren().remove(0);
            verticalBox.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        verticalBox.getChildren().add(0, parent1);
    }

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


    private void consultarDatos() {
        BeanAlumno bean = DaoAlumno.consultarAlumno();
        System.out.println(bean.getNombreAlumno());
        nombUsuer.setText(bean.getNombreAlumno());
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
    private void talleres(ActionEvent event) {
         Parent parent1 = null;
                try {
                    parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/TaleresInscritos.fxml"));
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
