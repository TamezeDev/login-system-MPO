package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.model.UserType;
import org.zeki.employeecontrol.util.FormularyHelper;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
        setTypeCombo();
        initListeners();
    }

    private void initListeners() {
        // REGISTER NEW USER
        registerBtn.setOnAction((ActionEvent event) -> registerUser());
        // GO BACK ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // CLEAR FIELDS
        clearBtn.setOnAction((ActionEvent event) -> FormularyHelper.cleanFields(groupFields()));
    }

    private void registerUser() {

        if (!FormularyHelper.checkEmpty(groupFields(), feedBackLabel)) {

            Map<String, String> userData = new HashMap<>();
            // GET SELECTED TYPE NEW USER
            Enum<UserType> userType = getUserType();
            //GET USER DATA
            userData.put("name", nameField.getText());
            userData.put("lastName", lastNameField.getText());
            userData.put("dni", dniField.getText());
            userData.put("email", emailField.getText());
            userData.put("pass", passField.getText());
            // CREATE USER
            Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
            currentAdmin.createNewUser(userData, userType, feedBackLabel);
        }

    }

    private void setTypeCombo() {
        userTypeCombo.getItems().add("Trabajador");
        userTypeCombo.getItems().add("Administrador");
        userTypeCombo.getSelectionModel().select(0);
    }

    private Enum<UserType> getUserType() {
        Enum<UserType> userType = null;
        if (userTypeCombo.getSelectionModel().getSelectedItem().equals("Trabajador")) {
            userType = UserType.TRABAJADOR;
        } else if (userTypeCombo.getSelectionModel().getSelectedItem().equals("Administrador")) {
            userType = UserType.ADMINISTRADOR;
        }
        return userType;
    }

    private TextField[] groupFields() {
        // GROUP ALL FIELDS
        TextField[] textFields = new TextField[5];
        textFields[0] = nameField;
        textFields[1] = lastNameField;
        textFields[2] = dniField;
        textFields[3] = emailField;
        textFields[4] = passField;
        return textFields;
    }
}
