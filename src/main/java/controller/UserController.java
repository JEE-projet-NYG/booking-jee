package controller;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @POST
    public Response createUser(@FormParam("login") final String login,
                               @FormParam("password") final String password,
                               @FormParam("lastname") final String lastname,
                               @FormParam("firstname") final String firstname,
                               @FormParam("mailAddress") final String mailAddress,
                               @FormParam("phoneNumber") final String phoneNumber,
                               @FormParam("admin") final Boolean admin) {

        final UserService userService = new UserServiceImpl();
        final User user = new User(login, password, lastname, firstname, mailAddress, phoneNumber, admin == null ? false : admin);

        if(user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        userService.create(user);
        return Response.status(Response.Status.OK)
                .entity("User " + user.getLogin() + " has been successfully created.").build();
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