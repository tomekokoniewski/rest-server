package com.infoshareacademy.service;

import com.infoshareacademy.model.User;
import com.infoshareacademy.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.Optional;

@Path("/")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserStore userStore;

    public UserService() {
    }

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(@PathParam("name") String name) {
        LOG.info("Saying hello to {}!", name);

        LOG.info("Absolute Path: {}", uriInfo.getAbsolutePath());
        LOG.info("Base URI: {}", uriInfo.getBaseUri());
        LOG.info("Path Parameters: {}", uriInfo.getPathParameters());

        return Response.ok("Saying hello to " + name + "!").build();
    }

    @GET
    @Path("/agent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUserAgent(@HeaderParam("user-agent") String userAgent) {
        LOG.info("User agent: {}", userAgent);

        return Response.ok(userAgent).build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        Collection<User> users = userStore.getBase().values();
        if (users.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("id") Integer id) {
        Optional<User> user = userStore.findById(id);
        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }

        //return Response.status(404).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    /*
    <form method="POST">
      <input type="text" name="username"/><br/>
      <input type="password" name="password"/><br/>
      <input type="Submit"/>
    </form>
     */
}
