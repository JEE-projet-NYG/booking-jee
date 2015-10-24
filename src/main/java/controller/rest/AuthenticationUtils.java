package controller.rest;

import config.Config;

import javax.servlet.http.HttpSession;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Cookie;

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
        final String roleValue = (String) session.getAttribute("session");

        return Config.SESSION_ADMIN.equals(roleValue);
    }
}