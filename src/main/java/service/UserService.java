package service;

import model.User;

import java.util.List;

/**
 * Interface for the {User}
 */
public interface UserService {

    /**
     * Find an user by its ind
     *
     * @param id the id of the user
     * @return the user matching the id
     */
    User find(final Long id);

    /**
     * Create an user
     *
     * @param u the user to create
     */
    void create(User u);

    /**
     * Delete an user
     *
     * @param u the user to delete
     */
    void delete(User u);

    /**
     * Delete an user by its id
     *
     * @param id the id of the user to delete
     */
    void delete(final Long id);

    /**
     * Update an user
     *
     * @param u the user to update
     */
    void update(User u);

    /**
     * Find all the users
     *
     * @return all the users
     */
    List<User> listAll();

    /**
     * Find an user by filtering on its firstname or lastname
     *
     * @param name the name you're looking for
     * @return the list of users matching the filter
     */
    List<User> list(final String name);
}
