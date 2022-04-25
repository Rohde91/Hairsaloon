package com.groupwork.hairsaloon;

import Trickster.User;
import Trickster.mysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyBookingController extends LoginController implements Initializable {
    mysql msql = mysql.getInstance();

    @FXML
    private Button deleteTreatment1;
    @FXML
    private Button createTreatment1;
    @FXML
    private Button createNewEmployee1;
    @FXML
    private Button editEmployee1;
    @FXML
    private Button deleteEmployee1;
    @FXML
    private Button editTreatment1;
    @FXML
    private Button editCostumerBooking1;
    @FXML
    private Label AdminestratorLabel;

    @FXML
    private Button editCostumer1;
    @FXML
    private Label MedarbejderLabel;
    @FXML
    private Button findCostumer1;
    @FXML
    private Button createCostumer1;
    @FXML
    private Button findBooking;
    @FXML
    private TableView<?> costumerBookingList;

    @FXML
    private Button createBooking;



    @FXML
    private Button editBooking;





    @FXML
    private Button logoutButton;

    @FXML
    void costumerBookingList(ActionEvent event) {

    }

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
    void createCostumerScene(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateCustomer.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void createNewEmployee(ActionEvent event) {
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
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditBokking.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//------------------------------------------------------------------------------------------------------------
        if (msql.userType(user.getEmail()).equals("Customer")) {
            System.out.println("Customer login complete"+" Mybooking");
            AdminestratorLabel.setVisible(false);
            MedarbejderLabel.setVisible(false);
            createCostumer1.setVisible(false);
            findCostumer1.setVisible(false);
            editCostumerBooking1.setVisible(false);
            editCostumer1.setVisible(false);
            editTreatment1.setVisible(false);
            deleteTreatment1.setVisible(false);
            createTreatment1.setVisible(false);
            createNewEmployee1.setVisible(false);
            editEmployee1.setVisible(false);
            deleteEmployee1.setVisible(false);
            findBooking.setVisible(false);


        } else if (msql.userType(user.getEmail()).equals("Employee")) {
            System.out.println("Employee login complete"+" Mybooking");
            AdminestratorLabel.setVisible(false);
            editTreatment1.setVisible(false);
            deleteTreatment1.setVisible(false);
            createTreatment1.setVisible(false);
            createNewEmployee1.setVisible(false);
            editEmployee1.setVisible(false);
            deleteEmployee1.setVisible(false);




        }else if (msql.userType(user.getEmail()).equals("Admin")) {
            System.out.println("Admin login complete" + " Mybooking");

        }else
            System.out.println("ERROR IN: MyBooking");
//------------------------------------------------------------------------------------------------------------
    }

    }


