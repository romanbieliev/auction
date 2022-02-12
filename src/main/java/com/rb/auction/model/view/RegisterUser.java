package com.rb.estore.model.view;

import com.rb.estore.model.User;

public class RegisterUser extends User implements Cloneable {
    private String passwordRepeat;

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    @Override
    public RegisterUser clone() {
        try {
            RegisterUser clone = (RegisterUser) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public User parentClone() {
        // try {
            User user = new User();
            user.setPassword(this.getPassword());
            user.setLogin(this.getLogin());
            user.setId(this.getId());
            user.setName(this.getName());
            user.setSurname(this.getSurname());
            return user;
        // } catch (CloneNotSupportedException e) {
            // e.printStackTrace();
        // }

        // return null;
    }
}
