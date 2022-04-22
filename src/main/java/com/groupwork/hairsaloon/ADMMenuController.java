package com.groupwork.hairsaloon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ADMMenuController implements Initializable {
        //Admin Controller
        @FXML
        private Button createBooking;

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
            try {
                LoginController hc = new LoginController();
                hc.user = null;
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FindBooking.fxml")));
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
            try {
                LoginController hc = new LoginController();
                hc.user = null;
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyBookingScene.fxml")));
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
        }

}
