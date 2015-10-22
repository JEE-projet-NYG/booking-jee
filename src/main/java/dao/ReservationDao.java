package dao;

import config.Config;
import model.Reservation;

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
        return Config.em.find(Reservation.class, id);
    }

    /**
     * Create a Reservation
     *
     * @param r the Reservation to create
     */
    public void create(Reservation r) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.persist(r);

        trx.commit();
    }

    /**
     * Delete an Reservation
     *
     * @param r the Reservation to delete
     */
    public void delete(Reservation r) {
        EntityTransaction trx = Config.em.getTransaction();
        trx.begin();

        Config.em.remove(r);

        trx.commit();
    }

    /**
     * Update a Reservation
     *
     * @param r the Reservation to update
     */
    public void update(Reservation r) {
        Config.em.merge(r);
    }

    /**
     * Find all the Reservations
     *
     * @return all the Reservations
     */
    public List<Reservation> listAll() {
        final String displayAllQuery = "Select rsr from Reservation rsr";
        TypedQuery e = Config.em.createQuery(displayAllQuery, Reservation.class);
        return e.getResultList();
    }

    /**
     * Find all the reservations in a date range
     * @param dateMin minimum date (included) - can be null
     * @param dateMax maximum date (included) - can be null
     * @return all the reservations in the range
     */
    public List<Reservation> listInRange(Date dateMin, Date dateMax) {
        final String displayAllQuery = "Select rsr from Reservation rsr where (:dateMin IS NULL OR dateStart >= :dateMin) and (:dateMax IS NULL OR dateEnd <= :dateMax)";
        TypedQuery e = Config.em.createQuery(displayAllQuery, Reservation.class);
        e.setParameter("dateMin", dateMin);
        e.setParameter("dateMax", dateMax);
        return e.getResultList();
    }
}
