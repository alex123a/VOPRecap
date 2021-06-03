package org.example;

import java.io.IOException;
import java.util.Arrays;

import facade.Facade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController{
    private Facade facade;

    @FXML
    private TextArea textarea;

    @FXML
    private Button fillArrayBut;

    @FXML
    private Button fillUniqueArrayBut;

    @FXML
    private Button divisorBut;

    @FXML
    private TextField sizeField;

    @FXML
    private TextField maxField;

    @FXML
    private TextField divisorField;

    @FXML
    public void initialize() {
        facade = new Facade();
    }

    @FXML
    void buttonHandler(ActionEvent event) {
        if (event.getSource() == fillArrayBut) {
            int size = Integer.parseInt(sizeField.getText());
            int max = Integer.parseInt(maxField.getText());
            textarea.appendText(Arrays.toString(facade.fillArray(size, max)) + "\n");
        } else if (event.getSource() == fillUniqueArrayBut) {
            int size = Integer.parseInt(sizeField.getText());
            int max = Integer.parseInt(maxField.getText());
            textarea.appendText(Arrays.toString(facade.fillUniqueArray(size, max)) + "\n");
        } else if (event.getSource() == divisorBut) {
            int divisor = Integer.parseInt(divisorField.getText());
            textarea.appendText("Divisor " + divisor + " gives sum " + facade.sumOfDivisors(divisor) + "\n");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
