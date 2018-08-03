/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control.alumno;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.alumno.BeanAlumno;
import com.sotda.modelo.usuario.DaoUsuario;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author tadeo
 */
public class ControladorRegistro implements Initializable {

    @FXML
    private VBox vbContenedor;
    @FXML
    private ImageView imgLogo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtGrupo;
    @FXML
    private TextField txtCuatrimestre;
    @FXML
    private PasswordField txtContraseña;
    @FXML
    private PasswordField txtConfirmar;
    @FXML
    private Button registro;
    @FXML
    private ImageView imgMiniLogo;
    @FXML
    private TextField txtap1;
    @FXML
    private TextField txtap2;
    @FXML
    private ComboBox<?> comboCarrera;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgLogo.setImage(new Image("/com/sotda/imagenes/logo-utez.png"));
        
        registro.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
    }    

    @FXML
    private void registro(ActionEvent event) {
        if (txtContraseña.getText().equals(txtConfirmar.getText())) {
            DaoUsuario daoUser = new DaoUsuario();
//            BeanAlumno beanAlumno = new BeanAlumno(txtMatricula.getText(), txtNombre.getText(), txtap1.getText(), txtap2.getText(),
//                    Integer.parseInt(txtCuatrimestre.getText()), txtGrupo.getText(), Integer.parseInt(txtCarrera.getText()));
//            if (daoUser.registrarUsuario(beanAlumno, txtContraseña.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro exitoso");
                alert.setContentText("Se ha registrado correctamente");
                alert.showAndWait();
                Parent pare = null;
                try {
                    pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/FXMLDocument.fxml"));
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                    vbContenedor.getChildren().remove(0);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IndexOutOfBoundsException e) {

                }
                vbContenedor.getChildren().add(0, pare);
            } else {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Registro fallido");
                alert1.setContentText("Error al registrar");
                alert1.show();
            }
        }
        
    
    }
    

