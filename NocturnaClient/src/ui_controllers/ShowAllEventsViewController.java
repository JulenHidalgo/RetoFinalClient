/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controllers;

import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;
import model.User;

/**
 *
 * @author 2dam
 */
public class ShowAllEventsViewController {

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

    public void initStage(Parent root) {

        LOGGER.info("Initializing Bank Statement window.");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //Si el usuario es null, significa que no ha entrado a la app todavía y 
        //está intentando registrarse, si no, significa que va a modificar su información.

        stage.show();
        LOGGER.info("Bank Statement window initialized.");

    }

}
