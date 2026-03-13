package org.zeki.employeecontrol.model;

import javafx.scene.control.TextField;

import java.util.Map;

public interface Login {
    Map<Boolean, String> login(String id, String pass);
}
