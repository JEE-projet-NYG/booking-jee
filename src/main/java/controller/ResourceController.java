package controller;
import model.Resource;
import service.ResourceService;
import service.impl.ResourceServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/resources")
public class ResourceController {

    @PUT
    public Response createResource(@FormParam("name") final String name,
                                    @FormParam("description") final String description,
                                    @FormParam("localisation") final String localisation,
                                    @FormParam("responsibleId") final Long responsibleId,
                                    @FormParam("typeId") final Long typeId) {

        final ResourceService resourceService = new ResourceServiceImpl();
        final Resource resource = new Resource(name,description,localisation,null,null);

        if(resource == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

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
                                  @FormParam("typeId") final Long typeId) {

        final ResourceService resourceService = new ResourceServiceImpl();
        final Resource resource = resourceService.find(id);

        if(resource == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        resource.setName(name);
        resource.setDescription(description);
        resource.setLocalisation(localisation);
        resource.setResponsible(null);
        resource.setType(null);

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