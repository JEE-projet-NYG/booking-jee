package service;

import model.Resource;

import java.util.List;

/**
 * Interface for the {Resource}
 */
public interface ResourceService {

    /**
     * Find an resource by its ind
     *
     * @param id the id of the resource
     * @return the resource matching the id
     */
    Resource find(final Long id);

    /**
     * Create an resource
     *
     * @param u the resource to create
     */
    void create(Resource u);

    /**
     * Delete an resource
     *
     * @param u the resource to delete
     */
    void delete(Resource u);

    /**
     * Update an resource
     *
     * @param u the resource to update
     */
    void update(Resource u);

    /**
     * Find all the resources
     *
     * @return all the resources
     */
    List<Resource> listAll();

    /**
     * Find an resource by filtering on its name
     *
     * @param name the name you're looking for
     * @return the list of resources matching the filter
     */
    List<Resource> list(final String name);
}
