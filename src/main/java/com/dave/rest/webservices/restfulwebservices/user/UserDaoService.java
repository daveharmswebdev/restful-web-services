package com.dave.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 5;

    static {
        users.add(new User(1, "Dave", new Date()));
        users.add(new User(2, "Jennifer", new Date()));
        users.add(new User(3, "Orman", new Date()));
        users.add(new User(4, "Ethan", new Date()));
        users.add(new User(5, "Marianna", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId()==null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findUserById(int id) {
        for(User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
