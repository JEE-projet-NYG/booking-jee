package dao;

import utils.EntityManagerUtils;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DAO for {User} management
 */
public class UserDao {

    private UserDao() {
        // static class
    }

    public static UserDao getDAO() {
        return new UserDao();
    }

    /**
     * Find an user by its ind
     *
     * @param id the id of the user
     * @return the user matching the id
     */
    public User find(final Long id) {
        return EntityManagerUtils.getEntityManager().find(User.class, id);
    }

    /**
     * Find an user by its login
     * @param login the login of the user
     * @return the user matching the login
     */
    public User find(final String login) {
        final String findUserByLogin = "Select usr " +
                "from User usr " +
                "where usr.login = '" + login + "'";

        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(findUserByLogin, User.class);

        List<User> results = query.getResultList();

        return (results != null && results.get(0) != null) ? results.get(0) : null;
    }

    /**
     * Create an user
     *
     * @param u the user to create
     */
    public void create(User u) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.persist(u);

        trx.commit();
    }

    /**
     * Delete an user
     *
     * @param u the user to delete
     */
    public void delete(User u) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.remove(u);

        trx.commit();
    }

    /**
     * Update an user
     *
     * @param u the user to update
     */
    public void update(User u) {
        final EntityManager em = EntityManagerUtils.getEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.merge(u);

        trx.commit();
    }

    /**
     * Find all the users
     *
     * @return all the users
     */
    public List<User> listAll() {
        final String displayAllQuery = "Select usr from User usr";

        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, User.class);

        return query.getResultList();
    }

    /**
     * Find an user by filtering on its firstname or lastname
     *
     * @param name the name you're looking for
     * @return the list of users matching the filter
     */
    public List<User> list(final String name) {
        final String displayAllByNameQuery = "Select usr " +
                "from User usr " +
                "where usr.firstname like '%" + name + "%'" +
                "or usr.lastname like '%" + name + "%'";
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllByNameQuery, User.class);

        return query.getResultList();
    }

}
