package com.groupwork.hairsaloon;

import Gamez4ever.CalenderFunctions;
import Trickster.mysql;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Access joins (Alle) - er lavet.
 *
 * Byg interface (Martin Allan)
 *
 * MyBookingScene skal udfyldes
 *
 * Forskellige login-pages
 *
*/

public class Hairsaloon extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Hairsaloon.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Hårmoni'ka!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}