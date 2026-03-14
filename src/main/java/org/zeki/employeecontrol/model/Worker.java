package org.zeki.employeecontrol.model;

import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.controller.file.FileTimeController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Worker extends User implements WorkerFunction {

    private final long SERIAL_VERSION_UID = 1L;

    @Override
    public void clockIn(Label label) {
        String[] userData = prepareWorkerData();
        userData[3] = "ENTRADA";

        FileTimeController fileTimeController = new FileTimeController();
        fileTimeController.saveFile(userData, label);
    }

    @Override
    public void clockOut(Label label) {
        String[] userData = prepareWorkerData();
        userData[3] = "SALIDA";

        FileTimeController fileTimeController = new FileTimeController();
        fileTimeController.saveFile(userData, label);
    }

    private String[] prepareWorkerData() {
        // GET CURRENT USER
        Worker currentWorker = (Worker) AppController.getInstance().getCurrentUser();
        // PREPARE DATA
        String dateTime = getCurrentFormattedTime();
        String[] workerData = new String[4];
        workerData[0] = currentWorker.getDni();
        workerData[1] = currentWorker.getEmail();
        workerData[2] = dateTime;
        return workerData;
    }

    private String getCurrentFormattedTime() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        return now.format(format);

    }
}
