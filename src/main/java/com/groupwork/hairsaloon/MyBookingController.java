package com.groupwork.hairsaloon;

import Trickster.User;
import Trickster.mysql;
import Trickster.BookingDetails;
import Trickster.mysql;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
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
public class MyBookingController implements Initializable{
    mysql msql = mysql.getInstance();

    @FXML
    private Button createBookingButton;

    @FXML
    private Button createcustomer;

    private Button findCostumer1;
    @FXML
    private Button editBookingButton;

    @FXML
    private Button findBookingButton;
    @FXML
    private TableView<?> costumerBookingList;

    @FXML
    private Button createBooking;


    @FXML
    private Button findcustomer;
    private Button editBooking;





    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane myBookingAncorpane;

    @FXML
    private Button myBookingButton;

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
    void createcustomerScene(ActionEvent event) {
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

    //get overwritten in in initialize method - not sure where or how
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




    @FXML
    private TableView<BookingDetails> customerBookingList;

    private final ObservableList<BookingDetails> data =
            FXCollections.observableArrayList(
                    msql.getMyBooking(customerBookingList)

                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...
                    //Kald BookingDetails her...

            );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        final Label label = new Label("Mine aftaler");

        label.setFont(new Font("Arial", 20));






        //TODO
        //Throw all of this into its own method in sql and call it in initialize
        //also just use setters and getters where ever necessary
        customerBookingList.setEditable(true);

        TableColumn column_Date = new TableColumn("Dato");
        column_Date.setMinWidth(100);
        column_Date.setCellValueFactory(new PropertyValueFactory<BookingDetails, Date>("date"));

        TableColumn column_Time = new TableColumn("Tid");
        column_Time.setMinWidth(100);
        column_Time.setCellValueFactory(new PropertyValueFactory<BookingDetails, Time>("time"));

        TableColumn column_EmpName = new TableColumn("Frisør");
        column_EmpName.setMinWidth(100);
        column_EmpName.setCellValueFactory(new PropertyValueFactory<BookingDetails, String>("employeeName"));

        TableColumn column_TreatmentName = new TableColumn("Behandling");
        column_TreatmentName.setMinWidth(100);
        column_TreatmentName.setCellValueFactory(new PropertyValueFactory<BookingDetails, String>("treatmentName"));

        TableColumn column_TreatmentDuration = new TableColumn("Varighed");
        column_TreatmentDuration.setMinWidth(100);
        column_TreatmentDuration.setCellValueFactory(new PropertyValueFactory<BookingDetails, String>("treatmentDuration"));

        TableColumn column_TreatmentPrice = new TableColumn("Pris");
        column_TreatmentPrice.setMinWidth(100);
        column_TreatmentPrice.setCellValueFactory(new PropertyValueFactory<BookingDetails, String>("treatmentPrice"));

        customerBookingList.setItems(data);

        customerBookingList.getColumns().addAll(column_Date, column_Time, column_EmpName, column_TreatmentName, column_TreatmentDuration, column_TreatmentPrice);

        final VBox vbox = new VBox();

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, customerBookingList);

        //javafx.fxml.LoadException:
        ///D:/Datamatiker/2nd%20semester/projekter/Hairsaloon/target/classes/com/groupwork/hairsaloon/MyBookingScene.fxml

        //Cannot invoke "javafx.scene.Scene.getRoot()" because the return value of "javafx.scene.control.TableView.getScene()" is null
                // TODO this is not a scene thats why it fails
        ((Group) customerBookingList.getScene().getRoot()).getChildren().addAll(vbox);

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


