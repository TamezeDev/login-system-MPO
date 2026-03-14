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
        if (dniRepeat) {
            label.setText("Dni no disponible");
            AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
            return;
        }
        if (emailExists(userData.get("email"), label)) return;
        // CHOICE NEW USER TYPE
        User user = null;
        if (userType.equals(UserType.ADMINISTRADOR)) {
            user = new Admin();
        }
        if (userType.equals(UserType.TRABAJADOR)) {
            user = new Worker();
        }
        user.setName(userData.get("name"));
        user.setLastName(userData.get("lastName"));
        user.setDni(userData.get("dni"));
        user.setEmail(userData.get("email"));
        user.setPass(userData.get("pass"));
        // ADD TO LIST AND SAVE
        AppController.getInstance().getUsersList().add(user);
        label.setText("Registro correcto");
        FileUsersController fileUsersController = new FileUsersController();
        fileUsersController.saveFile(label);
        AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
    }

    @Override
    public void removeUser(String dni, Label label) {
        if (dniExists(dni, label)) {
            // GET USER AND DELETE
            User userFounded = AppController.getInstance().getUserByID(dni);
            AppController.getInstance().getUsersList().remove(userFounded);
            //SAVE AND SEND FEEDBACK
            FileUsersController fileUsersController = new FileUsersController();
            fileUsersController.saveFile(label);
            label.setText("Borrado con éxito");
            AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
        }
    }

    @Override
    public User searchUser(String dni, Label label) {
        if (dniExists(dni, label)) {
            // GET USER
            User userFounded = AppController.getInstance().getUserByID(dni);
            return userFounded;
        }
        return null;
    }

    @Override
    public void showAllUsers() {

    }

    @Override
    public void changeUserPass(String dni, String pass, Label label) {
        if (dniExists(dni, label)) {
            User selectedUser = AppController.getInstance().getUserByID(dni);
            selectedUser.setPass(pass);
            label.setText("Contraseña cambiada");
            AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
        }
    }

    @Override
    public void showControlTimeUsers() {

    }

    private boolean dniExists(String dni, Label label) {
        // CHECK IF EXISTS
        boolean existsUser = AppController.getInstance().checkExistsDni(dni);
        if (!existsUser) {
            label.setText("Dni no encontrado");
            AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
            return false;
        }
        return true;
    }

    private boolean emailExists(String email, Label label) {
        boolean emailExists = AppController.getInstance().checkExistsEmail(email);
        if (emailExists) {
            label.setText("Email no disponible");
            AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
            return true;
        }
        return false;
    }
}
