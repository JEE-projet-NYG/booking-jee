package service;

import model.User;

import java.util.List;

/**
 * Interface for the {User}
 */
public interface UserService {

    /**
     * Find an user by its id
     *
     * @param id the id of the user
     * @return the user matching the id
     */
    User find(final Long id);

    /**
     * Find an user by its login
     *
     * @param login the login of the user
     * @return the user matching the login
     */
    User find(final String login);

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
