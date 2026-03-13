package org.zeki.employeecontrol.model;

import javafx.scene.control.Label;

import java.util.Map;

public interface AdminFunction {
    void createNewUser(Map<String, String> userData, Enum<UserType> userType, Label label);

    void removeUser(String dni, Label label);

    User searchUser(String id,Label label);

    void showAllUsers();

    void changeUserPass();

    void showControlTimeUsers();
}
