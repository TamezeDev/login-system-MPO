package org.zeki.employeecontrol.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.zeki.employeecontrol.controller.app.AppController;

import java.io.IOException;

public class SceneHelper {

    public static void changeScene(Node node, String pathFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneHelper.class.getResource(pathFxml));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) (node.getScene().getWindow());
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            Label label = (Label) node;
            label.setText("Error al cargar scene");
            AppController.getInstance().getTransitionHelper().feedBackTransition(label);
            System.err.println("Error al capturar algún atributo de nodo");
            e.getMessage();
        }
    }
}
