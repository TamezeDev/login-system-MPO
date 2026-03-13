package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {

    @FXML
    private Button checkTimersBtn;

    @FXML
    private Button listUserBtn;

    @FXML
    private Button modifyUserBtn;

    @FXML
    private Button removeUserBtn;

    @FXML
    private Button searchUserBtn;

    @FXML
    private Button closeSessionBtn;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    private Button newUserBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCurrentUserData();
        initListeners();
    }

    private void initListeners() {
        // GO TO USER SCENE
        newUserBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getNEW_EMPLOYEE_SCENE());
        });
        // GO TO REMOVE USER SCENE
        removeUserBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getREMOVE_EMPLOYEE_SCENE());
        });
        // GO TO SEARCH USER SCENE
        searchUserBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getSINGLE_USER_INFO_SCENE());
        });
        // GO TO MODIFY PASS USER SCENE
        modifyUserBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getPASS_CHANGE_SCENE());
        });
        // GO TO USER LIST SCENE
        listUserBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getFULL_EMPLOYEE_SCENE());
        });
        // GO TO CHECK TIME USERS SCENE
        checkTimersBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getCONTROL_TIME_SCENE());
        });
        // GO BACK LOGIN SCENE
        closeSessionBtn.setOnAction((ActionEvent event) -> {
            SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getLOGIN_SCENE());
        });

    }

    private void loadCurrentUserData() {
        String name = AppController.getInstance().getCurrentUser().getName();
        String lastName = AppController.getInstance().getCurrentUser().getLastName();
        userNameLabel.setText("Bienvenid@: " + name + " " + lastName);
    }
}
