package kfu.group11501.svintenok.services;


import kfu.group11501.svintenok.models.User;

import javax.servlet.http.Part;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface UserService {

    void addUser(User user, Part photo);
    void updateUser(User user, Part photo);
    void updatePassword(int userId, String password);
    User getUser(int id);
    User getUser(String login, String password);
    User getUser(String login);

}
