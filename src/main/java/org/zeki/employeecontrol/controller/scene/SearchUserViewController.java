package org.zeki.employeecontrol.controller.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchUserViewController implements Initializable {
    @FXML
    private VBox UserDataBox;

    @FXML
    private Button clearBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField dniField;

    @FXML
    private Label dniLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label nameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
