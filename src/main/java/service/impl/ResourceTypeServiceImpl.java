package service.impl;

import dao.ResourceTypeDao;
import model.ResourceType;
import service.ResourceTypeService;

import java.util.List;

/**
 * Implementation of {ResourceTypeService}
 */
public class ResourceTypeServiceImpl implements ResourceTypeService {

    @Override
    public ResourceType find(final Long id) {
        return ResourceTypeDao.getDAO().find(id);
    }

    @Override
    public void create(ResourceType u) {
        ResourceTypeDao.getDAO().create(u);
    }

    @Override
    public void delete(ResourceType u) {
        ResourceTypeDao.getDAO().delete(u);
    }

    @Override
    public void update(ResourceType u) {
        ResourceTypeDao.getDAO().update(u);
    }

    @Override
    public List<ResourceType> listAll() {
        return ResourceTypeDao.getDAO().listAll();
    }

    @Override
    public List<ResourceType> list(final String name) {
        return ResourceTypeDao.getDAO().list(name);
    }
}
