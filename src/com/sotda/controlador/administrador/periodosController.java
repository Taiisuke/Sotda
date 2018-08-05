/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotda.controlador.administrador;

import com.sotda.controlador.principal.FXMLDocumentController;
import com.sotda.modelo.periodo.BeanPeriodo;
import com.sotda.modelo.periodo.DaoPeriodo;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Esmeralda
 */
public class periodosController implements Initializable {

    @FXML
    private VBox verticalBox;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPeriodos;
    @FXML
    private Button btnTalleres;
    @FXML
    private Button btnDocente;
    @FXML
    private Button btnEspacio;
    @FXML
    private Button btnAlumno;
    @FXML
    private Button btnInicio15;
    @FXML
    private DatePicker dpInicio;
    @FXML
    private DatePicker dpfin;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private RadioButton radioInscrip;
    @FXML
    private RadioButton radioLib;
    @FXML
    private Button btnModificarEsp;
    @FXML
    private Button btnEliminarEsp;
    ToggleGroup tipoPeriodo = new ToggleGroup();
    Alert alert = null;
    @FXML
    private TableColumn<BeanPeriodo, String> colInicio;
    @FXML
    private TableColumn<BeanPeriodo, String> colFin;
    @FXML
    private TableColumn<BeanPeriodo, String> colTipo;
    @FXML
    private TableView<BeanPeriodo> tablaPeriodo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRegistrar.setGraphic(new ImageView("/com/sotda/imagenes/aceptar.png"));
        btnEliminarEsp.setGraphic(new ImageView("/com/sotda/imagenes/eliminar.png"));
        btnCancelar.setGraphic(new ImageView("/com/sotda/imagenes/cancelar.png"));
        btnModificarEsp.setGraphic(new ImageView("/com/sotda/imagenes/modificar.png"));
        radioInscrip.setToggleGroup(tipoPeriodo);
        radioLib.setToggleGroup(tipoPeriodo);
        
        btnModificarEsp.disableProperty().bind(tablaPeriodo.getSelectionModel().selectedItemProperty().isNull());
        btnEliminarEsp.disableProperty().bind(tablaPeriodo.getSelectionModel().selectedItemProperty().isNull());

        btnRegistrar.disableProperty().bind(dpInicio.valueProperty().isNull().or(dpfin.valueProperty().isNull()).or(
        tipoPeriodo.selectedToggleProperty().isNull()));
        btnCancelar.disableProperty().bind(dpInicio.valueProperty().isNull().or(dpfin.valueProperty().isNull()).or(
        tipoPeriodo.selectedToggleProperty().isNull()));

        colInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFin.setCellValueFactory(new PropertyValueFactory<>("fechaFinal"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoPeriodo"));
        pintarTablaPeriodos();
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
    private void periodos(ActionEvent event) {
        Parent pare = null;
        try {
            pare = FXMLLoader.load(getClass().getResource("/com/sotda/vista/administrador/periodos.fxml"));
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
    private void registrar(ActionEvent event) {
        if (dpInicio.getValue().isAfter(dpfin.getValue())) {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error al elegir la fecha");
            alert.setContentText("La fecha inicial no puede ser mayor a la fecha final");
            alert.show();
        } else {

            DaoPeriodo daoPeriodo = new DaoPeriodo();
            RadioButton eleccion = (RadioButton) tipoPeriodo.getSelectedToggle();
            String tipo = eleccion.getText();
            int tipoPeriodo2;
            if (tipo.equals("Inscripción")) {
                tipoPeriodo2 = 1;
            } else {
                tipoPeriodo2 = 2;
            }
            BeanPeriodo beanPeriodo = new BeanPeriodo(dpInicio.getValue().toString(), dpfin.getValue().toString(), Integer.toString(tipoPeriodo2));
            if (daoPeriodo.registrarPeriodo(beanPeriodo)) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("Se han guardado los datos correctamente.");
                alert.show();
                cancelar(event);
                pintarTablaPeriodos();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Ocurrió un error.");
                alert.show();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        dpInicio.setValue(null);
        dpfin.setValue(null);
        radioInscrip.setSelected(false);
        radioLib.setSelected(false);
    }

    @FXML
    private void modificar(ActionEvent event) {
        BeanPeriodo beanPeriodo2 = tablaPeriodo.getSelectionModel().getSelectedItem();
        modificarPeriodosController obj = null;
        Stage stage = new Stage();

        try {
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("/com/sotda/vista/administrador/modificarPeriodo.fxml"));
            Parent parent = cargador.load();
            obj = cargador.getController();
            obj.setPeriodo(beanPeriodo2);

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            pintarTablaPeriodos();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void eliminar(ActionEvent event) {
        BeanPeriodo beanPeriodo2 = tablaPeriodo.getSelectionModel().getSelectedItem();
        DaoPeriodo daoPeriodo = new DaoPeriodo();
        if (daoPeriodo.eliminarPeriodo(beanPeriodo2)) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setContentText("Se han eliminado los datos correctamente.");
            alert.show();
            cancelar(event);
            pintarTablaPeriodos();
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Ocurrió un error.");
            alert.show();
        }
    }

    public void pintarTablaPeriodos() {
        DaoPeriodo daoPeriodo = new DaoPeriodo();
        tablaPeriodo.getItems().clear();
        tablaPeriodo.getItems().addAll(daoPeriodo.consultarPeriodos());
    }
}
