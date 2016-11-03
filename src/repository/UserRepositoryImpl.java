package repository;

import models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static helpers.Helper.getHash;
import static helpers.Helper.getPreparedStatement;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getUserList(int limit, int offset) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
