package org.zeki.employeecontrol.controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Worker;
import org.zeki.employeecontrol.util.SceneHelper;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkersViewController implements Initializable {

    @FXML
    private Button userOutputBtn;

    @FXML
    private Button closeSessionBtn;

    @FXML
    private Label feedBackLabel;

    @FXML
    private Button userInputBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initListeners();
    }

    private void initListeners() {
        // SAVE CLOCK IN WORKER
        userInputBtn.setOnAction((ActionEvent event) -> {
            Worker currentWorker = (Worker) AppController.getInstance().getCurrentUser();
            currentWorker.clockIn(feedBackLabel);
        });
        //SAVE CLOCK OUT WORKER
        userOutputBtn.setOnAction((ActionEvent event) -> {
            Worker currentWorker = (Worker) AppController.getInstance().getCurrentUser();
            currentWorker.clockOut(feedBackLabel);
        });
        // GO TO LOG IN SCENE
        closeSessionBtn.setOnAction((ActionEvent event) -> SceneHelper.changeScene(feedBackLabel, AppController.getInstance().getPathHelper().getLOGIN_SCENE()));
    }


}
