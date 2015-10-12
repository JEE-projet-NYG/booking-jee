package service;

import dao.UserDao;
import model.User;

import java.util.List;

/**
 * Created by gpouillo on 08/10/15.
 */
public class ServiceUser {

    public static List<User> getUsers() {
        return UserDao.getUsers();
    }
}
