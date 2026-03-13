package org.zeki.employeecontrol.model;

import org.zeki.employeecontrol.controller.app.AppController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                // DNI FOUND
                if (!user.getPass().equals(pass)) {
                    //WRONG PASS
                    results.put(false, "Contraseña incorrecta");
                    return results;
                }
                //SET CURRENT USER
                AppController.getInstance().setCurrentUser(user);
                results.put(true, "Login correcto");
                return results;
            }
        }
        // DNI NOT FOUND
        results.put(false, "Dni no registrado");
        return results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
