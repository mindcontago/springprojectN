package service;

import daoReposit.TaskRep;
import daoReposit.UserRep;
import exceptions.NoSuchUserException;
import exceptions.PasswordInvalidException;
import models.Task;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    private final TaskRep taskRep;

    @Autowired
    public UserServiceImpl(UserRep userRep, TaskRep taskRep) {
        this.userRep = userRep;
        this.taskRep = taskRep;
    }

    @Override
    public void regNewUser(String name, String email, String password) {
        if (userRep.findUserByEmail(email) != null) {
            throw new NoSuchUserException("Email already used.");
        }
        if (userRep.saveUser(name, email, password) == null) {
            throw new RuntimeException("You must fulfill all the fields.");
        }
    }

    @Override
    public User signIn(String email, String password) {
        User user = userRep.findUserByEmail(email);
        if (user == null) {
            throw new NoSuchUserException("No such email.");
        }
        if (!user.getPassword().equals(password)) {
            throw new PasswordInvalidException("Password is invalid.");
        }
        return user;
    }

    public void subscribe(User user, String promoCode) {
        String keyWord = "keyword";
        //String subscriptionKey = DigestUtils.md5DHex(keyWord);
    }


}

