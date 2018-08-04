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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        txtMatricula.setText(bean.getMatricula());
        txtNombre.setText(bean.getNombreAlumno());
        txtCuatrimestre.setText(Integer.toString(bean.getCuatrimestre()));
        txtGrupo.setText(bean.getGrupo());
        txtContra.setText(FXMLDocumentController.user.getContra());
        switch (bean.getCarrera()) {
            case 1:
                txtCarrera.setText("Procesos industriales área: Manufactura");
                break;
            case 2:
                txtCarrera.setText("Tecnologías de la información y comunicación área: Redes y telecomunicaciones");
                break;
            case 3:
                txtCarrera.setText("Tecnologías de la información y comunicación área: Sistemas informáticos");
                break;
            case 4:
                txtCarrera.setText("Terapia Física área: Rehabilitación");
                break;
            case 5:
                txtCarrera.setText("Terapia física área: Turismo de salud y bienestar");
                break;
            case 6:
                txtCarrera.setText("Diseño Digital");
                break;
            case 7:
                txtCarrera.setText("Administración área: Capital Humano");
                break;
            case 8:
                txtCarrera.setText("Diseño y moda industrial área: Producción");
                break;
            case 9:
                txtCarrera.setText("Mantenimiento área: Industrial");
                break;
            case 10:
                txtCarrera.setText("Mecatrónica área: Automatización");
                break;
            case 11:
                txtCarrera.setText("Desarrollo de negocios área: Mercadotecnia");
                break;
            case 12:
                txtCarrera.setText("Nanotecnología área: Materiales");
                break;
            case 13:
                txtCarrera.setText("Tecnologías de la información");
                break;
            case 14:
                txtCarrera.setText("Ingeniería industrial");
                break;
            case 15:
                txtCarrera.setText("Mecatrónica");
                break;
            case 16:
                txtCarrera.setText("Nanotecnología");
                break;
            case 17:
                txtCarrera.setText("Negocios y gestión empresarial");
                break;
            case 18:
                txtCarrera.setText("Diseño textil y moda");
                break;
            case 19:
                txtCarrera.setText("Mantenimiento industrial");
                break;
            default:
                break;
        }
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
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }
    public void consultarMasDatos(){
        DaoAlumno daoAlumno = new DaoAlumno();
    }

}
