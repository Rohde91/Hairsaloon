module com.groupwork.hairsaloon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.groupwork.hairsaloon to javafx.fxml;
    exports com.groupwork.hairsaloon;
}