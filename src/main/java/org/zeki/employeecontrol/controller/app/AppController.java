package org.zeki.employeecontrol.controller.app;

import lombok.Getter;
import lombok.Setter;
import org.zeki.employeecontrol.model.User;
import org.zeki.employeecontrol.util.Path;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AppController {

    private static AppController instance;
    private final Path path;

    private List<User> usersList;
    private List<String[]> usersCheckTime;
    private String feedBackMessage;

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


}
