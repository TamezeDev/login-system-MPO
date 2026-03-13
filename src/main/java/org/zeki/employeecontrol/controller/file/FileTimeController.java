package org.zeki.employeecontrol.controller.file;

import org.zeki.employeecontrol.controller.app.AppController;

import java.io.*;

public final class FileTimeController extends FileController {

    public FileTimeController() {
        file = new File(AppController.getInstance().getPath().getTIME_CONTROL_FILE());
        timerList = AppController.getInstance().getUsersCheckTime();
    }

    @Override
    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] filterLine = line.split(";");
                timerList.add(filterLine);
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR:" + e.getMessage());
            feedbackMessage = "Error de acceso al fichero";
        } catch (IOException e) {
            System.err.println("ERROR:" + e.getMessage());
            feedbackMessage = "Error en la carga de datos";
        }
    }

    public void saveFile(String[] userTime) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
            if (userTime != null && userTime.length != 0) {
                String timerPrepared = String.join(";", userTime);
                pw.print(timerPrepared);
            }
        } catch (IOException e) {
            feedbackMessage = "Error guardando la fichada";
            System.err.println("ERROR:" + e.getMessage());
        }
        feedbackMessage = "Fichada con éxito";
    }

    @Override
    protected void saveFile() {

    }

}
