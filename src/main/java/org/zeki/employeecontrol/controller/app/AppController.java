package org.zeki.employeecontrol.controller.app;

import javafx.scene.Node;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;
import org.zeki.employeecontrol.model.user.Admin;
import org.zeki.employeecontrol.model.user.User;
import org.zeki.employeecontrol.model.user.Worker;
import org.zeki.employeecontrol.util.PathHelper;
import org.zeki.employeecontrol.util.SceneHelper;
import org.zeki.employeecontrol.util.TransitionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AppController {

    private static AppController instance;
    private boolean startedApp;
    private final PathHelper pathHelper;
    private final TransitionHelper transitionHelper;

    private List<User> usersList;
    private List<String[]> usersCheckTime;

    private User currentUser;

    private AppController() {
        // INIT COMPONENTS
        pathHelper = new PathHelper();
        usersList = new ArrayList<>();
        usersCheckTime = new ArrayList<>();
        transitionHelper = new TransitionHelper();
    }

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public void loginControl(String dni, String pass, Node anyNode) {
        Label nodeLabel = (Label) anyNode;
        User user = new User();
        Map<Boolean, String> result = user.login(dni, pass);
        // SHOW FEEDBACK
        if (result.containsKey(false)) {
            nodeLabel.setText(result.get(false));
            transitionHelper.feedBackTransition(nodeLabel);
            return;
        }
        // SET NEW SCENE
        if (currentUser instanceof Admin) {
            SceneHelper.changeScene(anyNode, pathHelper.getADMIN_SCENE());
        } else if (currentUser instanceof Worker) {
            SceneHelper.changeScene(anyNode, pathHelper.getEMPLOYEE_SCENE());
        }
    }

    public boolean checkExistsDni(String dni) {
        return usersList.stream().anyMatch(user -> user.getDni().equalsIgnoreCase(dni));
    }

    public boolean checkExistsEmail(String email) {
        return usersList.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    public User getUserByID(String dni) {
        return usersList.stream().filter(user -> user.getDni().equalsIgnoreCase(dni)).findFirst().get();
    }

    // DEFAULT ADMIN FOR INIT APP FIRST TIME  (9999 / admin)
    public void createMainAdmin() {
        User mainAdmin = new Admin();
        mainAdmin.setName("main");
        mainAdmin.setLastName("admin");
        mainAdmin.setDni("9999");
        mainAdmin.setEmail("mainAdmin@admins.com");
        mainAdmin.setPass("admin");
        usersList.add(mainAdmin);
    }


}
