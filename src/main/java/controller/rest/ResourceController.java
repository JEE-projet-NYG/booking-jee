package controller.rest;
import model.Resource;
import model.ResourceType;
import model.User;
import service.ResourceService;
import service.ResourceTypeService;
import service.UserService;
import service.impl.ResourceServiceImpl;
import service.impl.ResourceTypeServiceImpl;
import service.impl.UserServiceImpl;
import utils.AuthenticationUtils;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/resources")
public class ResourceController {

    @PUT
    public Response createResource(@FormParam("name") final String name,
                                   @FormParam("description") final String description,
                                   @FormParam("localisation") final String localisation,
                                   @FormParam("responsibleId") final Long responsibleId,
                                   @FormParam("resourceTypeId") final Long typeId,
                                   @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();


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
                                 @FormParam("resourceTypeId") final Long typeId,
                                 @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();

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
    public Response deleteResource(@PathParam("id") Long id,
                                   @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();

        final ResourceService resourceService = new ResourceServiceImpl();
        final Resource resource = resourceService.find(id);

        if(resource == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            resourceService.delete(resource);
        }
        catch(RollbackException cve) {
            return Response.status(Response.Status.CONFLICT).entity("You can't delete a resource if there is at least one reservation linked to it").build();
        }
        return Response.status(Response.Status.OK)
                .entity("Resource " + resource.getName() + " has been successfully deleted.").build();
    }

}