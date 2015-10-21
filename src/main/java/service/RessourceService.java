package service;

import model.Ressource;

import java.util.List;

/**
 * Interface for the {Ressource}
 */
public interface RessourceService {

    /**
     * Find an ressource by its ind
     *
     * @param id the id of the ressource
     * @return the ressource matching the id
     */
    Ressource find(final Long id);

    /**
     * Create an ressource
     *
     * @param u the ressource to create
     */
    void create(Ressource u);

    /**
     * Delete an ressource
     *
     * @param u the ressource to delete
     */
    void delete(Ressource u);

    /**
     * Update an ressource
     *
     * @param u the ressource to update
     */
    void update(Ressource u);

    /**
     * Find all the ressources
     *
     * @return all the ressources
     */
    List<Ressource> listAll();

    /**
     * Find an ressource by filtering on its name
     *
     * @param name the name you're looking for
     * @return the list of ressources matching the filter
     */
    List<Ressource> list(final String name);
}
