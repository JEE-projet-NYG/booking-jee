package dao;

import config.Config;
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
public class ResourceTypeDao {

    public static ResourceTypeDao getDAO() { return new ResourceTypeDao(); }

    public ResourceType find(final Long id) { return EntityManagerUtils.getEntityManager().find(ResourceType.class, id); }

    public void create(ResourceType r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();

        trx.begin();

        em.persist(r);

        trx.commit();
    }

    public void delete(ResourceType r) {
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

        ResourceType resourceType = this.find(id);

        em.remove(resourceType);

        trx.commit();
    }

    public void update(ResourceType r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();

        trx.begin();

        em.merge(r);

        trx.commit();
    }

    public List<ResourceType> listAll() {
        final String displayAllQuery = "SELECT res FROM ResourceType res";
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, ResourceType.class);
        return query.getResultList();
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
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllByNameQuery, ResourceType.class);
        return query.getResultList();
    }

}
