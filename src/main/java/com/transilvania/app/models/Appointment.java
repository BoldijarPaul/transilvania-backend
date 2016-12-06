package com.transilvania.app.models;

/**
 * Created by Paul on 12/6/2016.
 */
public class Appointment {
    public int day;
    public int month;
    public int year;
    public int hour;
    public long userId;
    public User user;
    public long id;

    public Appointment(int day, int month, int year, int hour, long userId, User user, long id) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.userId = userId;
        this.user = user;
        this.id = id;
    }

    public Appointment() {
    }
}
