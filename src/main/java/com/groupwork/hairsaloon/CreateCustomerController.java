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
    private TextField costumerAddressInput;

    @FXML
    private TextField costumerMailInput;

    @FXML
    private TextField costumerNameInput;

    @FXML
    private PasswordField costumerPasswordInput;

    @FXML
    private TextField costumerPhoneInput;

    @FXML
    private Button createBooking;

    @FXML
    private Button createCostumer;

    @FXML
    private Button createCostumerInDatabase;

    @FXML
    private Button editBooking;

    @FXML
    private Button findBooking;

    @FXML
    private Button findCostumer;

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
    void createCostumerButtonAction(ActionEvent event) {
        String name = costumerNameInput.getText();
        String email = costumerMailInput.getText();
        String phone = costumerPhoneInput.getText();
        String address = costumerAddressInput.getText();
        String password = costumerPasswordInput.getText();
        msql.createNewCustomer(name, email, phone, address, password);
        costumerNameInput.setText(null);
        costumerMailInput.setText(null);
        costumerPhoneInput.setText(null);
        costumerAddressInput.setText(null);
        costumerPasswordInput.setText(null);
    }

    @FXML
    void createCostumerScene(ActionEvent event) {

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
    void editCostumerBookingScene(ActionEvent event) {

    }

    @FXML
    void editCostumerScene(ActionEvent event) {

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
    void findCostumerScene(ActionEvent event) {

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
