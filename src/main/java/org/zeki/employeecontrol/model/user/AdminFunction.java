package org.zeki.employeecontrol.model.user;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.util.Map;

public interface AdminFunction {
    void createNewUser(Map<String, String> userData, Enum<UserType> userType, Label label);

    void removeUser(String dni, Label label);

    User searchUser(String id, Label label);

    ObservableList<User> showAllUsers();

    void changeUserPass(String dni, String pass, Label label);

    ObservableList<String[]> showControlTimeUsers(Label label);
}
