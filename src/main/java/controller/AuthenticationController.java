package controller;

import config.Config;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ferrilata on 21/10/15.
 */
@WebServlet("/login")
public class AuthenticationController extends HttpServlet{

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        final UserService userService = new UserServiceImpl();
        final User user = userService.find(login);

        if (user != null) {
            if (password.equals(user.getPassword())) { // FIXME on part plutot sur un stockage en session plutot que sur un cookie modifiable par un utilisateur avancé
                final String session = user.getAdmin() ? Config.SESSION_ADMIN : Config.SESSION_USER ;
                final Cookie cookie = new Cookie(Config.SESSION_ATTRIBUTE, session);
                response.addCookie(cookie);
                response.sendRedirect(request.getHeader("Referer")); // TODO avoid going back to login page but instead home page

                return;
            }
        }

        response.sendRedirect("/"+Config.APP_NAME+"/login");
    }

}
