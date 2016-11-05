package repository;

import models.User;
import singletons.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class UserRepositoryImpl implements UserRepository {
    private Connection con = DBSingleton.getConnection();

    public UserRepositoryImpl() {}

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement psmt = con.prepareStatement("insert into \"user\"(login, password, email, \"name\", country, photo) values(?,?,?,?,?,?)");
                psmt.setString(1, user.getLogin());
                psmt.setString(2, user.getPassword());
                psmt.setString(3, user.getEmail());
                psmt.setString(4, user.getName());
                psmt.setString(5, user.getCountry());
                psmt.setBoolean(6, user.getPhoto());

                psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public User getUserByLogin(String login) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from \"user\" where login=?");
            psmt.setString(1, login);

            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getBoolean("photo"),
                        rs.getInt("role_id")
                );
                user.setLogin(login);
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
