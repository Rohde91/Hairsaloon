package com.groupwork.hairsaloon;

import Gamez4ever.CalenderFunctions;
import Trickster.Booking;
import Trickster.BookingDetails;
import Trickster.mysql;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class CreateBooking_Controller extends LoginController implements Initializable {
    mysql msql = mysql.getInstance();
    String treatmentName = "";

    Boolean slotSelected = false;
    Label lastLabel;

    Time selectedTime;
    LocalDate selectedDate;
    int selectedEmployeeID;
    int selectedTreatmentID;

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

        if (msql.userType(user.getEmail()).equals("Customer")) {
            System.out.println("Customer login complete"+" Mybooking");
            findBooking.setVisible(false);


        } else if (msql.userType(user.getEmail()).equals("Employee")) {
            System.out.println("Employee login complete"+" Mybooking");





        }else if (msql.userType(user.getEmail()).equals("Admin")) {
            System.out.println("Admin login complete" + " Mybooking");

        }else{
            System.out.println("ERROR IN: MyBooking");}
//__________________________________________________________________________________________________________
        //CalenderFunctions.chooseDate();
        CalenderFunctions.getAllDaysOfTheWeek(20, Locale.ENGLISH).forEach(System.out::println);
        //TODO Giv chooseStylist og chooseStylist1 bedre navne. FX "chooseEmpList" og "chooseTreatmentList"

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
                        selectedTreatmentID = msql.getTreatmentIDFromName(treatmentName);
                    System.out.println(selectedTreatmentID);
                }
            }
        });

        choiceBoxEmployees.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxEmployees.getItems().get((Integer) number2) != null) {
                    selectedEmployeeID = msql.getEmployeeIDFromName(choiceBoxEmployees.getItems().get((Integer) number2).toString());
                    System.out.println(choiceBoxEmployees.getItems().get((Integer) number2));
                    System.out.println(selectedEmployeeID);

                }
            }
        });

        //WeekSpinner:
        SpinnerValueFactory<Integer> weekNumberValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,52,15);
        this.WeekSpinner.setValueFactory(weekNumberValueFactory);
        WeekSpinner.setEditable(true);
        //TODO Load kalender med den uge, som er valgt som standard, og load derefter igen når WeekSpinner ændres - se weekSelected():
    }

    //TODO HUSK at sætte diverse ting, som bliver sat herunder i Initialize, så der er noget data, der er "preloaded".
    @FXML
    void weekSelected(MouseEvent event) {
        //TODO
        // CLEAN CODE LIGE DET HER SPAGHETTI !!!
        // HOWTO:
        // 1.  Importér CalenderFunctions
        // 2.  Opret variable for:
        // 2.1 CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0)
        // 2.2 CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4)
        // 2.3 chooseStylist.getValue().toString()
        // 2.4 startdatoLabel.setText(2.1);
        // 2.5 slutdatoLabel.setText(2.2);
        // 3.  Opret funktion til:
        //     for(Booking booking: bookings) {
        //            setLabel(
        //                    CalenderFunctions.getTimeIndex(booking.getTime().toString()),
        //                    CalenderFunctions.getDayOfWeekIndex(booking.getDate()),
        //                    "OPTAGET");
        //     }

        //TODO Fjern souts...?
        System.out.println("Spinner change");
        System.out.println(WeekSpinner.getValue());
        CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).forEach(System.out::println);

        //evt sæt labels i kalenderen MON, Tue etc. til også at vise dato?:
        startdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0).toString());
        slutdatoLabel.setText(CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4).toString());

        //Opretter array af bookinger med valgt frisør og indenfor start -og slutdato.
        ArrayList<Booking> bookings = new ArrayList();
        bookings = mysql.getBookingsByWeekAndEmployee(
                mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        //TODO KAN FJERNES!
        ArrayList<BookingDetails> bookingDetails = new ArrayList();
        bookingDetails = msql.getBookingDetailsByWeekAndEmployee(mysql.getFk_EmployeeID(chooseStylist.getValue().toString()),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(0),
                CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(4));

        clearLabels();

        //Markér alle optagede timeslots med teksten 'OPTAGET':
        for(Booking booking: bookings) {
            setLabel(
                    CalenderFunctions.getTimeIndex(booking.getTime().toString()),
                    CalenderFunctions.getDayOfWeekIndex(booking.getDate()),
                    "OPTAGET");
            setRedLabelColor(
                    CalenderFunctions.getTimeIndex(booking.getTime().toString()),
                    CalenderFunctions.getDayOfWeekIndex(booking.getDate()));
        }
    }
    public void setRedLabelColor(int TimeIndex, int DayIndex) {
        Node n = getNodeByRowColumnIndex(TimeIndex, DayIndex, gridPane);
        Label l = (Label) n;
        l.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
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
            //clear alle labels, der ikke er overskrifter (ikke række 0 eller kolonne 0)
            if (GridPane.getRowIndex(node)>0 && GridPane.getColumnIndex(node)>0) {
                Label l = (Label) node;
                l.setBackground(null); //new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY))
                l.setText("     -          ");
            }
        }
    }

    @FXML
    private Label selectedTimeSlotLabel;

    //TODO Der skal sikkert sættes nogle variable her, til når en create booking funktion kaldes...
    @FXML
    void createBookingSlot(MouseEvent event) throws ParseException {
        System.out.println("test: you clicked on a time slot");
        //System.out.println(event.getSource());
        Label l = (Label) event.getSource();
        System.out.println("Række: " + GridPane.getRowIndex(l));
        System.out.println("Kolonne: " + GridPane.getColumnIndex(l));

        if (!l.getText().equalsIgnoreCase("optaget")) {
            //Først test om der allerede er sat en time slot. Hvis der er, clear lastLabel:
            //TODO Opret bookinger med flere halve timer:


            if (l.getBackground() == null && lastLabel != null) {
                lastLabel.setBackground(null); //new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY))
                lastLabel.setText("     -          ");
            }


            l.setText("BOOK");
            l.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

            selectedTimeSlotLabel.setText(CalenderFunctions.getTime(GridPane.getRowIndex(l)) + " " + CalenderFunctions.getDayOfWeek(GridPane.getColumnIndex(l)));

            String strTime = CalenderFunctions.getTime(GridPane.getRowIndex(l)); // "20:15:40";
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            Time timeValue = new Time(formatter.parse(strTime).getTime());
            selectedTime = timeValue;

            selectedDate = CalenderFunctions.getAllDaysOfTheWeek(WeekSpinner.getValue(), Locale.ENGLISH).get(GridPane.getColumnIndex(l)-1);

            lastLabel = l;

        } else {
            //TODO Lav pop-up-box eller label til at vise beskeden:
            System.out.println("Du kan ikke vælge et tidspunkt, der allerede er optaget. Prøv igen.");
        }
    }

    @FXML
    void createBookingInSQLButton(MouseEvent event) {

        Booking b = new Booking();
        b.setTime(selectedTime);
        b.setLdate(selectedDate);
        b.setFk_EmployeeID(selectedEmployeeID);
        b.setFk_TreatmentID(selectedTreatmentID);
        LoginController lc = new LoginController();
        b.setFk_CostumerID(lc.user.getId());


        msql.createBookingInSQL(b);

        //TODO Send user videre til næste skærm.
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
}

