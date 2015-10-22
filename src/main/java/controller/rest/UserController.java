package controller.rest;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @PUT
    public Response createUser(@FormParam("login") final String login,
                               @FormParam("password") final String password,
                               @FormParam("lastname") final String lastname,
                               @FormParam("firstname") final String firstname,
                               @FormParam("mailAddress") final String mailAddress,
                               @FormParam("phoneNumber") final String phoneNumber,
                               @FormParam("admin") final Boolean admin,
                               @CookieParam("session") Cookie cookieRole) {

        if (!AuthenticationUtils.isAdmin(cookieRole)) return Response.status(Response.Status.UNAUTHORIZED).build();

        final UserService userService = new UserServiceImpl();
        final User user = new User(login, password, lastname, firstname, mailAddress, phoneNumber, admin == null ? false : admin);

        userService.create(user);
        return Response.status(Response.Status.OK)
                .entity("User " + user.getLogin() + " has been successfully created.")
                .build();
    }

    @POST
    public Response editUser(@FormParam("id") final Long id,
                             @FormParam("login") final String login,
                             @FormParam("password") final String password,
                             @FormParam("lastname") final String lastname,
                             @FormParam("firstname") final String firstname,
                             @FormParam("mailAddress") final String mailAddress,
                             @FormParam("phoneNumber") final String phoneNumber,
                             @FormParam("admin") final Boolean admin,
                             @CookieParam("session") Cookie cookieRole) {

        if (!AuthenticationUtils.isAdmin(cookieRole)) return Response.status(Response.Status.UNAUTHORIZED).build();

        final UserService userService = new UserServiceImpl();
        final User user = userService.find(id);

        if(user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        user.setLogin(login);
        user.setPassword(password);
        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setMailAddress(mailAddress);
        user.setPhoneNumber(phoneNumber);
        user.setAdmin(admin == null ? false : admin);

        userService.update(user);
        return Response.status(Response.Status.OK)
                .entity("User " + user.getLogin() + " has been successfully edited.")
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id,
                               @CookieParam("session") Cookie cookieRole) {

        if (!AuthenticationUtils.isAdmin(cookieRole)) return Response.status(Response.Status.UNAUTHORIZED).build();

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