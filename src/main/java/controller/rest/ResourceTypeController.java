package controller.rest;
import model.ResourceType;
import service.ResourceTypeService;
import service.impl.ResourceTypeServiceImpl;
import utils.AuthenticationUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/resourceTypes")
public class ResourceTypeController {

    @PUT
    public Response createResourceType(@FormParam("name") final String name,
                                       @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();

        ResourceTypeService resourceTypeService = new ResourceTypeServiceImpl();

        final ResourceType resourceType = new ResourceType(name);

        resourceTypeService.create(resourceType);
        return Response.status(Response.Status.OK)
                .entity("ResourceType " + resourceType.getName() + " has been successfully created.")
                .build();
    }

    @POST
    public Response editResourceType(@FormParam("id") final Long id,
                                     @FormParam("name") final String name,
                                     @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();

        final ResourceTypeService resourceTypeService = new ResourceTypeServiceImpl();
        final ResourceType resourceType = resourceTypeService.find(id);

        if(resourceType == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        resourceType.setName(name);

        resourceTypeService.update(resourceType);
        return Response.status(Response.Status.OK)
                .entity("ResourceType " + resourceType.getName() + " has been successfully edited.")
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteResourceType(@PathParam("id") Long id,
                                       @Context HttpServletRequest request) {

        if (!AuthenticationUtils.isAdmin(request.getSession())) return Response.status(Response.Status.UNAUTHORIZED).build();

        final ResourceTypeService resourceTypeService = new ResourceTypeServiceImpl();
        final ResourceType resourceType = resourceTypeService.find(id);

        if(resourceType == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        resourceTypeService.delete(resourceType);

        return Response.status(Response.Status.OK)
                .entity("ResourceType " + resourceType.getName() + " has been successfully deleted.").build();
    }

}