package service.impl;

import dao.UserDao;
import model.User;
import service.UserService;

import java.util.List;

/**
 * Implementation of {UserService}
 */
public class UserServiceImpl implements UserService {

    @Override
    public User find(final Long id) {
        return UserDao.getDAO().find(id);
    }

    @Override
    public void create(User u) {
        UserDao.getDAO().create(u);
    }

    @Override
    public void delete(User u) {
        UserDao.getDAO().delete(u);
    }

    @Override
    public void delete(final Long id) {
        UserDao.getDAO().delete(id);
    }

    @Override
    public void update(User u) {
        UserDao.getDAO().update(u);
    }

    @Override
    public List<User> listAll() {
        return UserDao.getDAO().listAll();
    }

    @Override
    public List<User> list(final String name) {
        return UserDao.getDAO().list(name);
    }
}
