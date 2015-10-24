package config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Config {

    // attribute, visible to the scriptlet
    public static final String APP_NAME = "overbooking";

    public static final String SESSION_ATTRIBUTE = "session";
    public static final String SESSION_ADMIN = "admin";
    public static final String SESSION_USER = "user";
    public static final String LOGIN_ATTRIBUTE = "login";

    public static final String LOGIN_URL = "/"+APP_NAME+"/login";
    public static final String USER_URL = "/"+APP_NAME+"/myReservations";

    public static final String PERSISTENCE_UNIT = "rootUnit";

    private Config() {
        // static class
    }

}
