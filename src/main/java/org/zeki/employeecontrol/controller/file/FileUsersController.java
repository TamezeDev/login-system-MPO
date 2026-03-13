package org.zeki.employeecontrol.controller.file;

import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.model.Worker;

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
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Object object = ois.readObject();
                    if (object instanceof Admin) {
                        usersList.add((Admin) object);
                    } else if (object instanceof Worker) {
                        usersList.add((Worker) object);
                    }

                } catch (EOFException e) {
                    feedbackMessage = "Usuarios cargados correctamente";
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            feedbackMessage = ("Error al obtener los usuarios");
            System.err.println("ERROR: " + e.getMessage());

        } catch (IOException e) {
            feedbackMessage = "Error de lectura global";
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void saveFile() {
        try (ObjectOutputStream bos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (User user : usersList) {
                bos.writeObject(user);
            }
            feedbackMessage = "Usuario guardado correctamente";
        } catch (IOException e) {
            feedbackMessage = "Error al guardar usuario";
            System.err.println("ERROR:" + e.getMessage());
        }
    }

}
