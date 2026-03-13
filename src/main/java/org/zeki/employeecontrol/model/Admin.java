package org.zeki.employeecontrol.model;

import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.controller.file.FileUsersController;

import java.util.Map;

public final class Admin extends User implements AdminFunction {
    private final long SERIAL_VERSION_UID = 1L;

    @Override
    public void createNewUser(Map<String, String> userData, Enum<UserType> userType, Label label) {
        // CHECK AVAILABLE DNI, EMAIL
        boolean dniRepeat = AppController.getInstance().checkExistsDni(userData.get("dni"));
        boolean emailRepeat = AppController.getInstance().checkExistsEmail(userData.get("email"));

        if (dniRepeat) {
            label.setText("Dni no disponible");
            return;
        }
        if (emailRepeat) {
            label.setText("Email no disponible");
            return;
        }
        // CHOICE NEW USER TYPE
        User user = null;
        if (userType.equals(UserType.ADMINISTRADOR)) {
            user = new Admin();
        }
        if (userType.equals(UserType.TRABAJADOR)) {
            user = new Worker();
        }
        name = (userData.get("name"));
        lastName = (userData.get("lastName"));
        dni = (userData.get("dni"));
        email = (userData.get("email"));
        pass = (userData.get("pass"));
        // ADD TO LIST AND SAVE
        AppController.getInstance().getUsersList().add(user);
        label.setText("Registro correcto");
        FileUsersController fileUsersController = new FileUsersController();
        fileUsersController.saveFile(label);
        AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);

    }

    @Override
    public void removeUser() {

    }

    @Override
    public void searchUser(String id) {

    }

    @Override
    public void showAllUsers() {

    }

    @Override
    public void changeUserPass() {

    }

    @Override
    public void showControlTimeUsers() {

    }
}
