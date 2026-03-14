package org.zeki.employeecontrol.util;

import lombok.Getter;

@Getter
public class PathHelper {
    // FXML
    private final String LOGIN_SCENE = "/fxml/login-view.fxml";
    private final String ADMIN_SCENE = "/fxml/admin-view.fxml";
    private final String EMPLOYEE_SCENE = "/fxml/workers-view.fxml";
    private final String NEW_EMPLOYEE_SCENE = "/fxml/newUser-view.fxml";
    private final String REMOVE_EMPLOYEE_SCENE = "/fxml/removeUser-view.fxml";
    private final String PASS_CHANGE_SCENE = "/fxml/passChange-view.fxml";
    private final String SINGLE_USER_INFO_SCENE = "/fxml/searchUser-view.fxml";
    private final String FULL_EMPLOYEE_SCENE = "/fxml/fullSearchUser-view.fxml";
    private final String CONTROL_TIME_SCENE = "/fxml/controlTime-view.fxml";
    // FILES
    private final String USERS_FILE = "src/main/resources/file/users.bin";
    private final String TIME_CONTROL_FILE = "src/main/resources/file/time_control.csv";
    //IMG
    private static final String MAIN_ICON = "/img/main_icon.png";

    public static String getMainIcon(){
        return MAIN_ICON;
    }
}
