package org.zeki.employeecontrol.model;

import javafx.scene.control.Label;

import java.util.Map;

public interface AdminFunction {
    void createNewUser(Map<String, String> userData, Enum<UserType> userType, Label label);

    void removeUser();

    void searchUser(String id);

    void showAllUsers();

    void changeUserPass();

    void showControlTimeUsers();
}
