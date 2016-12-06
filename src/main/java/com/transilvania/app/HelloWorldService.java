package com.transilvania.app;

import com.transilvania.app.models.User;
import org.w3c.dom.css.Rect;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Paul on 12/6/2016.
 */
@Path("/hello")
public class HelloWorldService {
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getMessage(@PathParam("param") String message) {
       return null;
    }
}