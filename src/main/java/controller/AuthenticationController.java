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

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();

        User user = userService.find(login);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                String session;
                session = user.getAdmin() ? Config.SESSION_ADMIN : Config.SESSION_USER ;
                Cookie cookie = new Cookie(Config.SESSION_ATTRIBUTE, session);
                response.addCookie(cookie);
            }
        }

        this.getServletContext().getRequestDispatcher("/"+Config.APP_NAME+"/").forward(request,response);

    }

}
