package service;

import model.ResourceType;

import java.util.List;

/**
 * Interface for the {ResourceType}
 */
public interface ResourceTypeService {

    /**
     * Find an resource by its ind
     *
     * @param id the id of the resource
     * @return the resource matching the id
     */
    ResourceType find(final Long id);

    /**
     * Create an resource
     *
     * @param u the resource to create
     */
    void create(ResourceType u);

    /**
     * Delete an resource
     *
     * @param u the resource to delete
     */
    void delete(ResourceType u);

    /**
     * Update an resource
     *
     * @param u the resource to update
     */
    void update(ResourceType u);

    /**
     * Find all the resources
     *
     * @return all the resources
     */
    List<ResourceType> listAll();

    /**
     * Find an resourceType by filtering on its name
     *
     * @param name the name you're looking for
     * @return the list of resources matching the filter
     */
    List<ResourceType> list(final String name);
}
