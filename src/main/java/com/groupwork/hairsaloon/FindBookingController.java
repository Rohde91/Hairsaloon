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
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class FindBookingController extends LoginController implements Initializable {
    mysql msql = mysql.getInstance();

    String selectedPhoneNumber;
    String selectedEmployee;

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
    private Button createBooking;

    @FXML
    private Button editBooking;

    @FXML
    private Button findCostumer;

    @FXML
    private Button logoutButton;



    @FXML
    private TableView<?> costumerBookingList;

    @FXML
    private ChoiceBox<?> ChoiceBoxFrisør;
    @FXML
    private ChoiceBox<?> ChoiceBoxPhone;

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
//__________________________________________________________________________________________________________________
        if (msql.userType(user.getEmail()).equals("Customer")) {
            System.out.println("Customer login complete"+" FindBooking");
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
            System.out.println("Employee login complete"+" FindBooking");
            AdminestratorLabel.setVisible(false);
            editTreatment1.setVisible(false);
            deleteTreatment1.setVisible(false);
            createTreatment1.setVisible(false);
            createNewEmployee1.setVisible(false);
            editEmployee1.setVisible(false);
            deleteEmployee1.setVisible(false);




        }else if (msql.userType(user.getEmail()).equals("Admin")) {
            System.out.println("Admin login complete" + " FindBooking");

        }else{
            System.out.println("ERROR IN: FindBooking");}
//_____________________________________________________________________________________________________________

        // Set dropdowns
        ChoiceBox choiceBoxEmployees = ChoiceBoxFrisør;
        ArrayList employees = msql.loadEmployeeList();
        choiceBoxEmployees.getItems().addAll(employees);

        ChoiceBox choiceBoxCustomer = ChoiceBoxPhone;
        ArrayList customer = msql.loadCustomerList();
        choiceBoxCustomer.getItems().addAll(customer);

        //System.out.println(ChoiceBoxFrisør.getValue());
        choiceBoxEmployees.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxEmployees.getItems().get((Integer) number2) != null) {
                    //treatmentName = choiceBoxEmployees.getItems().get((Integer) number2).toString();
                    //System.out.println(choiceBoxEmployees.getItems().get((Integer) number2));
                    selectedEmployee = choiceBoxEmployees.getItems().get((Integer) number2).toString();

                }
            }
        });
        choiceBoxCustomer.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxCustomer.getItems().get((Integer) number2) != null) {
                    //treatmentName = choiceBoxEmployees.getItems().get((Integer) number2).toString();
                    //System.out.println(choiceBoxCustomer.getItems().get((Integer) number2));
                    selectedPhoneNumber = choiceBoxCustomer.getItems().get((Integer) number2).toString();

                }
            }
        });

    }


/*    @FXML
    void test(MouseEvent event) {
        System.out.println("1 "+ChoiceBoxFrisør.getInputMethodRequests());
        System.out.println("2 "+ChoiceBoxFrisør.getUserData());
        System.out.println("3 "+ChoiceBoxFrisør.getValue());
        System.out.println("4 "+ChoiceBoxFrisør.getViewOrder());
        System.out.println("5 "+ChoiceBoxFrisør.getOnMouseClicked());
        System.out.println("5 "+ChoiceBoxFrisør.getOnKeyTyped());

    }*/

//    public void test(javafx.scene.input.InputMethodEvent inputMethodEvent) {
//        System.out.println("1 "+ChoiceBoxFrisør.getInputMethodRequests());
//        System.out.println("2 "+ChoiceBoxFrisør.getUserData());
//        System.out.println("3 "+ChoiceBoxFrisør.getValue());
//    }
}
