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


        //TEST
        setLabel(2,2,"test");

    }

    //TODO HUSK at sætte diverse ting, som bliver sat herunder i Initialize, så der er noget data, der er "preloaded".
    @FXML
    void weekSelected(MouseEvent event) {
        System.out.println("Spinner change");
        System.out.println(WeekSpinner.getValue());
        CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).forEach(System.out::println);
        //evt sæt labels i kalenderen MON, Tue etc. til også at vise dato?:
        startdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0).toString());
        slutdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4).toString());
        //buildCalendar();
        //mysql.getBookingsByWeekAndEmployee(mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0), CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        ArrayList<Booking> bookings = new ArrayList();
        bookings = mysql.TESTgetBookingsByWeekAndEmployee(mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0), CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        for(Booking booking: bookings) {
            System.out.println(booking.toString());
            setLabel(CalenderFunctions.getTimeIndex(booking.getTime().toString()),CalenderFunctions.getDayOfWeekIndex(booking.getDate()),"OPTAGET");
        }

        /*System.out.println(al.toString());
        System.out.println(al.size());*/

        //TODO Oversæt fra dato og tid til indexnumre
        //Dato->MON->1
        //Tid->8:00->1
        //Returnerer dato som int, 6 = fredag (kolonne 0 bruges til tider, ikke dage, så det er fint)
        System.out.println(CalenderFunctions.getDayOfWeekIndex(bookings.get(0).getDate()));
        System.out.println(CalenderFunctions.getTimeIndex(bookings.get(0).getTime().toString()));
        //setLabel(CalenderFunctions.getDayOfWeekIndex(bookings.get(0).getDate()),CalenderFunctions.getTimeIndex(bookings.get(0).getTime().toString()), "test");
        //setLabel(CalenderFunctions.getTimeIndex(bookings.get(0).getTime().toString()),CalenderFunctions.getDayOfWeekIndex(bookings.get(0).getDate()),"DET VIRKER");

        //Virker:
        //setLabel(CalenderFunctions.getTimeIndex(bookings.get(0).getTime().toString()),CalenderFunctions.getDayOfWeekIndex(bookings.get(0).getDate()),"OPTAGET");
    }


    // Sæt aftale tirsdag kl 8:30 til "Hanne"
    // MON = 1, TUE = 2, WED = 3.
    // 8:00 = 1, 8:30 = 2, 9:00 = 3
    public void setLabel(int TimeIndex, int DayIndex, String labelText) {
        // Sæt coloumn til TUE
        //Label l = (Label) getNodeByRowColumnIndex(DayIndex, TimeIndex, gridPane);
        Node n = getNodeByRowColumnIndex(TimeIndex, DayIndex, gridPane);
        // Sæt row til 2
        Label l = (Label) n;
        l.setText(labelText);
    }



    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();
        int i = 0;
        for (Node node : children) {

            //if (gridPane.getChildren().get(i).getClass().getSimpleName().equalsIgnoreCase("label")) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                    result = node;
                    break;
                }
            //}
            i++;
        }

        return result;
    }

    //TODO Byg ny clearLabels, som rydder alle aftale-labels, men beholder MON, TUE, 8:00, 8:30, etc... skal bruges til at resette
    public void clearLabels() {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            Label l = (Label) node;
            l.setText("");
        }
    }
}

