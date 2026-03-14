package org.zeki.employeecontrol.controller.scene;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.user.Admin;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlTimeViewController implements Initializable {

    @FXML
    private TableColumn<String[], String> dniColumn;

    @FXML
    private TableColumn<String[], String> emailColumn;

    @FXML
    private TableColumn<String[], String> dateHourColumn;

    @FXML
    private TableColumn<String[], String> typeColumn;
    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button showBtn;

    @FXML
    private TableView<String[]> timeControlTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initListeners();
    }

    private void initListeners() {
        // GO TO ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // SHOW USERS CLOCKS
        showBtn.setOnAction((ActionEvent event) -> showUsersClocks());
    }

    private void showUsersClocks() {
        Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
        ObservableList<String[]> usersClocks = currentAdmin.showControlTimeUsers(feedBackLabel);

        dniColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue()[0]));
        emailColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue()[1]));
        dateHourColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue()[2]));
        typeColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue()[3]));

        timeControlTable.setItems(usersClocks);
    }
}
