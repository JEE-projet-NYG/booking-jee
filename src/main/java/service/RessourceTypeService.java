package service;

import model.RessourceType;

import java.util.List;

/**
 * Interface for the {RessourceType}
 */
public interface RessourceTypeService {

    /**
     * Find an ressource by its ind
     *
     * @param id the id of the ressource
     * @return the ressource matching the id
     */
    RessourceType find(final Long id);

    /**
     * Create an ressource
     *
     * @param u the ressource to create
     */
    void create(RessourceType u);

    /**
     * Delete an ressource
     *
     * @param u the ressource to delete
     */
    void delete(RessourceType u);

    /**
     * Update an ressource
     *
     * @param u the ressource to update
     */
    void update(RessourceType u);

    /**
     * Find all the ressources
     *
     * @return all the ressources
     */
    List<RessourceType> listAll();

    /**
     * Find an ressourceType by filtering on its name
     *
     * @param name the name you're looking for
     * @return the list of ressources matching the filter
     */
    List<RessourceType> list(final String name);
}
