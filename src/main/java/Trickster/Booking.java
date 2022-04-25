package Trickster;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Booking {

    private int bookingID, fk_CustomerID;
    private Time time;
    private Date date;
    private LocalDate ldate;
    private int fk_TreatmentID,	fk_EmployeeID;

    public Booking() {
    }

    public Booking(int fk_customerID, Time time, Date date, int fk_TreatmentID, int fk_EmployeeID) {
        this.fk_CustomerID = fk_customerID;
        this.time = time;
        this.date = date;
        this.fk_TreatmentID = fk_TreatmentID;
        this.fk_EmployeeID = fk_EmployeeID;
    }
    public Booking(int fk_customerID, Time time, LocalDate ldate, int fk_TreatmentID, int fk_EmployeeID) {
        this.fk_CustomerID = fk_customerID;
        this.time = time;
        this.ldate = ldate;
        this.fk_TreatmentID = fk_TreatmentID;
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public LocalDate getLdate() {
        return ldate;
    }

    public void setLdate(LocalDate ldate) {
        this.ldate = ldate;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getFk_customerID() {
        return fk_CustomerID;
    }

    public void setFk_customerID(int fk_customerID) {
        this.fk_CustomerID = fk_customerID;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", fk_customerID=" + fk_CustomerID +
                ", time=" + time +
                ", date=" + date +
                ", fk_TreatmentID=" + fk_TreatmentID +
                ", fk_EmployeeID=" + fk_EmployeeID +
                '}';
    }
}
