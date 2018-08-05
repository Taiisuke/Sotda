/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.control.alumno;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.alumno.BeanAlumno;
import com.sotda.modelo.usuario.DaoUsuario;
import com.sotda.modelo.carrera.BeanCarrera;
import com.sotda.modelo.carrera.DaoCarrera;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
    private ComboBox<String> txtCarrera;
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
    private Button cancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgLogo.setImage(new Image("/com/sotda/imagenes/halcon_png.png"));
        imgMiniLogo.setImage(new Image("/com/sotda/imagenes/logo-utez.png"));
        
        registro.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        txtCarrera.setPromptText("Selecciona...");
        DaoCarrera daoCarrera = new DaoCarrera(); 
        ObservableList<BeanCarrera> lista = daoCarrera.consultarCarreras();
        for (int i = 0; i < lista.size(); i++) {
            txtCarrera.getItems().add(lista.get(i).getNombreCarrera());
        }
    }    

    @FXML
    private void registro(ActionEvent event) {
        if (txtContraseña.getText().equals(txtConfirmar.getText())) {
            DaoUsuario daoUser = new DaoUsuario();
            int carrera = 0;
            if (txtCarrera.getValue().equals("Procesos industriales área: Manufactura")) {
                carrera = 1;
            }else if (txtCarrera.getValue().equals("Tecnologías de la información y comunicación área: Redes y telecomunicaciones")) {
                carrera = 2;
            }else if (txtCarrera.getValue().equals("Tecnologías de la información y comunicación área: Sistemas informáticos")) {
                carrera = 3;
            }else if (txtCarrera.getValue().equals("Terapia Física área: Rehabilitación")) {
                carrera = 4;
            }else if (txtCarrera.getValue().equals("Terapia física área: Turismo de salud y bienestar")) {
                carrera = 5;
            }else if (txtCarrera.getValue().equals("Diseño Digital")) {
                carrera = 6;
            }else if (txtCarrera.getValue().equals("Administración área: Capital Humano")) {
                carrera = 7;
            }else if (txtCarrera.getValue().equals("Diseño y moda industrial área: Producción")) {
                carrera = 8;
            }else if (txtCarrera.getValue().equals("Mantenimiento área: Industrial")) {
                carrera = 9;
            }else if (txtCarrera.getValue().equals("Mecatrónica área: Automatización")) {
                carrera = 10;
            }else if (txtCarrera.getValue().equals("Desarrollo de negocios área: Mercadotecnia")) {
                carrera = 11;
            }else if (txtCarrera.getValue().equals("Nanotecnología área: Materiales")) {
                carrera = 12;
            }else if (txtCarrera.getValue().equals("Tecnologías de la información")) {
                carrera = 13;
            }else if (txtCarrera.getValue().equals("Ingeniería industrial")) {
                carrera = 14;
            }else if (txtCarrera.getValue().equals("Mecatrónica")) {
                carrera = 15;
            }else if (txtCarrera.getValue().equals("Nanotecnología")) {
                carrera = 16;
            }else if (txtCarrera.getValue().equals("Negocios y gestión empresarial")) {
                carrera = 17;
            }else if (txtCarrera.getValue().equals("Diseño textil y moda")) {
                carrera = 18;
            }else if (txtCarrera.getValue().equals("Mantenimiento industrial")) {
                carrera = 19;
            }

            BeanAlumno beanAlumno = new BeanAlumno(txtMatricula.getText(), txtNombre.getText(), txtap1.getText(), txtap2.getText(),
                    Integer.parseInt(txtCuatrimestre.getText()), txtGrupo.getText(),carrera);
            if (daoUser.registrarUsuario(beanAlumno, txtContraseña.getText())) {
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

    @FXML
    private void cancelar(ActionEvent event) {
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
    }
}
    
