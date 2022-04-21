package com.groupwork.hairsaloon;

import Gamez4ever.CalenderFunctions;
import Trickster.Booking;
import Trickster.mysql;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class CreateBooking_Controller implements Initializable {
    mysql msql = mysql.getInstance();
    String treatmentName = "";

    @FXML
    private ChoiceBox<?> chooseStylist;

    @FXML
    private ChoiceBox<?> chooseStylist1;

    @FXML
    private Spinner<Integer> WeekSpinner;


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
    private GridPane gridPane;

    @FXML
    private Label slutdatoLabel;

    @FXML
    private Label startdatoLabel;

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
        try {
            HairsaloonController hc = new HairsaloonController();
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
        //CalenderFunctions.chooseDate();
        CalenderFunctions.getAllDaysOfTheWeek(20, Locale.ENGLISH).forEach(System.out::println);
        // Giv chooseStylist og chooseStylist1 bedre navne.
        clearLabels();

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

        //WeekSpinner:
        SpinnerValueFactory<Integer> weekNumberValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,52,15);
        this.WeekSpinner.setValueFactory(weekNumberValueFactory);
        WeekSpinner.setEditable(true);
        //TODO Load kalender med den uge, som er valgt som standard, og load derefter igen når WeekSpinner ændres - se weekSelected():
        //weekspinner ER lavet, mangler on load.

        //TEST
        //setLabel(2,2,"test");

    }

    //TODO HUSK at sætte diverse ting, som bliver sat herunder i Initialize, så der er noget data, der er "preloaded".
    @FXML
    void weekSelected(MouseEvent event) {
        //TODO CLEAN CODE LIGE DET HER SPAGHETTI !!!

        System.out.println("Spinner change");
        System.out.println(WeekSpinner.getValue());
        CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).forEach(System.out::println);
        //evt sæt labels i kalenderen MON, Tue etc. til også at vise dato?:
        startdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0).toString());
        slutdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4).toString());

        //Opretter array af bookinger som er fra valgt frisør og indenfor start -og slutdato.
        ArrayList<Booking> bookings = new ArrayList();
        bookings = mysql.getBookingsByWeekAndEmployee(
                mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        msql.getBookingDetailsByWeekAndEmployee(mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        //TODO Oversæt fra dato og tid til indexnumre
        //Dato->MON->1
        //Tid->8:00->1
        //Returnerer dato som int ugedag.
        System.out.println(CalenderFunctions.getDayOfWeekIndex(bookings.get(0).getDate()));
        //Returnerer tid som int index". Bruger toString da HashMap kun kan bruge String og Int, så ingen Date eller Time...
        System.out.println(CalenderFunctions.getTimeIndex(bookings.get(0).getTime().toString()));

        clearLabels();

        //Marker alle optagede timeslots med teksten 'OPTAGET':
        for(Booking booking: bookings) {
            setLabel(
                    CalenderFunctions.getTimeIndex(booking.getTime().toString()),
                    CalenderFunctions.getDayOfWeekIndex(booking.getDate()),
                    "OPTAGET");
        }
    }

    public void setLabel(int TimeIndex, int DayIndex, String labelText) {
        Node n = getNodeByRowColumnIndex(TimeIndex, DayIndex, gridPane);
        Label l = (Label) n;
        l.setText(labelText);
    }

    //TODO Evt fjern gridPane, den er allerede sat som global var.
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                    result = node;
                    break;
                }
        }
        return result;
    }

    public void clearLabels() {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            //clear alle labels, der ikke er overskrifter
            if (GridPane.getRowIndex(node)>0 && GridPane.getColumnIndex(node)>0) {
                Label l = (Label) node;
                l.setText("-");
            }

        }
    }
}

