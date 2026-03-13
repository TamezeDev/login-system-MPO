package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.controller.file.FileUsersController;
import org.zeki.employeecontrol.util.FormularyHelper;

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
    private PasswordField passField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserFile(); // LOAD USER LIST
        initListeners(); // INIT LISTENERS
    }

    private void initListeners() {
        // BTN LOGIN
        loginBtn.setOnAction((ActionEvent event) -> {
            if (!FormularyHelper.checkEmpty(groupTextFields(), feedBackLabel)) {
                AppController.getInstance().loginControl(dniField.getText(), passField.getText(), feedBackLabel);
            }
        });
        //BTN CLEAN
        clearBtn.setOnAction((ActionEvent event) -> FormularyHelper.cleanFields(groupTextFields()));
    }

    private TextField[] groupTextFields() {
        TextField[] textFields = new TextField[2];
        textFields[0] = dniField;
        textFields[1] = passField;
        return textFields;
    }

    private void loadUserFile() {
        if (AppController.getInstance().getUsersList().isEmpty()) {
            FileUsersController fileUsersController = new FileUsersController();
            fileUsersController.loadFile(feedBackLabel);
        }
    }
}

