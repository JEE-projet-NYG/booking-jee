package service.impl;

import dao.RessourceTypeDao;
import model.RessourceType;
import service.RessourceTypeService;

import java.util.List;

/**
 * Implementation of {RessourceTypeService}
 */
public class RessourceTypeServiceImpl implements RessourceTypeService {

    @Override
    public RessourceType find(final Long id) {
        return RessourceTypeDao.getDAO().find(id);
    }

    @Override
    public void create(RessourceType u) {
        RessourceTypeDao.getDAO().create(u);
    }

    @Override
    public void delete(RessourceType u) {
        RessourceTypeDao.getDAO().delete(u);
    }

    @Override
    public void update(RessourceType u) {
        RessourceTypeDao.getDAO().update(u);
    }

    @Override
    public List<RessourceType> listAll() {
        return RessourceTypeDao.getDAO().listAll();
    }

    @Override
    public List<RessourceType> list(final String name) {
        return RessourceTypeDao.getDAO().list(name);
    }
}
