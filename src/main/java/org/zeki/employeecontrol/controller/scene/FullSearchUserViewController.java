package org.zeki.employeecontrol.controller.scene;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class FullSearchUserViewController implements Initializable {

    @FXML
    private Label userNameLabel;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button goBackBtn;

    @FXML
    private TableColumn<User, String> dniColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableView<User> usersTable;


    @FXML
    private Button searchBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AppController.getInstance().getCurrentUser().loadCurrentUserData(userNameLabel);
        initListeners();
    }

    private void initListeners() {
        //GO TO ADMIN SCENE
        goBackBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getADMIN_SCENE()));
        // SEARCH ALL INFO USERS
        searchBtn.setOnAction((ActionEvent event) -> getAllUsers());
    }

    private void getAllUsers() {
        // GET USERS
        Admin currentAdmin = (Admin) AppController.getInstance().getCurrentUser();
        ObservableList<User> userListTable = currentAdmin.showAllUsers();
        // SET COLUMNS
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        dniColumn.setCellValueFactory(new PropertyValueFactory<>("dni"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        usersTable.setItems(userListTable);
    }
}
