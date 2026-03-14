package org.zeki.employeecontrol.controller.file;

import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;

import java.io.*;


public final class FileTimeController extends FileController {

    public FileTimeController() {
        file = new File(AppController.getInstance().getPathHelper().getTIME_CONTROL_FILE());
        timerList = AppController.getInstance().getUsersCheckTime();
    }

    @Override
    public void loadFile(Label label) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] filterLine = line.split(";");
                timerList.add(filterLine);
            }
            return;
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
            label.setText("Error de acceso al fichero");

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            label.setText("Error en la carga de datos");
        }
        AppController.getInstance().getTransitionHelper().feedBackTransition(label);
    }

    public void saveFile(String[] userTime, Label label) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            if (userTime != null && userTime.length != 0) {
                String timerPrepared = String.join(";", userTime);
                pw.println(timerPrepared);
            }
        } catch (IOException e) {
            label.setText("Error guardando la fichada");
            System.err.println("ERROR:" + e.getMessage());
        }
        label.setText("Fichada con éxito");
        AppController.getInstance().getTransitionHelper().feedBackTransition(label);
    }

}
