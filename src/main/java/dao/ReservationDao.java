package dao;

import config.Config;
import controller.EntityManagerUtils;
import model.Reservation;

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
        final String displayAllQuery = "Select rsr from Reservation rsr where (:dateMin IS NULL OR dateStart >= :dateMin) and (:dateMax IS NULL OR dateEnd <= :dateMax)";
        TypedQuery e = EntityManagerUtils.getEntityManager().createQuery(displayAllQuery, Reservation.class);
        e.setParameter("dateMin", dateMin);
        e.setParameter("dateMax", dateMax);
        return e.getResultList();
    }
}
