package service;

import models.User;

public interface UserService {
    void regNewUser(String name, String email, String password);

    User signIn(String email, String password);
}
