package org.zeki.employeecontrol.controller.scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.zeki.employeecontrol.util.PathHelper;

import java.io.IOException;
import java.util.Objects;

public class InitAppController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginViewController.class.getResource("/fxml/login-view.fxml"));
        Image mainIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PathHelper.getMainIcon())));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

        stage.getIcons().add(mainIcon);
        stage.setTitle("Employee control");
        stage.setScene(scene);
        stage.show();
    }
}
