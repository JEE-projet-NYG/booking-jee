package controller;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @PUT
    @Path("{id}")
    @Consumes( MediaType.APPLICATION_JSON )
    public Response createUser(User user) {
        if(user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK)
                .entity("Will create user : " + user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        final UserService userService = new UserServiceImpl();
        final User user = userService.find(id);

        if(user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        userService.delete(user);

        return Response.status(Response.Status.OK)
                .entity("User " + user.getLogin() + " has been successfully deleted.").build();
    }

}