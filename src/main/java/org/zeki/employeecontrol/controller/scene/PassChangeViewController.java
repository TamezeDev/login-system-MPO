package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.util.FormularyHelper;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class PassChangeViewController implements Initializable {

    @FXML
    private Button clearBtn;

    @FXML
    private Button confirmPassBtn;

    @FXML
    private TextField dniField;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField repeatPassField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initListeners();
    }

    private void initListeners() {
        // CLEAR FIELDS
        clearBtn.setOnAction((ActionEvent event) -> FormularyHelper.cleanFields(groupFields()));
        // GO TO ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // CHANGE PASS
        confirmPassBtn.setOnAction((ActionEvent event) -> changePass());
    }

    private TextField[] groupFields() {
        TextField[] fields = new TextField[3];
        fields[0] = dniField;
        fields[1] = passField;
        fields[2] = repeatPassField;
        return fields;
    }

    private void changePass() {
        if (FormularyHelper.checkEmpty(groupFields(), feedBackLabel) || !FormularyHelper.checkSameFieldContent(passField, repeatPassField, feedBackLabel))
            return;
        Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
        currentAdmin.changeUserPass(dniField.getText(), passField.getText(), feedBackLabel);
    }
}
