package Trickster;

import java.sql.Time;
import java.util.Date;

public class BookingDetails {

    private int bookingID;

    private int fk_CostumerID;
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

    public BookingDetails() {
    }

    public BookingDetails(int bookingID, int fk_CostumerID, String customerName, String customerEmail, String customerPhone, String customerAddress, String customerPassword, Time time, Date date, int fk_TreatmentID, String treatmentName, String treatmentPrice, String treatmentDuration, int fk_EmployeeID, String employeeName, String employeeEmail, String employeeAddress, String employeePhone, String employeePassword) {
        this.bookingID = bookingID;
        this.fk_CostumerID = fk_CostumerID;
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
