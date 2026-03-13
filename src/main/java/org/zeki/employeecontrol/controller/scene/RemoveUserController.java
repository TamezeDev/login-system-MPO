package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.util.FormularyHelper;
import org.zeki.employeecontrol.util.SceneHelper;

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
        initListeners();
    }

    private void initListeners() {
        // CLEAR FIELDS
        clearBtn.setOnAction((ActionEvent event) -> FormularyHelper.cleanFields(groupFields()));
        // GO TO ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // DELETE USER FROM LIST
        deleteUserBtn.setOnAction((ActionEvent event) -> deleteUser());
    }

    private TextField[] groupFields() {
        TextField[] fields = new TextField[1];
        fields[0] = dniField;
        return fields;
    }

    private void deleteUser() {
        if (FormularyHelper.checkEmpty(groupFields(), feedBackLabel)) {
            return;
        }
        Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
        currentAdmin.removeUser(dniField.getText(), feedBackLabel);
    }
}
