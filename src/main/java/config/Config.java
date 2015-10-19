package config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Config {

    public static EntityManager em = Persistence.createEntityManagerFactory("rootUnit").createEntityManager();

    // attribute, visible to the scriptlet
    public static final String APP_NAME = "overbooking";


    private Config() {
        // static class
    }

}
