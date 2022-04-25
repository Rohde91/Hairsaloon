package com.groupwork.hairsaloon;

import Trickster.mysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CreateCustomerController {
    mysql msql = mysql.getInstance();
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
    private Button createBooking;

    @FXML
    private Button createcustomer;

    @FXML
    private Button createcustomerInDatabase;

    @FXML
    private Button editBooking;

    @FXML
    private Button findBooking;

    @FXML
    private Button findcustomer;

    @FXML
    private Button logoutButton;

    @FXML
    void createBookingScene(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateBooking.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    }

    @FXML
    void createcustomerScene(ActionEvent event) {

    }

    @FXML
    void createNewEmployee(ActionEvent event) {

    }

    @FXML
    void createTreatment(ActionEvent event) {

    }

    @FXML
    void deleteEmployee(ActionEvent event) {

    }

    @FXML
    void deleteTreatment(ActionEvent event) {

    }

    @FXML
    void editBookingScene(ActionEvent event) {

    }

    @FXML
    void editcustomerBookingScene(ActionEvent event) {

    }

    @FXML
    void editcustomerScene(ActionEvent event) {

    }

    @FXML
    void editEmployee(ActionEvent event) {

    }

    @FXML
    void editTreatment(ActionEvent event) {

    }

    @FXML
    void findBookingScene(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FindBooking.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void findcustomerScene(ActionEvent event) {

    }

    @FXML
    void myBookingScene(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyBookingScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void terminateSession(ActionEvent event) {
        try {
            LoginController hc = new LoginController();
            hc.user = null;
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
