package org.zeki.employeecontrol.model;

import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zeki.employeecontrol.controller.app.AppController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Login, Serializable {
    protected String name;
    protected String lastName;
    protected String dni;
    protected String email;
    protected String pass;


    @Override
    public Map<Boolean, String> login(String id, String pass) {
        Map<Boolean, String> results = new HashMap<>();
        List<User> userList = AppController.getInstance().getUsersList();
        for (User user : userList) {
            if (user.getDni().equals(id)) {
                if (!user.getPass().equals(pass)) {
                    results.put(false, "Contraseña incorrecta");
                    return results;
                }
                AppController.getInstance().setCurrentUser(user);
                results.put(true, "Login correcto");
                return results;
            }
        }
        results.put(false, "Dni no registrado");
        return results;
    }
}
