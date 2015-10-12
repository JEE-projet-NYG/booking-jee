package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gpouillo on 08/10/15.
 */
public class UserDao {

    public static List<User> getUsers() {
        ArrayList<User> res = new ArrayList<>();
        User u1 = new User();
        u1.setId(1L);
        u1.setLogin("gpouilloux");
        res.add(u1);

        return res;
    }
}
