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


    @FXML
    public void loginUserActionButton(ActionEvent actionEvent) {

        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        //TODO Opret fejlhåndtering her:
        user=msql.TryUserLogin(email, password);

        //scene swicht to Menu

        //TODO duplicated code from mysql trylogin
        if (msql.userType(email).equals("Customer")) {

            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (msql.userType(email).equals("Employee")) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EMPMenu.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (msql.userType(email).equals("Admin")) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ADMMenu.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            WrongTextLabel.setVisible(true);
        }

    }
}