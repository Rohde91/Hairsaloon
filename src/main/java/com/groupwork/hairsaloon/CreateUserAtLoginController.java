package com.groupwork.hairsaloon;
import Trickster.mysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class CreateUserAtLoginController {
    mysql msql = mysql.getInstance();

    @FXML
    private Label WrongTextLabel;

    @FXML
    private Button createcustomerInDatabase;

    @FXML
    private TextField customerAddressInput;

    @FXML
    private TextField customerMailInput;

    @FXML
    private TextField customerNameInput;

    @FXML
    private PasswordField customerPasswordInput;

    @FXML
    private TextField customerPhoneInput;

    @FXML
    void createcustomerButtonAction(ActionEvent event) {
        String name = customerNameInput.getText();
        String email = customerMailInput.getText();
        String phone = customerPhoneInput.getText();
        String address = customerAddressInput.getText();
        String password = customerPasswordInput.getText();
        msql.createNewCustomer(name, email, phone, address, password);
        customerNameInput.setText(null);
        customerMailInput.setText(null);
        customerPhoneInput.setText(null);
        customerAddressInput.setText(null);
        customerPasswordInput.setText(null);

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
