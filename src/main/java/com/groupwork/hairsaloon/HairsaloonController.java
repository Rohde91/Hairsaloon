package com.groupwork.hairsaloon;

import Trickster.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Objects;

public class HairsaloonController {
    public TextField usernameInputfield;
    public PasswordField passwordInputfield;
    public User user;




    @FXML
    public void loginUserActionButton(ActionEvent actionEvent) {
        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        user=msql.TryUserLogin(email, password);

        //scene swicht to Menu
        if (msql.userType(email).equals("Employee") || msql.userType(email).equals("Customer")) {
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
    }
}

//button not there.