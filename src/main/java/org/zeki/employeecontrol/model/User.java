package org.zeki.employeecontrol.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Login, Serializable {
    protected final long SERIAL_VERSION_UID = 1L;
    protected String name;
    protected String lastName;
    protected String dni;
    protected String email;
    protected String pass;


    @Override
    public void login() {

    }
}
