package com.transilvania.app.models;

/**
 * Created by Paul on 12/6/2016.
 */
public class AddAppointmentResponse {
    public String message;
    public boolean success;

    public AddAppointmentResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
