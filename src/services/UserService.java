package services;


import models.User;

import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void updatePassword(int userId, String password);
    User getUser(int id);
    User getUser(String login, String password);
    User getUser(String login);

}
