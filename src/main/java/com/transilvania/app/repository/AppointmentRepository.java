package com.transilvania.app.repository;

import com.transilvania.app.controller.Controller;
import com.transilvania.app.models.AddAppointmentResponse;
import com.transilvania.app.models.Appointment;
import com.transilvania.app.models.User;
import com.transilvania.app.utils.CacheArrayList;
import com.transilvania.app.utils.RUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 12/6/2016.
 */
public class AppointmentRepository {
    private List<Appointment> appointments = new CacheArrayList<Appointment>("appointment");

    public AddAppointmentResponse addAppointment(int day, int month, int year, int hour, String name, String password) {
        if (name == null || password == null) {
            return new AddAppointmentResponse("Name or password are null", false);
        }
        User user = Controller.getInstance().getUser(name, password);
        if (user == null) {
            return new AddAppointmentResponse("User not found!", false);
        }
        for (Appointment appointment : appointments) {
            if (day == appointment.day &&
                    month == appointment.month &&
                    year == appointment.year &&
                    hour == appointment.hour) {
                return new AddAppointmentResponse("There is an appointment already at the selected date.", false);
            }
        }
        appointments.add(new Appointment(day, month, year, hour, user.id, null, RUtils.randomId()));
        return new AddAppointmentResponse("Success", true);
    }

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<Appointment>(this.appointments);
        for (Appointment appointment : appointments) {
            appointment.user = Controller.getInstance().getUserById(appointment.userId);
        }
        return appointments;
    }
}
