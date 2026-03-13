package org.zeki.employeecontrol.util;

import javafx.scene.control.TextField;

public class FieldHelper {
    public static boolean checkEmpty(TextField[] textFields){
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) return true;
        }
        return false;
    }
    public static boolean cleanFields(TextField[] textFields){
        for (TextField textField : textFields) {
           textField.clear();
        }
        return false;
    }
}
