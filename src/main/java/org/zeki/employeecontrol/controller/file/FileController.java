package org.zeki.employeecontrol.controller.file;

import javafx.scene.control.Label;
import lombok.Getter;
import org.zeki.employeecontrol.model.user.User;

import java.io.File;
import java.util.List;

@Getter
public abstract class FileController {

    protected File file;
    protected List<String[]> timerList;
    protected List<User> usersList;

    abstract void loadFile(Label label);

}
