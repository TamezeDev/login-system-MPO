package org.zeki.employeecontrol.model.user;

import java.util.Map;

public interface Login {
    Map<Boolean, String> login(String id, String pass);
}
