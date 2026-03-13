package org.zeki.employeecontrol.controller.file;

import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.User;

import java.io.*;

public final class FileUsersController extends FileController {

    public FileUsersController() {
        file = new File(AppController.getInstance().getPath().getUSERS_FILE());
        usersList = AppController.getInstance().getUsersList();
    }

    @Override
    public void loadFile() {
        if (!file.exists()) {
            feedbackMessage = ("Error al leer fichero");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                usersList.add((User) ois.readObject());
            }
        } catch (ClassNotFoundException e) {
            feedbackMessage = ("Error al obtener los usuarios");
            System.err.println("ERROR:" + e.getMessage());

        } catch (IOException e) {
            feedbackMessage = "Error de lectura global";
            System.err.println("ERROR:" + e.getMessage());
        }
        feedbackMessage = "Usuarios cargados correctamente";
    }

    @Override
    public void saveFile() {
        try (ObjectOutputStream bos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (User user : usersList) {
                bos.writeObject(user);
            }
        } catch (IOException e) {
            feedbackMessage = "Error al guardar usuario";
            System.err.println("ERROR:" + e.getMessage());

        }
        feedbackMessage = "Usuario guardado correctamente";
    }
}


