package com.groupwork.hairsaloon;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HairsaloonController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

//button not there.