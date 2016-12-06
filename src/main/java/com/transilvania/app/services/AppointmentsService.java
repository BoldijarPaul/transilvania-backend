package com.transilvania.app.services;

import com.transilvania.app.controller.Controller;
import com.transilvania.app.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Paul on 12/6/2016.
 */
@Path("/appointments")
public class AppointmentsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointments() {
        return Controller.getInstance().getAppointments();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AddAppointmentResponse addAppointment(AppointmentBody appointment) {
        return Controller.getInstance().addAddapointment(appointment.day,
                appointment.month,
                appointment.year,
                appointment.hour,
                appointment.name,
                appointment.password);
    }
}