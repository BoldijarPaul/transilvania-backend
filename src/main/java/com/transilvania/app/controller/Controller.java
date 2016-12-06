package com.transilvania.app.controller;

import com.transilvania.app.models.AddAppointmentResponse;
import com.transilvania.app.models.Appointment;
import com.transilvania.app.models.User;
import com.transilvania.app.repository.AppointmentRepository;
import com.transilvania.app.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 12/6/2016.
 */
public class Controller {

    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private UsersRepository usersRepository = new UsersRepository();
    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public List<User> getFullUsers() {
        return usersRepository.getFullUsers();
    }

    public User getUser(String name, String password) {
        List<User> users = getFullUsers();
        for (User user : users) {
            if (user.name.toUpperCase().equals(name.toUpperCase()) &&
                    user.password.toUpperCase().equals(password.toUpperCase())) {
                return user;
            }
        }
        return null;
    }

    public AddAppointmentResponse addAddapointment(int day, int month, int year, int hour, String name, String password) {
        return appointmentRepository.addAppointment(day, month, year, hour, name, password);
    }

    public List<Appointment> getAppointments() {
        return appointmentRepository.getAppointments();
    }

    public boolean addUser(String name, String password, String phone) {
        return usersRepository.addUser(name, password, phone);
    }

    public List<User> getUsers() {
        return usersRepository.getAllUsers();
    }

    public List<User> getUsersByName(String name) {
        List<User> users = usersRepository.getAllUsers();
        List<User> returnedUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.name.toUpperCase().contains(name.toUpperCase())) {
                returnedUsers.add(user);
            }
        }
        return returnedUsers;
    }

    public User getUserById(long userId) {
        List<User> users = usersRepository.getAllUsers();
        for (User user : users) {
            if (userId == user.id) {
                return user;
            }
        }
        return null;
    }
}
