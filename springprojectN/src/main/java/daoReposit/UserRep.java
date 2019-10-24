package daoReposit;

import models.User;

public interface UserRep {
    User saveUser(String name, String email, String password);
    User findUserByEmail(String email);
}
