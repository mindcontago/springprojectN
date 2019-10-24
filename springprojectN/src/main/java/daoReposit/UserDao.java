package daoReposit;

import models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserRep {
    private final List<User> userList;
    private long userCounterId;

    public UserDao(List<User> userList, Long userCounterId) {
        this.userList = userList;
        this.userCounterId = userCounterId;
    }

    @Override
    public User saveUser(String name, String email, String password) {
        User user = new User(userCounterId++, name, email, password);
        userList.add(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
