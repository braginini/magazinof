package ru.ncideas.magazinof.api.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 16:01
 */
@Component
public class UserDataBase {

    private static Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    public UserDataBase() {
        populateUserMap();
    }

    private void populateUserMap() {
        for (int i = 0; i <= 10; i++) {
            String userName = "user" + i;
            User user = new User(new Long(i), userName);
            userMap.put(new Long(i), user);
        }
    }

    public static User putUser(User user) {
        return userMap.put(user.getId(), user);
    }

    public static User getUser(long id) {
        return userMap.get(id);
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        for (Long userId : userMap.keySet()) {
            users.add(userMap.get(userId));
        }
        return users;
    }
}
