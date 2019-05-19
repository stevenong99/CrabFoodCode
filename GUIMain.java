/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Data.Orders;
import Data.Restaurants;
import Data.WaitLine;
import Map.Map;
import TextReaders.Customertxtreader;
import Graphics.Launcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Crimson
 */
public class GUIMain extends Application implements EventHandler<ActionEvent> {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Launcher launch = new Launcher();
        Handler handler = launch.getHandler();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Graphics/FXML.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        MainController mc = fxmlLoader.<MainController>getController();
        mc.setHandler(handler);
        Scene scene = new Scene(root);
        primaryStage.setTitle("CrabFood");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {

    }

}
