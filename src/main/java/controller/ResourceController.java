package controller;
import model.Resource;
import model.ResourceType;
import model.User;
import service.ResourceService;
import service.ResourceTypeService;
import service.UserService;
import service.impl.ResourceServiceImpl;
import service.impl.ResourceTypeServiceImpl;
import service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/resources")
public class ResourceController {

    @PUT
    public Response createResource(@FormParam("name") final String name,
                                   @FormParam("description") final String description,
                                   @FormParam("localisation") final String localisation,
                                   @FormParam("responsibleId") final Long responsibleId,
                                   @FormParam("resourceTypeId") final Long typeId) {

        final UserService userService = new UserServiceImpl();
        final ResourceService resourceService = new ResourceServiceImpl();
        final ResourceTypeService resourceTypeService = new ResourceTypeServiceImpl();

        User responsible = userService.find(responsibleId);
        if(responsible == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        ResourceType resourceType = resourceTypeService.find(typeId);
        if(resourceType == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        final Resource resource = new Resource(name,description,localisation,responsible,resourceType);

        resourceService.create(resource);
        return Response.status(Response.Status.OK)
                .entity("Resource " + resource.getName() + " has been successfully created.")
                .build();
    }

    @POST
    public Response editResource(@FormParam("id") final Long id,
                                  @FormParam("name") final String name,
                                  @FormParam("description") final String description,
                                  @FormParam("localisation") final String localisation,
                                  @FormParam("responsibleId") final Long responsibleId,
                                  @FormParam("resourceTypeId") final Long typeId) {

        final ResourceService resourceService = new ResourceServiceImpl();
        final Resource resource = resourceService.find(id);
        final UserService userService = new UserServiceImpl();
        final ResourceTypeService resourceTypeService = new ResourceTypeServiceImpl();

        User responsible = userService.find(responsibleId);
        if(responsible == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        ResourceType resourceType = resourceTypeService.find(typeId);
        if(resourceType == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(resource == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        resource.setName(name);
        resource.setDescription(description);
        resource.setLocalisation(localisation);
        resource.setResponsible(responsible);
        resource.setType(resourceType);

        resourceService.update(resource);
        return Response.status(Response.Status.OK)
                .entity("Resource " + resource.getName() + " has been successfully edited.")
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteResource(@PathParam("id") Long id) {
        final ResourceService resourceService = new ResourceServiceImpl();
        final Resource resource = resourceService.find(id);

        if(resource == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        resourceService.delete(resource);

        return Response.status(Response.Status.OK)
                .entity("Resource " + resource.getName() + " has been successfully deleted.").build();
    }

}