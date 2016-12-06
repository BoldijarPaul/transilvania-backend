package com.transilvania.app.repository;

import com.transilvania.app.models.User;
import com.transilvania.app.utils.CacheArrayList;
import com.transilvania.app.utils.RUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 12/6/2016.
 */
public class UsersRepository {
    private List<User> users = new CacheArrayList<User>("users");

    public boolean addUser(String name, String password, String phone) {
        for (User user : users) {
            if (user.name.toUpperCase().equals(name.toUpperCase())) {
                return false;
            }
        }
        users.add(new User(name, password, phone, RUtils.randomId()));
        return true;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>(this.users);
        for (User user : users) {
            user.password = null;
        }
        return users;
    }

    public List<User> getFullUsers(){
        return users;
    }
}
