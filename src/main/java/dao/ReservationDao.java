package dao;

import config.Config;
import controller.EntityManagerUtils;
import model.Reservation;
import model.Resource;
import model.ResourceType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * DAO for {Reservation} management
 */
public class ReservationDao {

    private ReservationDao() {
        // static class
    }

    public static ReservationDao getDAO() {
        return new ReservationDao();
    }

    /**
     * Find a Reservation by its ind
     *
     * @param id the id of the Reservation
     * @return the Reservation matching the id
     */
    public Reservation find(final Long id) {
        return EntityManagerUtils.getEntityManager().find(Reservation.class, id);
    }

    /**
     * Create a Reservation
     *
     * @param r the Reservation to create
     */
    public void create(Reservation r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.persist(r);

        trx.commit();
    }

    /**
     * Delete an Reservation
     *
     * @param r the Reservation to delete
     */
    public void delete(Reservation r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.remove(r);

        trx.commit();
    }

    /**
     * Update a Reservation
     *
     * @param r the Reservation to update
     */
    public void update(Reservation r) {
        final EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();

        em.merge(r);

        trx.commit();
    }

    /**
     * Find all the Reservations
     *
     * @return all the Reservations
     */
    public List<Reservation> listAll() {
        final String displayAllQuery = "Select rsr from Reservation rsr";
        TypedQuery query = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Reservation.class);
        return query.getResultList();
    }

    /**
     * Find all the reservations in a date range
     * @param dateMin minimum date (included) - can be null
     * @param dateMax maximum date (included) - can be null
     * @return all the reservations in the range
     */
    public List<Reservation> listInRange(Date dateMin, Date dateMax) {
        final String displayAllQuery = "Select rsr " +
                "from Reservation rsr " +
                "where " +
                "((:dateMin IS NOT NULL AND :dateMax IS NOT NULL) AND ((:dateMax >= dateStart) and (dateEnd >= :dateMin))) OR " +
                "((:dateMin IS     NULL AND :dateMax IS NOT NULL) AND (:dateMax >= dateStart)) OR " +
                "((:dateMin IS NOT NULL AND :dateMax IS     NULL) AND (dateEnd >= :dateMin)) OR " +
                "(:dateMin IS     NULL AND :dateMax IS     NULL)";
        TypedQuery e = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Reservation.class);
        e.setParameter("dateMin", dateMin);
        e.setParameter("dateMax", dateMax);
        return e.getResultList();
    }

    /**
     * Find all the reservations of a resource in a date range
     * @param resource resource of the reservations
     * @param dateMin minimum date (included) - can be null
     * @param dateMax maximum date (included) - can be null
     * @return all the reservations in the range
     */
    public List<Reservation> listInRange(Resource resource, Date dateMin, Date dateMax) {
        final String displayAllQuery = "Select rsr " +
                "from Reservation rsr " +
                "where (rsr.resource.id = :resourceId) and (:dateMax >= dateStart) and (dateEnd >= :dateMin)";
        TypedQuery e = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Reservation.class);
        e.setParameter("resourceId", resource.getId());
        e.setParameter("dateMin", dateMin);
        e.setParameter("dateMax", dateMax);
        return e.getResultList();
    }

    /**
     * Find all the reservations for the specified user
     * @param login the login of the user
     * @return all the reservations of the user
     */
    public List<Reservation> listByLogin(String login) {
        final String displayAllByLogin = "Select rsr from Reservation rsr where borrower.login = :login";
        TypedQuery e = EntityManagerUtils.getEntityManager().createQuery(displayAllByLogin, Reservation.class);
        e.setParameter("login", login);
        return e.getResultList();
    }

    /**
     * List of resources of the given type that are available to book in [dateMin;dateMax]
     * @param resourceType type of the resources searched
     * @param dateMin beginning of booking
     * @param dateMax end of booking
     * @return resources of the given type and available in the given period
     */
    public List<Resource> listAvailableResources(ResourceType resourceType, Date dateMin, Date dateMax) {
        final String displayAllQuery = "Select res " +
                "FROM Resource res WHERE res.type.id = :resourceTypeId AND NOT EXISTS (" +
                "Select rsr " +
                "from Reservation rsr " +
                "where (rsr.resource.id = res.id) and (:dateMax >= rsr.dateStart) and (rsr.dateEnd >= :dateMin)" +
                ")";
        TypedQuery e = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Reservation.class);
        e.setParameter("resourceTypeId", resourceType.getId()   );
        e.setParameter("dateMin", dateMin);
        e.setParameter("dateMax", dateMax);
        return e.getResultList();
    }
}
