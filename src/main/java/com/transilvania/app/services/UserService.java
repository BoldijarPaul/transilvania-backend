package com.transilvania.app.services;

import com.transilvania.app.controller.Controller;
import com.transilvania.app.models.RegisterResponse;
import com.transilvania.app.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Paul on 12/6/2016.
 */
@Path("/users")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return Controller.getInstance().getUsers();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@PathParam("param") String name) {
        return Controller.getInstance().getUsersByName(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterResponse addUser(User user) {
        boolean added = Controller.getInstance().addUser(user.name, user.password, user.phone);
        return new RegisterResponse(added);
    }
}