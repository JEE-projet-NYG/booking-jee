package service;

import model.Reservation;

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

}
