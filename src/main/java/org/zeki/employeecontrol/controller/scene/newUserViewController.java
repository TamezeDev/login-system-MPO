package org.zeki.employeecontrol.controller.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class newUserViewController implements Initializable {

    @FXML
    private ComboBox<String> userTypeCombo;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField dniField;

    @FXML
    private TextField emailField;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button registerBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
