package com.groupwork.hairsaloon;

import Trickster.mysql;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CreateBooking_Controller implements Initializable {
    mysql msql = mysql.getInstance();
    String treatmentName = "";

    @FXML
    private ChoiceBox<?> chooseStylist;

    @FXML
    private ChoiceBox<?> chooseStylist1;

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
    private Label showTreatmentPrice;

    @FXML
    private Label showTreatmentTime;

    @FXML
    void createBookingScene(ActionEvent event) {

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

    }

    @FXML
    void findCostumerScene(ActionEvent event) {

    }

    @FXML
    void myBookingScene(ActionEvent event) {

    }

    @FXML
    void terminateSession(ActionEvent event) {
        try {
            HairsaloonController hc = new HairsaloonController();
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

        // Giv chooseStylist og chooseStylist1 bedre navne.

        // Set dropdowns
        ChoiceBox choiceBoxEmployees = chooseStylist;
        ArrayList employees = msql.loadEmployeeList();
        choiceBoxEmployees.getItems().addAll(employees);

        ChoiceBox choiceBoxTreatments = chooseStylist1;
        ArrayList treatments = msql.loadTreatmentList();
        choiceBoxTreatments.getItems().addAll(treatments);


        choiceBoxTreatments.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxTreatments.getItems().get((Integer) number2) != null) {
                    treatmentName = choiceBoxTreatments.getItems().get((Integer) number2).toString();
                    System.out.println(choiceBoxTreatments.getItems().get((Integer) number2));
                        //rename to showTreatmentDuration:
                        showTreatmentTime.setText(msql.getTreatmentDuration(treatmentName).toString());
                        showTreatmentPrice.setText(msql.getTreatmentPrice(treatmentName).toString());

                }
            }
        });

    }
}

