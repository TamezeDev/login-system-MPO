package org.zeki.employeecontrol.controller.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlTimeViewController implements Initializable {

    @FXML
    private TableColumn<?, ?> dniColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private TableColumn<?, ?> inputColumn;

    @FXML
    private TableColumn<?, ?> outputColumn;

    @FXML
    private Button showBtn;

    @FXML
    private TableView<?> timeControlTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
