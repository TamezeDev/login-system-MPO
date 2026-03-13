package org.zeki.employeecontrol.controller.file;

import lombok.Getter;
import org.zeki.employeecontrol.model.User;

import java.io.File;
import java.util.List;

@Getter
public abstract class FileController {

    protected File file;
    protected List<String[]> timerList;
    protected List<User> usersList;
    protected String feedbackMessage;

    abstract void loadFile();

    abstract void saveFile();
}
