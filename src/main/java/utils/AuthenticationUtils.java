package utils;

import config.Config;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationUtils {

    private AuthenticationUtils() {
        // static class
    }

    /**
     * Check if the current user is an admin
     *
     * @param session the session storing the role info
     * @return true if the user is an admin, false otherwise
     */
    public static boolean isAdmin(HttpSession session) {
        final String roleValue;
        try {
            roleValue = (String) session.getAttribute("session");
        } catch (IllegalStateException e) {
            return false;
        }

        return Config.SESSION_ADMIN.equals(roleValue);
    }

    /**
     * Check if there's a user logged in
     *
     * @param session the session storing the role info
     * @return true there is an user, false otherwise
     */
    public static boolean userIsPresent(HttpSession session) {
        final String roleValue;
        try {
            roleValue = (String) session.getAttribute("session");
        } catch (IllegalStateException e) {
            return false;
        }

        return roleValue!=null;
    }

    public static HttpServletRequest login(HttpServletRequest request) {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        final UserService userService = new UserServiceImpl();
        final User user = userService.find(login);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                final String status = user.getAdmin() ? Config.SESSION_ADMIN : Config.SESSION_USER ;
                HttpSession session = request.getSession();
                session.setAttribute(Config.SESSION_ATTRIBUTE, status);
                session.setAttribute(Config.LOGIN_ATTRIBUTE, login);
            }
        }

        return request;
    }

    public static HttpServletRequest logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return request;
    }


}