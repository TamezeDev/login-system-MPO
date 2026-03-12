package org.zeki.employeecontrol.controller.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class FullSearchUserViewController implements Initializable {

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private TableColumn<?, ?> dniColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button searchBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
