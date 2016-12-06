package com.transilvania.app.models;

/**
 * Created by Paul on 12/6/2016.
 */
public class User {
    public String name;
    public String password;
    public String phone;
    public long id;

    public User(String name, String password, String phone, long id) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.id = id;
    }

    public User() {
    }
}
