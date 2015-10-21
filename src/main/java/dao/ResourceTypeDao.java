package dao;

import config.Config;
import model.ResourceType;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class ResourceTypeDao {

    public static ResourceTypeDao getDAO() { return new ResourceTypeDao(); }

    public ResourceType find(final Long id) { return Config.em.find(ResourceType.class, id); }

    public void create(ResourceType r) { Config.em.persist(r); }

    public void delete(ResourceType r) { Config.em.remove(r); }

    public void delete(final Long id) { Config.em.remove(this.find(id));}

    public void update(ResourceType r) { Config.em.merge(r); }

    public List<ResourceType> listAll() {
        final String displayAllQuery = "SELECT res FROM ResourceType res";
        TypedQuery e = Config.em.createQuery(displayAllQuery, ResourceType.class);
        return e.getResultList();
    }

    /**
     * Find an ResourceType by filtering on its firstname or lastname
     *
     * @param name the name you're looking for
     * @return the list of users matching the filter
     */
    public List<ResourceType> list(final String name) {
        final String displayAllByNameQuery = "Select usr " +
                "from ResourceType usr " +
                "where usr.name like '%" + name + "%'";
        TypedQuery e = Config.em.createQuery(displayAllByNameQuery, ResourceType.class);
        return e.getResultList();
    }

}
