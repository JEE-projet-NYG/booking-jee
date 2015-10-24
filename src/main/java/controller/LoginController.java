package controller;

import config.Config;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Created by ferrilata on 21/10/15.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        final UserService userService = new UserServiceImpl();
        final User user = userService.find(login);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                final String status = user.getAdmin() ? Config.SESSION_ADMIN : Config.SESSION_USER ;
                HttpSession session = request.getSession();
                session.setAttribute(Config.SESSION_ATTRIBUTE, status);
                response.sendRedirect("/" + Config.APP_NAME + "/");
                return;
            }
        }
        response.sendRedirect(Config.LOGIN_URL);
        return;
    }

}
