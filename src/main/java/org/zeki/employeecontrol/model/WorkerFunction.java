package org.zeki.employeecontrol.model;

import javafx.scene.control.Label;

public interface WorkerFunction {
    void clockIn(Label label);
    void clockOut(Label label);
}
