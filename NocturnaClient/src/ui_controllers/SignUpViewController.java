/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.sql.Date;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import model.Client;

/**
 *
 * @author 2dam
 */
public class SignUpViewController implements Initializable {

    /**
     * Panel principal que contiene los elementos de la interfaz.
     */
    @FXML
    AnchorPane anchorPane;

    @FXML
    TextField tfNombre;

    @FXML
    TextField tfApellido;

    @FXML
    TextField tfTelefono;

    @FXML
    DatePicker dpfechaNac;

    @FXML
    TextField tfCiudad;

    @FXML
    VBox vbDni;

    @FXML
    TextField tfDni;

    @FXML
    TextField tfMail;

    @FXML
    VBox vbPass;

    @FXML
    PasswordField pfPass;

    @FXML
    VBox vbPass2;

    @FXML
    PasswordField pfPass2;

    @FXML
    HBox hbTienesCuenta;

    @FXML
    Hyperlink hlSignIn;

    @FXML
    Button btnCambioPass;

    @FXML
    Button btnElimCuenta;

    @FXML
    Button btnSignUp;

    @FXML
    Button btnModificarDatos;

    private void closeAppFromX(WindowEvent event) {
        if (lanzarAlertConfirmacionCustom("¿Está seguro de que desea salir?")) {
            Platform.exit();
        } else {
            event.consume();
        }
    }

    private void lanzarAlertErrorCustom(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(mensaje);
        alert.showAndWait();
    }

    private boolean lanzarAlertConfirmacionCustom(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(mensaje);
        Optional<ButtonType> confirmar = alert.showAndWait();
        return confirmar.get() == ButtonType.OK;

    }

    public void initStage(Parent root) {

    }

    public void signUp() {
        try {
            if (tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty()
                    || tfCiudad.getText().isEmpty() || tfTelefono.getText().isEmpty()
                    || dpfechaNac.getValue() == null || tfDni.getText().isEmpty()
                    || tfMail.getText().isEmpty() || pfPass.getText().isEmpty()) {

                lanzarAlertErrorCustom("Todos los campos tienen que estar llenos");
                throw new Exception();
            }
            Client client = new Client();
            client.setNombre(tfNombre.getText());
            client.setApellido(tfApellido.getText());
            client.setCiudad(tfCiudad.getText());
            client.setTelefono(Integer.parseInt(tfTelefono.getText()));
            client.setFehcaNacimiento(Date.valueOf(dpfechaNac.getValue()));
            client.setDni(tfDni.getText());
            client.setMail(tfMail.getText());
            client.setPasswd(pfPass.getText());
        } catch (Exception e) {
            
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
