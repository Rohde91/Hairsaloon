package com.groupwork.hairsaloon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HairsaloonController {
    @FXML
    private Stage stage;
    @FXML
    public TextField usernameInputfield;
    @FXML
    public PasswordField passwordInputfield;


    @FXML

    public void loginUserActionButton(ActionEvent actionEvent) {
        String email = usernameInputfield.getText();
        String password = passwordInputfield.getText();
        Trickster.mysql msql = Trickster.mysql.getInstance();
        msql.TryUserLogin(email,password);

        //make a switch for each type of user

        // Switch scene to Menu Scene
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
}
