package org.zeki.employeecontrol.controller.app;

import org.zeki.employeecontrol.util.Path;

public class AppController {
    private static AppController instance;
    private Path path;

    private AppController() {
    }

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public void initComponents() {
        path = new Path();
    }
}
