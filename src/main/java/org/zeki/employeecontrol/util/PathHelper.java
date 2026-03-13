package org.zeki.employeecontrol.util;

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

    public String getLOGIN_SCENE() {
        return LOGIN_SCENE;
    }

    public String getADMIN_SCENE() {
        return ADMIN_SCENE;
    }

    public String getEMPLOYEE_SCENE() {
        return EMPLOYEE_SCENE;
    }

    public String getNEW_EMPLOYEE_SCENE() {
        return NEW_EMPLOYEE_SCENE;
    }

    public String getREMOVE_EMPLOYEE_SCENE() {
        return REMOVE_EMPLOYEE_SCENE;
    }

    public String getPASS_CHANGE_SCENE() {
        return PASS_CHANGE_SCENE;
    }

    public String getSINGLE_USER_INFO_SCENE() {
        return SINGLE_USER_INFO_SCENE;
    }

    public String getFULL_EMPLOYEE_SCENE() {
        return FULL_EMPLOYEE_SCENE;
    }

    public String getCONTROL_TIME_SCENE() {
        return CONTROL_TIME_SCENE;
    }

    public String getUSERS_FILE() {
        return USERS_FILE;
    }

    public String getTIME_CONTROL_FILE() {
        return TIME_CONTROL_FILE;
    }
}
