package Trickster;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Time;
import java.util.Date;

public class BookingDetails {

    private int bookingID;

    private int fk_customerID;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String customerPassword;

    private Time time;
    private Date date;

    private int fk_TreatmentID;
    private String treatmentName;
    private String treatmentPrice;
    private String treatmentDuration;

    private int fk_EmployeeID;
    private String employeeName;
    private String employeeEmail;
    private String employeeAddress;
    private String employeePhone;
    private String employeePassword;

    //SimpleStringProperties:

    private SimpleStringProperty simple_time;
    private SimpleStringProperty simple_date;
    private SimpleStringProperty simple_employeeName;
    private SimpleStringProperty simple_treatmentName;
    private SimpleStringProperty simple_treatmentDuration;
    private SimpleStringProperty simple_treatmentPrice;


    public BookingDetails(SimpleStringProperty simple_time, SimpleStringProperty simple_date, SimpleStringProperty simple_employeeName, SimpleStringProperty simple_treatmentName, SimpleStringProperty simple_treatmentDuration, SimpleStringProperty simple_treatmentPrice) {
        this.simple_time = simple_time;
        this.simple_date = simple_date;
        this.simple_employeeName = simple_employeeName;
        this.simple_treatmentName = simple_treatmentName;
        this.simple_treatmentDuration = simple_treatmentDuration;
        this.simple_treatmentPrice = simple_treatmentPrice;
    }

    public String getSimple_time() {
        return simple_time.get();
    }

    public SimpleStringProperty simple_timeProperty() {
        return simple_time;
    }

    public void setSimple_time(String simple_time) {
        this.simple_time.set(simple_time);
    }

    public String getSimple_date() {
        return simple_date.get();
    }

    public SimpleStringProperty simple_dateProperty() {
        return simple_date;
    }

    public void setSimple_date(String simple_date) {
        this.simple_date.set(simple_date);
    }

    public String getSimple_employeeName() {
        return simple_employeeName.get();
    }

    public SimpleStringProperty simple_employeeNameProperty() {
        return simple_employeeName;
    }

    public void setSimple_employeeName(String simple_employeeName) {
        this.simple_employeeName.set(simple_employeeName);
    }

    public String getSimple_treatmentName() {
        return simple_treatmentName.get();
    }

    public SimpleStringProperty simple_treatmentNameProperty() {
        return simple_treatmentName;
    }

    public void setSimple_treatmentName(String simple_treatmentName) {
        this.simple_treatmentName.set(simple_treatmentName);
    }

    public String getSimple_treatmentDuration() {
        return simple_treatmentDuration.get();
    }

    public SimpleStringProperty simple_treatmentDurationProperty() {
        return simple_treatmentDuration;
    }

    public void setSimple_treatmentDuration(String simple_treatmentDuration) {
        this.simple_treatmentDuration.set(simple_treatmentDuration);
    }

    public String getSimple_treatmentPrice() {
        return simple_treatmentPrice.get();
    }

    public SimpleStringProperty simple_treatmentPriceProperty() {
        return simple_treatmentPrice;
    }

    public void setSimple_treatmentPrice(String simple_treatmentPrice) {
        this.simple_treatmentPrice.set(simple_treatmentPrice);
    }

    public BookingDetails() {
    }

    public BookingDetails(int bookingID, int fk_customerID, String customerName, String customerEmail, String customerPhone, String customerAddress, String customerPassword, Time time, Date date, int fk_TreatmentID, String treatmentName, String treatmentPrice, String treatmentDuration, int fk_EmployeeID, String employeeName, String employeeEmail, String employeeAddress, String employeePhone, String employeePassword) {
        this.bookingID = bookingID;
        this.fk_customerID = fk_customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerPassword = customerPassword;
        this.time = time;
        this.date = date;
        this.fk_TreatmentID = fk_TreatmentID;
        this.treatmentName = treatmentName;
        this.treatmentPrice = treatmentPrice;
        this.treatmentDuration = treatmentDuration;
        this.fk_EmployeeID = fk_EmployeeID;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeePassword = employeePassword;
    }

    public BookingDetails(Time time, Date date, String treatmentName, String treatmentPrice, String treatmentDuration, String employeeName) {
        this.time = time;
        this.date = date;
        this.treatmentName = treatmentName;
        this.treatmentPrice = treatmentPrice;
        this.treatmentDuration = treatmentDuration;
        this.employeeName = employeeName;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getFk_customerID() {
        return fk_customerID;
    }

    public void setFk_customerID(int fk_customerID) {
        this.fk_customerID = fk_customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
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

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getTreatmentPrice() {
        return treatmentPrice;
    }

    public void setTreatmentPrice(String treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public int getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(int fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}
