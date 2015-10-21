package dao;

import config.Config;
import model.Resource;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class ResourceDao {

    public static ResourceDao getDAO() { return new ResourceDao(); }

    public Resource find(final Long id) { return Config.em.find(Resource.class, id); }

    public void create(Resource r) { Config.em.persist(r); }

    public void delete(Resource r) { Config.em.remove(r); }

    public void delete(final Long id) { Config.em.remove(this.find(id));}

    public void update(Resource r) { Config.em.merge(r); }

    public List<Resource> listAll() {
        final String displayAllQuery = "SELECT res FROM Resource res";
        TypedQuery e = Config.em.createQuery(displayAllQuery, Resource.class);
        return e.getResultList();
    }

    public List<Resource> list(final String name) {
        final String displayByNameQuery = "SELECT res" +
                                          "FROM Resource res" +
                                          "WHERE res.name like '%'"+name+"'%'";
        TypedQuery e = Config.em.createQuery(displayByNameQuery, Resource.class);
        return e.getResultList();
    }
}
