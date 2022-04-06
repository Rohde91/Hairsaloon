module com.groupwork.hairsaloon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.groupwork.hairsaloon to javafx.fxml;
    exports com.groupwork.hairsaloon;
}