package dao;

import config.Config;
import model.Resource;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class ResourceDao {

    public static ResourceDao getDAO() { return new ResourceDao(); }

    public Resource find(final Long id) { return Config.em.find(Resource.class, id); }

    public void create(Resource r) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.persist(r);

        trx.commit();
    }

    public void delete(Resource r) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.remove(r);

        trx.commit();
    }

    public void delete(final Long id) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.remove(this.find(id));

        trx.commit();
    }

    public void update(Resource r) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.merge(r);

        trx.commit();
    }

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
