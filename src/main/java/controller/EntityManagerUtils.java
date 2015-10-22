package controller;

import javax.persistence.EntityManager;

/**
 * Util class for EntityManager storage at thread level
 */
public class EntityManagerUtils {
    public static final ThreadLocal<EntityManager> ENTITY_MANAGERS = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGERS.get();
    }
}
