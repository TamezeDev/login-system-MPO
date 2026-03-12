package org.zeki.employeecontrol.model;

public interface AdminFunction {
    void createNewUser();

    void removeUser();

    void searchUser(String id);

    void showAllUsers();

    void changeUserPass();

    void showControlTimeUsers();
}
