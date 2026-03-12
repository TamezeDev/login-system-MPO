package org.zeki.employeecontrol.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User implements Login {
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String pass;


    @Override
    public void login() {

    }
}
