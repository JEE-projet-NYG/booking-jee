package service.impl;

import dao.ResourceDao;
import model.Resource;
import service.ResourceService;

import java.util.List;

/**
 * Implementation of {ResourceService}
 */
public class ResourceServiceImpl implements ResourceService {

    @Override
    public Resource find(final Long id) {
        return ResourceDao.getDAO().find(id);
    }

    @Override
    public void create(Resource u) {
        ResourceDao.getDAO().create(u);
    }

    @Override
    public void delete(Resource u) {
        ResourceDao.getDAO().delete(u);
    }

    @Override
    public void update(Resource u) {
        ResourceDao.getDAO().update(u);
    }

    @Override
    public List<Resource> listAll() {
        return ResourceDao.getDAO().listAll();
    }

    @Override
    public List<Resource> list(final String name) {
        return ResourceDao.getDAO().list(name);
    }
}
