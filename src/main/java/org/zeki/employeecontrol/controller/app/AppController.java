package org.zeki.employeecontrol.controller.app;

import lombok.Getter;
import lombok.Setter;
import org.zeki.employeecontrol.model.Admin;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.model.Worker;
import org.zeki.employeecontrol.util.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AppController {

    private static AppController instance;
    private final Path path;

    private List<User> usersList;
    private List<String[]> usersCheckTime;
    private String feedBackMessage;

    private User currentUser;

    private AppController() {
        path = new Path();
        usersList = new ArrayList<>();
        usersCheckTime = new ArrayList<>();
    }

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public void loginControl(String dni, String pass) {
        User user = new User();
        Map<Boolean, String> result = user.login(dni, pass);
        if (result.containsKey(false)) {
            feedBackMessage = result.get(false);
        } else if (result.containsKey(true)) {
            if (currentUser instanceof Admin) {
                //TODO: SET ADMIN PANE
            } else if (currentUser instanceof Worker) {
                // TODO:SET WORKER PANE
            }
        }
    }


}
