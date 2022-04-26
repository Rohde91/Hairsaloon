module com.groupwork.hairsaloon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;



    exports com.groupwork.hairsaloon;
    opens com.groupwork.hairsaloon to javafx.fxml;

    exports Gamez4ever;
    opens Gamez4ever to javafx.fxml;

    exports Trickster;
    opens Trickster to javafx.fxml;
}