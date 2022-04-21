package com.groupwork.hairsaloon;

import Gamez4ever.CalenderFunctions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Hairsaloon extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(Hairsaloon.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Hårmoni'ka!");
        stage.setScene(scene);
        stage.show();*/

        //with css
        Parent root = FXMLLoader.load(Hairsaloon.class.getResource("Login.fxml"));
        Scene scene1 = new Scene(root);
        String Css = this.getClass().getResource("calenderCSS.css").toExternalForm();
        //scene1.getStylesheets().add(css);
        stage.setScene(scene1);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}