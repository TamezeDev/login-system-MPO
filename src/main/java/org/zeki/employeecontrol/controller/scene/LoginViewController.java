package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.util.FieldHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    @FXML
    private Button clearBtn;

    @FXML
    private TextField dniField;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField passField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initListeners();
    }

    private void initListeners() {
        loginBtn.setOnAction((ActionEvent event) -> {
            if (FieldHelper.checkEmpty(groupTextFields())) {
                feedBackLabel.setText("Hay campos vacíos");
                return;
            }

        });

        clearBtn.setOnAction((ActionEvent event) -> FieldHelper.checkEmpty(groupTextFields()));
    }

    private TextField[] groupTextFields() {
        TextField[] textFields = new TextField[2];
        textFields[0] = dniField;
        textFields[1] = passField;
        return textFields;
    }


}

