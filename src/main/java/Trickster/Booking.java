package Trickster;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Booking {

    private int bookingID, fk_CostumerID;
    private Time time;
    private LocalDate date;
    private int fk_TreatmentID,	fk_EmployeeID;

    public Booking() {
    }

    public Booking(int fk_CostumerID, Time time, LocalDate date, int fk_TreatmentID, int fk_EmployeeID) {
        this.fk_CostumerID = fk_CostumerID;
        this.time = time;
        this.date = date;
        this.fk_TreatmentID = fk_TreatmentID;
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getFk_CostumerID() {
        return fk_CostumerID;
    }

    public void setFk_CostumerID(int fk_CostumerID) {
        this.fk_CostumerID = fk_CostumerID;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getFk_TreatmentID() {
        return fk_TreatmentID;
    }

    public void setFk_TreatmentID(int fk_TreatmentID) {
        this.fk_TreatmentID = fk_TreatmentID;
    }

    public int getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(int fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }
}
