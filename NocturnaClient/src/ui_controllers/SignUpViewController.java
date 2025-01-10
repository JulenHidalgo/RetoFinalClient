/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controllers;

import control.UserManagerSingleton;
import java.io.IOException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Client;
import model.User;

/**
 *
 * @author 2dam
 */
public class SignUpViewController {

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

    private Stage stage;

    private User user;

    private boolean tema;

    private final Logger LOGGER = Logger.getLogger("crudbankjfxclient.view");

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTema(boolean tema) {
        this.tema = tema;
    }

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
        LOGGER.info("Initializing Bank Statement window.");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //Si el usuario es null, significa que no ha entrado a la app todavía y 
        //está intentando registrarse, si no, significa que va a modificar su información.
        if (this.user == null) {
            stage.setTitle("Registro de usuarios");
            btnCambioPass.setVisible(false);
            btnElimCuenta.setVisible(false);
            btnModificarDatos.setVisible(false);
        } else {
            stage.setTitle("Modificar información");
            btnSignUp.setVisible(false);
            hbTienesCuenta.setVisible(false);
            vbPass.setVisible(false);
            vbPass2.setVisible(false);
            vbDni.setVisible(false);
            tfNombre.setText(((Client) user).getNombre());
            tfNombre.setText(((Client) user).getNombre());
        }
        stage.setOnCloseRequest(this::closeAppFromX);
        btnSignUp.setOnAction(this::signUp);
        btnCambioPass.setOnAction(this::cambiarPass);

        stage.show();
        LOGGER.info("Bank Statement window initialized.");

    }

    private void cambiarPass(ActionEvent event) {

    }

    public void signUp(ActionEvent event) {
        try {
            if (tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty()
                    || tfCiudad.getText().isEmpty() || tfTelefono.getText().isEmpty()
                    || tfDni.getText().isEmpty() || dpfechaNac.getValue() == null
                    || tfMail.getText().isEmpty() || pfPass.getText().isEmpty()) {

                LOGGER.warning("Hay campos vacios");
                lanzarAlertErrorCustom("Todos los campos tienen que estar llenos");
                throw new Exception();
            }

            Client client = new Client();
            client.setNombre(tfNombre.getText());
            client.setApellido(tfApellido.getText());
            client.setCiudad(tfCiudad.getText());
            client.setTelefono(Integer.parseInt(tfTelefono.getText()));
            System.out.println(dpfechaNac.getValue());
            client.setFechaNacimiento(Date.valueOf(dpfechaNac.getValue()));
            client.setDni(tfDni.getText());
            client.setMail(tfMail.getText());
            client.setPasswd(pfPass.getText());

            //lamar al metodo que hace signUp
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/showAllEventsView.fxml"));

            Parent root = loader.load();

            ShowAllEventsViewController controller = (ShowAllEventsViewController) loader.getController();

            controller.setStage(stage);

            controller.initStage(root);

            controller.initStage(root);
            
        } catch (IOException e) {
            lanzarAlertErrorCustom("Ha sucedido un error al cargar la ventana");
            LOGGER.warning("Ha sucedido un error al cargar la ventana");
        } catch (NumberFormatException e) {
            lanzarAlertErrorCustom("Formato de número incorrecto: " + e.getMessage());
        } catch (Exception e) {
            //LOGGER.log(Level.INFO, String.valueOf(dpfechaNac.getValue()));
            LOGGER.log(Level.INFO, "Error general {0}", e.getMessage());
        }

    }

}
