/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.modelo.docente.BeanDocente;
import com.sotda.modelo.docente.DaoDocente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ferna
 */
public class ModificarDocenteController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private TextField nombreDocente;
    @FXML
    private TextField ape1Docente;
    @FXML
    private TextField ape2Docente;
    @FXML
    private TextField numEmpleado;
    @FXML
    private TextField contraseniaActual;
    @FXML
    private TextField correoActual;
    @FXML
    private PasswordField nuevaContrasenia;
    @FXML
    private PasswordField confirmarContrasenia;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextArea habilidadesTecnicas;

    Alert alert = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modificarDocente(ActionEvent event) {
        System.out.println(numEmpleado.getText());
        if (nombreDocente.getText() != null && ape1Docente.getText() != null && ape2Docente.getText() != null
                && habilidadesTecnicas.getText() != null && correoActual.getText() != null && nuevaContrasenia.getText() != null) {
            if (nuevaContrasenia.getText().equals(confirmarContrasenia.getText())) {

                BeanDocente nuevoDocente = new BeanDocente();
                nuevoDocente.setNum_empleado(Integer.parseInt(numEmpleado.getText()));
                nuevoDocente.setNombre(nombreDocente.getText());
                nuevoDocente.setPrimer_apellido(ape1Docente.getText());
                nuevoDocente.setSegundo_apellido(ape2Docente.getText());
                nuevoDocente.setHabilidades_tecnicas(habilidadesTecnicas.getText());
                nuevoDocente.setCorreo(correoActual.getText());
                nuevoDocente.setContra(nuevaContrasenia.getText());
                DaoDocente daoDoc = new DaoDocente();
                if (daoDoc.modificarDocente(nuevoDocente)) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("Se han actualizado los datos correctamente");
                    cancelar(event);
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Ocurrió un error al actualizar los datos");
                    alert.showAndWait();
                }
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Las Contraseñas no coinciden");
                alert.show();
            }
        } else if (nombreDocente.getText() != null && ape1Docente.getText() != null && ape2Docente.getText() != null
                && habilidadesTecnicas.getText() != null && correoActual.getText() != null && nuevaContrasenia.getText() == null && confirmarContrasenia.getText() == null) {

            BeanDocente nuevoDocente = new BeanDocente();
            nuevoDocente.setNum_empleado(Integer.parseInt(numEmpleado.getText()));
            nuevoDocente.setNombre(nombreDocente.getText());
            nuevoDocente.setPrimer_apellido(ape1Docente.getText());
            nuevoDocente.setSegundo_apellido(ape2Docente.getText());
            nuevoDocente.setHabilidades_tecnicas(habilidadesTecnicas.getText());
            nuevoDocente.setCorreo(correoActual.getText());
            nuevoDocente.setContra(contraseniaActual.getText());
            DaoDocente daoDoc = new DaoDocente();
            if (daoDoc.modificarDocente(nuevoDocente)) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("Se han actualizado los datos correctamente");
                cancelar(event);
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Ocurrió un error al actualizar los datos");
                alert.showAndWait();
            }

        } else if (nombreDocente.getText() != null && ape1Docente.getText() != null && ape2Docente.getText() != null
                && habilidadesTecnicas.getText() != null && correoActual.getText() != null && (nuevaContrasenia.getText() != null || confirmarContrasenia.getText() != null)) {
            if (nuevaContrasenia.getText().equals(confirmarContrasenia.getText())) {

                BeanDocente nuevoDocente = new BeanDocente();
                nuevoDocente.setNum_empleado(Integer.parseInt(numEmpleado.getText()));
                nuevoDocente.setNombre(nombreDocente.getText());
                nuevoDocente.setPrimer_apellido(ape1Docente.getText());
                nuevoDocente.setSegundo_apellido(ape2Docente.getText());
                nuevoDocente.setHabilidades_tecnicas(habilidadesTecnicas.getText());
                nuevoDocente.setCorreo(correoActual.getText());
                nuevoDocente.setContra(nuevaContrasenia.getText());
                DaoDocente daoDoc = new DaoDocente();
                if (daoDoc.modificarDocente(nuevoDocente)) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("Se han actualizado los datos correctamente");
                    cancelar(event);
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Ocurrió un error al actualizar los datos");
                    alert.showAndWait();
                }
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("Las Contraseñas no coinciden");
                alert.show();
            }
        }

    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) btnActualizar.getScene().getWindow();
        stage.close();
    }

    public void setDocente(BeanDocente beanDocente) {
        nombreDocente.setText(beanDocente.getNombre());
        ape1Docente.setText(beanDocente.getPrimer_apellido());
        ape2Docente.setText(beanDocente.getSegundo_apellido());
        numEmpleado.setText(Integer.toString(beanDocente.getNum_empleado()));
        numEmpleado.setEditable(false);
        habilidadesTecnicas.setText(beanDocente.getHabilidades_tecnicas());
        correoActual.setText(beanDocente.getCorreo());
        contraseniaActual.setText(beanDocente.getContra());
        contraseniaActual.setEditable(false);
        nuevaContrasenia.setPromptText("Nueva contraseña");
        confirmarContrasenia.setPromptText("Confirmar contraseña");
    }

}
