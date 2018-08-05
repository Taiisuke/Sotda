/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.modelo.periodo.BeanPeriodo;
import com.sotda.modelo.periodo.DaoPeriodo;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Ferna
 */
public class modificarPeriodosController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private RadioButton radioInscrip;
    @FXML
    private RadioButton radioLib;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnCancelar;
    ToggleGroup tipo = new ToggleGroup();

    @FXML
    private DatePicker fechaNuevaFin;
    @FXML
    private DatePicker fechaNuevaInicio;
    @FXML
    private Label fechaAcutalInicio;
    @FXML
    private Label fechaActualFin;
    Alert alert = null;
    String dateInicio;
    String dateFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioInscrip.setToggleGroup(tipo);
        radioLib.setToggleGroup(tipo);
        
        btnCancelar.disableProperty().bind(fechaNuevaFin.valueProperty().isNull().or(
                fechaNuevaInicio.valueProperty().isNull()).or(tipo.selectedToggleProperty().isNull()));
        
        btnActualizar.disableProperty().bind(fechaNuevaInicio.valueProperty().isNull().or(
                fechaNuevaFin.valueProperty().isNull()).or(tipo.selectedToggleProperty().isNull()));

        fechaNuevaInicio.setPromptText(LocalDate.now().toString());
        fechaNuevaFin.setPromptText(LocalDate.now().toString());

        
    }

    @FXML
    private void modificar(ActionEvent event) {
        if (fechaNuevaInicio.getValue().isAfter(fechaNuevaFin.getValue())) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al elegir una fecha");
            alert.setContentText("LA fecha de inicio no puede ser mayor a la fecha fin");
        } else {
            DaoPeriodo daoPeriodo = new DaoPeriodo();
            RadioButton eleccion = (RadioButton) tipo.getSelectedToggle();
            String tipo2 = eleccion.getText();
            int tipoPeriodo2;
            if (tipo2.equals("Inscripción")) {
                tipoPeriodo2 = 1;
            } else {
                tipoPeriodo2 = 2;
            }
            BeanPeriodo beanNuevo = new BeanPeriodo(fechaNuevaInicio.getValue().toString(), fechaNuevaFin.getValue().toString(), Integer.toString(tipoPeriodo2));
            if (daoPeriodo.modificarPeriodo(beanNuevo, dateInicio, dateFinal)) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modificar");
                alert.setContentText("Se ha modificado correctamente");
                cancelar(event);
                alert.show();
            } else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ocurrió un error");
                alert.setContentText("No se pudo modificar los datos");
                alert.show();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage satge = (Stage) btnActualizar.getScene().getWindow();
        satge.close();
    }

    public void setPeriodo(BeanPeriodo bean) {
        dateFinal = bean.getFechaFinal();
        dateInicio = bean.getFechaInicio();
        fechaAcutalInicio.setText(bean.getFechaInicio());
        fechaActualFin.setText(bean.getFechaFinal());
        int tipoPeriodo2 = 0;
            if (bean.getTipoPeriodo().equals("Inscripción")) {
                tipoPeriodo2 = 1;
            } else {
                tipoPeriodo2 = 2;
            }
        if (tipoPeriodo2 == 1) {
            radioInscrip.setSelected(true);
        } else {
            radioLib.setSelected(true);
        }

    }
}
