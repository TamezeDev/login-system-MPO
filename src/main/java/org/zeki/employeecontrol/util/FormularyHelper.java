package org.zeki.employeecontrol.util;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.zeki.employeecontrol.controller.app.AppController;


public class FormularyHelper {

    public static boolean checkEmpty(TextField[] textFields, Label label) {
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                label.setText("Hay campos vacíos");
                AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
                return true;
            }
        }
        return false;
    }

    public static void cleanFields(TextField[] textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

    public static void cleanLabels(Label[] labels) {
        for (Label label : labels) {
            label.setText("");
        }
    }

    public static boolean checkSameFieldContent(TextField fieldA, TextField fieldB, Label label) {
        if (fieldA.getText().equals(fieldB.getText())) return true;
        label.setText("Los campos no coinciden");
        AppController.getInstance().getTransitionHelper().hideFeedBackLabel(label);
        return false;
    }

}
