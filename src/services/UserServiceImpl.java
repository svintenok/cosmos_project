package services;

import models.Role;
import models.User;
import repository.RoleRepository;
import repository.RoleRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();
    private RoleRepository roleRepository = new RoleRepositoryImpl();


    @Override
    public void addUser(User user) throws SQLException {
        userRepository.addUser(user);
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.getUserById(id);
        if (user != null) {
            Role role = roleRepository.getRoleById(user.getRoleId());
            user.setRole(role);
        }
        return user;
    }

    @Override
    public User getUser(String login, String password) {
        User user = userRepository.getUserByLogin(login);
        if (user != null && user.getPassword().equals(password))
            return user;
        return null;
    }

    @Override
    public User getUser(String login) {
        User user = userRepository.getUserByLogin(login);
        if (user != null) {
            Role role = roleRepository.getRoleById(user.getRoleId());
            user.setRole(role);
        }
        return user;
    }


}
