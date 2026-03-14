package org.zeki.employeecontrol.controller.file;

import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.model.user.Admin;
import org.zeki.employeecontrol.model.user.User;
import org.zeki.employeecontrol.model.user.Worker;

import java.io.*;

public final class FileUsersController extends FileController {

    public FileUsersController() {
        file = new File(AppController.getInstance().getPathHelper().getUSERS_FILE());
        usersList = AppController.getInstance().getUsersList();
    }

    @Override
    public void loadFile(Label label) {
        // FILE NOT FOUND - CREATE FILE AND GLOBAL ADMIN
        if (!file.exists()) {
            try {
                file.createNewFile();
                AppController.getInstance().createMainAdmin();
                label.setText("Creado admin principal");
                saveFile(label);
                AppController.getInstance().getTransitionHelper().feedBackTransition(label);
                return;
            } catch (IOException e) {
                label.setText("Error al leer fichero");
            }
        }
        // CASTING USER OBJECTS
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
                    label.setText("Usuarios cargados");
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            label.setText("Error al obtener los usuarios");
            System.err.println("ERROR: " + e.getMessage());

        } catch (IOException e) {
            label.setText("Error de lectura global");
            System.err.println("ERROR: " + e.getMessage());
        }
        AppController.getInstance().getTransitionHelper().feedBackTransition(label);
    }

    public void saveFile(Label label) {
        // WRITING USERS FILE
        try (ObjectOutputStream bos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)))) {
            for (User user : usersList) {
                bos.writeObject(user);
            }
            label.setText("Usuario guardado correctamente");
        } catch (IOException e) {
            label.setText("Error al guardar usuario");
            System.err.println("ERROR:" + e.getMessage());
        }
        AppController.getInstance().getTransitionHelper().feedBackTransition(label);
    }

}
