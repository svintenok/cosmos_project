package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.Role;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.repositories.RoleRepository;
import kfu.group11501.svintenok.repositories.impl.RoleRepositoryImpl;
import kfu.group11501.svintenok.repositories.UserRepository;
import kfu.group11501.svintenok.repositories.impl.UserRepositoryImpl;
import kfu.group11501.svintenok.services.UserService;

import javax.servlet.http.Part;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;

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
    public void addUser(User user, Part photo){
        if (photo.getSize() !=  0) {
            user.setPhoto(true);
            int id = userRepository.addUser(user);
            downloadPhoto(photo, "users_photo/" + id);
        }
        else
            user.setPhoto(false);
            userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user, Part photo) {
        if (photo.getSize() !=  0) {
            user.setPhoto(true);
            downloadPhoto(photo, "users_photo/" + user.getId());
        }
        userRepository.updateUser(user);
    }

    @Override
    public void updatePassword(int userId, String password) {
        User user = userRepository.getUserById(userId);
        user.setPassword(password);
        userRepository.updateUser(user);
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
