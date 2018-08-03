/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.principal;

import com.sotda.modelo.usuario.BeanUsuario;
import com.sotda.modelo.usuario.DaoUsuario;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox vbContenedor;
    @FXML
    private ImageView imgLogo;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContra;
    @FXML
    private Hyperlink lkRegistrate;
    @FXML
    private Button btIniciarSesion;
    public static BeanUsuario user = null;
//    public static BeanAlumno beanAlum = null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ImageView imgMiniLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        btIniciarSesion.disableProperty().bind(txtUsuario.textProperty().isEmpty().or(txtContra.textProperty().isEmpty()));
    }

    @FXML
    private void registroo(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/Registro.fxml"));
            vbContenedor.getChildren().remove(0);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException e) {

        }
        vbContenedor.getChildren().add(0, pare);

    }

    @FXML
    private void inicio(ActionEvent event) {
        DaoUsuario dao = new DaoUsuario();
        user = dao.validarUsuario(txtUsuario.getText(), txtContra.getText());
        if (dao.resultado) {
            switch (user.getTipo()) {
                case 1:
                    Parent paren = null;
                    try {
                        paren = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/inicio.fxml"));
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    vbContenedor.getChildren().add(0, paren);
                    break;
                case 2:
                    Parent parent = null;
                    try {
                        parent = FXMLLoader.load(getClass().getResource("/com/sotda/vista/docente/inicio.fxml"));
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);

                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    vbContenedor.getChildren().add(0, parent);
                    break;
                case 3:
                    Parent parent1 = null;
                    try {
                        parent1 = FXMLLoader.load(getClass().getResource("/com/sotda/vista/alumno/Perfil.fxml"));
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);
                        vbContenedor.getChildren().remove(0);

                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    vbContenedor.getChildren().add(0, parent1);
                    break;
            }

        } else {
            alert.setTitle("Error");
            alert.setContentText("Usuario y/o contraseña incorrecto.");
            alert.show();
        }
    }

}
