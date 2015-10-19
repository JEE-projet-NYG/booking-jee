package controller;
import model.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/users")
public class UserController {

    // TODO inject or retrieve this service
    UserService userService;

    @PUT
    @Path("{id}")
    @Consumes( MediaType.APPLICATION_JSON )
    public Response createUser(User user) {
        if(user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(200)
                .entity("Will create user : " + user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        return Response.status(200)
                .entity("Will delete user : " + id).build();
    }

}