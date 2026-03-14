package org.zeki.employeecontrol.model.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import org.zeki.employeecontrol.controller.app.AppController;
import org.zeki.employeecontrol.controller.file.FileTimeController;
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
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
            return;
        }
        if (emailExists(userData.get("email"), label)) return;

        //CONFIG USER TYPE AND SET ATTRIBUTES
        User user = configNewUserType(userData, userType, label);

        // ADD TO LIST AND SAVE
        AppController.getInstance().getUsersList().add(user);
        label.setText("Registro correcto");
        FileUsersController fileUsersController = new FileUsersController();
        fileUsersController.saveFile(label);
        AppController.getInstance().getTransitionHelper().feedBackTransition(label);
    }

    @Override
    public void removeUser(String dni, Label label) {
        if (dniExists(dni, label)) {
            if (AppController.getInstance().getCurrentUser().getDni().equals(dni)) {
                label.setText("No es posible autoborrarse");
                AppController.getInstance().getTransitionHelper().feedBackTransition(label);
                return;
            }
            // GET USER AND DELETE
            User userFounded = AppController.getInstance().getUserByID(dni);
            AppController.getInstance().getUsersList().remove(userFounded);
            //SAVE AND SEND FEEDBACK
            FileUsersController fileUsersController = new FileUsersController();
            fileUsersController.saveFile(label);
            label.setText("Borrado con éxito");
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
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
    public ObservableList<User> showAllUsers() {
        return FXCollections.observableArrayList(AppController.getInstance().getUsersList());
    }

    @Override
    public void changeUserPass(String dni, String pass, Label label) {
        if (dniExists(dni, label)) {
            User selectedUser = AppController.getInstance().getUserByID(dni);
            selectedUser.setPass(pass);
            label.setText("Contraseña cambiada");
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
        }
    }

    @Override
    public ObservableList<String[]> showControlTimeUsers(Label label) {
        FileTimeController fileTimeController = new FileTimeController();
        fileTimeController.loadFile(label);
        return FXCollections.observableArrayList(AppController.getInstance().getUsersCheckTime());
    }

    private boolean dniExists(String dni, Label label) {
        // CHECK IF EXISTS
        boolean existsUser = AppController.getInstance().checkExistsDni(dni);
        if (!existsUser) {
            label.setText("Dni no encontrado");
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
            return false;
        }
        return true;
    }

    private boolean emailExists(String email, Label label) {
        boolean emailExists = AppController.getInstance().checkExistsEmail(email);
        if (emailExists) {
            label.setText("Email no disponible");
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
            return true;
        }
        return false;
    }

    private User configNewUserType(Map<String, String> userData, Enum<UserType> userType, Label label) {
        // CHOICE NEW USER TYPE
        UserFactory factory = new UserFactory();
        User user = null;
        switch (userType) {
            case UserType.ADMINISTRADOR -> user = factory.createAdmin();
            case UserType.TRABAJADOR -> user = factory.createWorker();
            default -> {
                label.setText("Error creando usuario");
                AppController.getInstance().getTransitionHelper().feedBackTransition(label);
                return user;
            }
        }
        user.setName(userData.get("name"));
        user.setLastName(userData.get("lastName"));
        user.setDni(userData.get("dni"));
        user.setEmail(userData.get("email"));
        user.setPass(userData.get("pass"));
        return user;
    }

}
