package controller.rest;

import config.Config;

import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Cookie;

public class AuthenticationUtils {

    private AuthenticationUtils() {
        // static class
    }

    /**
     * Check if the current user is an admin
     *
     * @param cookieRole the cookie storing the role info
     * @return true if the user is an admin, false otherwise
     */
    public static boolean isAdmin(Cookie cookieRole) {
        final String cookieRoleValue = cookieRole == null ? null : cookieRole.getValue();

        return Config.SESSION_ADMIN.equals(cookieRoleValue);
    }
}