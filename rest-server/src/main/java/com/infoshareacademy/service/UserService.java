package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

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
}
