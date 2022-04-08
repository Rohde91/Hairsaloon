package Trickster;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        mysql msql = mysql.getInstance();
        //Employee user1 = new Employee("Karen Klippesen", "kk@klipmig.dk", "Klippevej 14 Hårstrup 4100", "11223344", "1111");
        //msql.editCustomer("1","newEmail@test.dk","666666","Zealand","admin2.0","newEmail@test.dk");
        User user1 = msql.TryUserLogin("e@e.dk","ee");

        visual f = new visual();
        f.look();

        Time t = new Time(1);
        LocalDate dt = LocalDate.of(2022,4,8);
        Booking b = new Booking(1,t,dt,1,1);
        msql.createBookingInSQL(b);



    }
}
