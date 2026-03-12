package org.zeki.employeecontrol.controller.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveUserController implements Initializable {

    @FXML
    private Button clearBtn;

    @FXML
    private Button deleteUserBtn;

    @FXML
    private TextField dniField;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
