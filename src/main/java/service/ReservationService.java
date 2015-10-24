package service;

import model.Reservation;
import model.Resource;

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
     * Find all the reservations of a resource in a date range
     *
     * @param dateMin minimum date (included)
     * @param dateMax maximum date (included)
     * @return all the reservations in the range
     */
    List<Reservation> listInRange(Resource resource, Date dateMin, Date dateMax);

    /**
     * Find all the reservations for the specified user
     * @param login the login of the user
     * @return all the reservations of the user
     */
    List<Reservation> listByLogin(String login);

    /**
     * Check if we can book a resource for a period defined by [dateStart;dateEnd]
     * @param resource resource to book
     * @param dateStart beginning of booking
     * @param dateEnd end of booking
     * @return if the resource can be booked
     */
    boolean canBook(Resource resource, Date dateStart, Date dateEnd);
}
