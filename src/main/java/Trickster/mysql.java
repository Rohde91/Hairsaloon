package Trickster;

/**
 * tilføj *.jar til projektet
 * under project structure -> modules -> projektnavn -> Dependencies -> tryk add og peg på jar filen
 * under Database til højre i Intellij -> add database som mysql
 * Højreklik connection navn til højre i Intellij -> Properties -> Advanced set både connection og driver til "requireSSL" til NO
 */

//import Trickster.mysql.cj.util.DnsSrv;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//TODO sørg for at alle sql kald bruger PreparedStatement.

public class mysql {
    private static Connection connection;{

        //what does this method do??
        try {
            connection = connectToMySQL();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static volatile mysql instance;
    private mysql(){
    }

    public static mysql getInstance () {
        mysql result = instance;
        if (result == null) {
            synchronized (mysql.class) {
                result = instance;
                if (result == null) {
                    instance = result = new mysql();
                }
            }
        }
        return result;
    }

    //---------------------------------------------------------------------------------------------------------------

    //Skal denne være en Singleton klasse for sig selv?
    public static Connection connectToMySQL() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://mysql85.unoeuro.com:3306/danielguldberg_dk_db";  // danielguldberg_dk_db
            Connection connectionInternal = DriverManager.getConnection(url, "danielguldberg_dk", "280781");
            return connectionInternal;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //---------------------------------------------------------------------------------------------------------------

    /**
     * FUNCTIONS
     */

    public String userType(String email) {
        String result = "";
        try {
            PreparedStatement userType = connection.
                    prepareStatement("SELECT Type FROM PasswordTable WHERE Email = '" + email + "'");
            ResultSet rs = userType.executeQuery();
            while (rs.next()){
                result = rs.getString("Type");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//clean up var we don't use or need

    //---------------------------------------------------------------------------------------------------------------

    public Customer BuildCustomerObject(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        while (rs.next()) {
            customer.setName(rs.getString("Name"));
            customer.setEmail(rs.getString("Email"));
            customer.setAddress(rs.getString("Address"));
            customer.setPhone(rs.getString("Phone"));
            //customer.setPassword(rs.getString("Password"));
        }
        return customer;
    }

    public Trickster.Employee BuildEmployeeObject(ResultSet rs) throws SQLException {
        Trickster.Employee employee = new Trickster.Employee();
        while (rs.next()) {
            employee.setName(rs.getString("Name"));
            employee.setEmail(rs.getString("Email"));
            employee.setAddress(rs.getString("Address"));
            employee.setPhone(rs.getString("Phone"));
            //employee.setPassword(rs.getString("Password"));
        }   // else if admin bla bla
        return employee;
    }



    public User buildUser(ResultSet resultSet,String email) throws SQLException {
        if (resultSet != null ) {
            if (userType(email).equals("Customer")) {
                System.out.println("Customer login complete");
                return BuildCustomerObject(resultSet);

            } else if (userType(email).equals("Employee")) {
                System.out.println("Employee login complete");
                return BuildEmployeeObject(resultSet);
            }
        }
        else {
            System.out.println("You have no login. Create a new profile");
        }
        return null;
    }
    //---------------------------------------------------------------------------------------------------------------

    public User TryUserLogin (String email, String password) {
        ResultSet buildUserResultset = null;
        String sql;
        String usertype = userType(email);

        try {
            //Prøv at logge ind:
            Statement statement = connection.createStatement();
            sql = "SELECT * FROM PasswordTable" +
                    " WHERE Email='" + email +
                    "' AND Password='" + password +
                    "'";

            ResultSet checkLoginRS = statement.executeQuery(sql);

            if (checkLoginRS.next()){
                sql = "SELECT * FROM " + usertype +
                        " WHERE Email='" + email +
                        "'";
                buildUserResultset = statement.executeQuery(sql);
                return buildUser(buildUserResultset,email);
            }
            else{
                System.out.println("wrong password or email");
                return null;
            }

            // Hvis bruger kan logge ind, skabes customer eller employee objekt og returneres.
            //TODO security flaw, if someone injects a buildUserResultset they will be given access

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //---------------------------------------------------------------------------------------------------------------

    // TODO Husk error handling - fx ved duplicate email
    public void createNewCustomer(String name, String email, String phone, String address, String password) {

        try {
            PreparedStatement addToCustomerTable = connection.
                    prepareStatement("INSERT INTO Customer(Name,Email,Phone,Address) VALUES " +
                            "('" + name
                            + "', '" + email
                            + "', '" + phone
                            + "', '" + address
                            + "')");
            addToCustomerTable.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement addToPasswordTable = connection.
                    prepareStatement("INSERT INTO PasswordTable(Email,Password,Type) VALUES " +
                            "('" + email
                            + "', '" + password
                            + "', '" + "Customer"
                            + "')");
            addToPasswordTable.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------------------------

    //nice to have
    /*public void deleteUser() {
        try {
            PreparedStatement deleteCustomer = connection.
                    prepareStatement("DELETE FROM " + user.getUserSubClass(user) + "s " + " WHERE Email = '" + user.getEmail() + "'");
            deleteCustomer.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    //---------------------------------------------------------------------------------------------------------------


    public void editCustomer(String newName, String email, String newPhone, String newAddress, String newPassword, String newEmail) {
        try {
            PreparedStatement editCustomer = connection.
                    prepareStatement("UPDATE Customer SET email = '" + newEmail
                            + "',name ='" +newName
                            +"', phone = '"+ newPhone
                            +"', address = '" +newAddress
                            + "' WHERE Email = '" + email
                            + "'");
            editCustomer.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement editCustomerPassword = connection.
                    prepareStatement("UPDATE PasswordTable SET Password = '" + newPassword
                            + "' WHERE Email = '" + email
                            + "'");
            editCustomerPassword.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------------------

    public static void flushSQLTable(String tablename) {
        try {
            PreparedStatement posted = connection.prepareStatement("TRUNCATE " + tablename);
            posted.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------------------

    public static void printSQLTable(String tablename) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM " + tablename);
            while (resultsetIDs.next()) {
                System.out.print("ID:" + resultsetIDs.getString(1) + " "
                        + resultsetIDs.getString(2) + " "
                        + resultsetIDs.getString(3) + " "
                        + resultsetIDs.getString(4) + " "
                        + resultsetIDs.getString(5) + " "
                        + resultsetIDs.getString(6));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------------------------

    public static void printOpeningHoursTable(String tablename) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM " + tablename + " ORDER BY dayIndex");
            while (resultsetIDs.next()) {
                System.out.print("ID:" + resultsetIDs.getString(1) + " "
                        + resultsetIDs.getString(2) + " "
                        + resultsetIDs.getString(3));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------------------

    public void createBookingInSQL (Booking booking) {
        try {
            PreparedStatement addToBookingTable = connection.
                    prepareStatement("INSERT INTO Booking(fk_CustomerID, Time, Date, fk_treatmentID, fk_EmployeeID) VALUES " +
                            "('" + booking.getFk_CostumerID()
                            + "', '" + booking.getTime()
                            + "', '" + booking.getDate()
                            + "', '" + booking.getFk_TreatmentID()
                            + "', '" + booking.getFk_EmployeeID()
                            + "')");
            addToBookingTable.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------------------

    public ArrayList loadEmployeeList() {
        ArrayList<String> al = new ArrayList<String>();
        String name = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Employee"); // ORDER BY Name
            while (resultsetIDs.next()) {
                name = resultsetIDs.getString(2);
                al.add(name);
            }
            } catch(Exception e){
                e.printStackTrace();
            }
            return al;
    }

    //---------------------------------------------------------------------------------------------------------------

    public ArrayList loadTreatmentList() {
        ArrayList<String> al = new ArrayList<String>();

        String name = "";
/*        String price = "";
        String duration = "";*/

        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Treatments"); // ORDER BY Name
            while (resultsetIDs.next()) {
                //System.out.print("ID:" + resultsetIDs.getString(2) + " "
/*                        + resultsetIDs.getString(2) + " "/
                 //       + resultsetIDs.getString(3));
                //System.out.println();*/
                name = resultsetIDs.getString(2);
/*                price = resultsetIDs.getString(3);
                duration = resultsetIDs.getString(4);*/

                al.add(name); // + ", " + price + ", " + duration);

            }

        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(al.toString());
        return al;
    }

    //---------------------------------------------------------------------------------------------------------------

    public Double getTreatmentPrice(String treatmentName) {
        Double price = 0.0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Treatments WHERE Name='" + treatmentName + "'"); // ORDER BY Name
            while (resultsetIDs.next()) {
                price = resultsetIDs.getDouble(3);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return price;
    }

    //---------------------------------------------------------------------------------------------------------------

    public Time getTreatmentDuration(String treatmentName) {
        Time duration = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Treatments WHERE Name='" + treatmentName + "'"); // ORDER BY Name
            while (resultsetIDs.next()) {
                duration = resultsetIDs.getTime(4);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return duration;
    }
    //TODO Overvej at lave joined tables i understående, for at slippe for getFk_EmployeeID ?
    //TODO JA! Gør dette før det andet. Eksporter fra SQL til Access og byg join dér.

    //---------------------------------------------------------------------------------------------------------------

    public static ArrayList getBookingsByWeekAndEmployee(Integer fk_employeeID, LocalDate startDate, LocalDate endDate) {
        //Booking array initialisér her
        ArrayList<Booking> bookings = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Booking WHERE fk_EmployeeID='" + fk_employeeID + "' AND Date >= '" + startDate + "' AND Date <= '" + endDate + "'"); // ORDER BY Name
            while (resultsetIDs.next()) {
                //Opret booking her og tilføj til array
                Booking b = new Booking();
                b.setBookingID(resultsetIDs.getInt(1));
                b.setFk_CostumerID(resultsetIDs.getInt(2));
                b.setTime(resultsetIDs.getTime(3));
                b.setDate(resultsetIDs.getDate(4));
                b.setFk_TreatmentID(resultsetIDs.getInt(5));
                b.setFk_EmployeeID(resultsetIDs.getInt(6));
                bookings.add(b);

                //TODO byg int BookingID array her?
                //TODO NEJ BYG HELE BOOKING OBJEKTER OG RETURNER DEM! Booking[]...
                System.out.println(resultsetIDs.getInt(1));
                System.out.println(resultsetIDs.getTime(3));
                System.out.println(resultsetIDs.getDate(4));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //Returnér booking array
        return bookings;
    }

    public static Integer getFk_EmployeeID(String employeeName) {
        Integer id = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultsetIDs = statement.executeQuery("SELECT * FROM Employee WHERE Name='" + employeeName + "'"); // ORDER BY Name
            while (resultsetIDs.next()) {
                 id = resultsetIDs.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }

}