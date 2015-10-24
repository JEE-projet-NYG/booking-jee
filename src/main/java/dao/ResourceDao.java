package dao;

import controller.EntityManagerUtils;
import model.Resource;
import model.ResourceType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class ResourceDao {

    public static ResourceDao getDAO() { return new ResourceDao(); }

    public Resource find(final Long id) { return EntityManagerUtils.getEntityManager().find(Resource.class, id); }

    public void create(Resource r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.persist(r);

        trx.commit();
    }

    public void delete(Resource r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.remove(r);

        trx.commit();
    }

    public void delete(final Long id) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.remove(this.find(id));

        trx.commit();
    }

    public void update(Resource r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.merge(r);

        trx.commit();
    }

    public List<Resource> listAll() {
        final String displayAllQuery = "SELECT res FROM Resource res";
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Resource.class);
        return query.getResultList();
    }

    public List<Resource> list(final String name) {
        final String displayByNameQuery = "SELECT res " +
                                          "FROM Resource res " +
                                          "WHERE res.name like '%'"+name+"'%'";
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayByNameQuery, Resource.class);
        return query.getResultList();
    }
}
