package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.User;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface UserRepository {
    int addUser(User user);
    void updateUser(User user);

    User getUserById(int id);
    User getUserByLogin(String login);
}
