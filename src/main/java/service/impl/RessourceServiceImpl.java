package service.impl;

import dao.RessourceDao;
import model.Ressource;
import service.RessourceService;

import java.util.List;

/**
 * Implementation of {RessourceService}
 */
public class RessourceServiceImpl implements RessourceService {

    @Override
    public Ressource find(final Long id) {
        return RessourceDao.getDAO().find(id);
    }

    @Override
    public void create(Ressource u) {
        RessourceDao.getDAO().create(u);
    }

    @Override
    public void delete(Ressource u) {
        RessourceDao.getDAO().delete(u);
    }

    @Override
    public void update(Ressource u) {
        RessourceDao.getDAO().update(u);
    }

    @Override
    public List<Ressource> listAll() {
        return RessourceDao.getDAO().listAll();
    }

    @Override
    public List<Ressource> list(final String name) {
        return RessourceDao.getDAO().list(name);
    }
}
