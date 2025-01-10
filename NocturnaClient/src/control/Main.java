/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui_controllers.SignUpViewController;


public class Main extends javafx.application.Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/signUpView.fxml"));
        
        Parent root = loader.load();
                
        SignUpViewController controller = (SignUpViewController) loader.getController();

        controller.setStage(stage);
        
        controller.initStage(root);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
