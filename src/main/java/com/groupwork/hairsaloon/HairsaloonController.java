package com.groupwork.hairsaloon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HairsaloonController {
    public TextField usernameInputfield;
    public PasswordField passwordInputfield;
    @FXML
    private Label welcomeText;

    @FXML

    public void loginUserActionButton(ActionEvent actionEvent) {
        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        msql.TryUserLogin(email,password);
    }
}

//button not there.