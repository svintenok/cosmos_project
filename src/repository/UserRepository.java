package repository;

import models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface UserRepository {
    int addUser(User user);
    void removeUser(int id);
    void updateUser(User user);

    List<User> getUserList(int limit, int offset);
    User getUserById(int id);
    User getUserByLogin(String login);
}
