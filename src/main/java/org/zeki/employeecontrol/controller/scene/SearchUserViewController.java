package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.util.FormularyHelper;
import org.zeki.employeecontrol.util.SceneHelper;

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
        initListeners();
    }

    private void initListeners() {
        // CLEAR FIELDS
        clearBtn.setOnAction((ActionEvent event) -> {
            FormularyHelper.cleanLabels(groupLabels());
            UserDataBox.setVisible(false);
        });
        // GO TO ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // SEARCH USER
        searchBtn.setOnAction((ActionEvent event) -> searchUser());
    }

    private Label[] groupLabels() {
        // GROUP ALL FIELDS
        Label[] textFields = new Label[4];
        textFields[0] = nameLabel;
        textFields[1] = lastNameLabel;
        textFields[2] = dniLabel;
        textFields[3] = emailLabel;
        return textFields;
    }

    private TextField[] groupFields() {
        TextField[] fields = new TextField[1];
        fields[0] = dniField;
        return fields;
    }

    private void searchUser() {
        if (FormularyHelper.checkEmpty(groupFields(), feedBackLabel)) {
            return;
        }
        Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
        User user = currentAdmin.searchUser(dniField.getText(), feedBackLabel);
        if (user != null){
            nameLabel.setText(user.getName());
            lastNameLabel.setText(user.getLastName());
            emailLabel.setText(user.getEmail());
            dniLabel.setText(user.getDni());
            UserDataBox.setVisible(true);
        }
    }

}
