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
    public void loginUserActionButton(ActionEvent actionEvent) {
        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        msql.TryUserLogin(email,password);
    }

    if (msql.userType(email).equals("Employee")||msql.userType(email).equals("Customer")){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//button not there.