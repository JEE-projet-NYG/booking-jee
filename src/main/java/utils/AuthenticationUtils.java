package utils;

import config.Config;

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


}