package config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Config {

    public static EntityManager em = Persistence.createEntityManagerFactory("rootUnit").createEntityManager();

    private Config() {
        // static class
    }

}