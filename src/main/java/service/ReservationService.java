package service;

import model.Reservation;

import java.util.Date;
import java.util.List;

/**
 * Interface for the {Reservation}
 */
public interface ReservationService {

    /**
     * Find a reservation by its ind
     *
     * @param id the id of the reservation
     * @return the reservation matching the id
     */
    Reservation find(final Long id);

    /**
     * Create a reservation
     *
     * @param r the reservation to create
     */
    void create(Reservation r);

    /**
     * Delete a reservation
     *
     * @param r the reservation to delete
     */
    void delete(Reservation r);

    /**
     * Update a reservation
     *
     * @param r the reservation to update
     */
    void update(Reservation r);

    /**
     * Find all the reservations
     *
     * @return all the reservations
     */
    List<Reservation> listAll();

    /**
     * Find all the reservations in a date range
     * @param dateMin minimum date (included)
     * @param dateMax maximum date (included)
     * @return all the reservations in the range
     */
    List<Reservation> listInRange(Date dateMin, Date dateMax);

    /**
     * Find all the reservations for the specified user
     * @param login the login of the user
     * @return all the reservations of the user
     */
    List<Reservation> listByLogin(String login);
}
