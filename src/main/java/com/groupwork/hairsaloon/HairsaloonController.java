package com.groupwork.hairsaloon;

import Trickster.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Objects;

public class HairsaloonController {
    public TextField usernameInputfield;
    public PasswordField passwordInputfield;
    //TODO rename to loggedInUser:
    public User user;

    @FXML
    private Label WrongTextLabel;

    public void goToMenu(ActionEvent actionEvent,String menuName){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(menuName)));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loginUserActionButton(ActionEvent actionEvent) {

        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        //TODO Opret fejlhåndtering her:
        user=msql.TryUserLogin(email, password);

        System.out.println(user);

        //scene swicht to Menu
        //TODO duplicated code from mysql trylogin

        if (msql.userType(email).equals("Customer") && user != null) {
            goToMenu(actionEvent,"Menu.fxml");
        }

        else if (msql.userType(email).equals("Employee") && user != null) {
            goToMenu(actionEvent,"EMPMenu.fxml");
        }

        else if (msql.userType(email).equals("Admin") && user != null) {
            goToMenu(actionEvent,"ADMMenu.fxml");
        }

        else {
            WrongTextLabel.setVisible(true);
        }
    }
}