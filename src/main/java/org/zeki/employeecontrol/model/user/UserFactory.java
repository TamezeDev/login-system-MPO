package org.zeki.employeecontrol.model.user;

public final class UserFactory implements UserCreator {

    @Override
    public Admin createAdmin() {
        return new Admin();
    }

    @Override
    public User createWorker() {
        return new Worker();
    }
}
