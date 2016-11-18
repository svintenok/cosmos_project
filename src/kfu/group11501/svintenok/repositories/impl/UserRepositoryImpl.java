package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.repositories.UserRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

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
    public int addUser(User user) {
        try {
            PreparedStatement psmt = con.prepareStatement("insert into \"user\"(login, password, email, \"name\", country, photo) values(?,?,?,?,?,?) returning id");
            psmt.setString(1, user.getLogin());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, user.getName());
            psmt.setString(5, user.getCountry());
            psmt.setBoolean(6, user.getPhoto());

            psmt.execute();
            ResultSet resultSet = psmt.getResultSet();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement psmt = con.prepareStatement("update \"user\" " +
                    "set login=?, password=?, email=?, \"name\"=?, country=?, photo=? where id = ?");

            psmt.setString(1, user.getLogin());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, user.getName());
            psmt.setString(5, user.getCountry());
            psmt.setBoolean(6, user.getPhoto());
            psmt.setInt(7, user.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getUserList(int limit, int offset) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from \"user\" where id=?");
            psmt.setInt(1, id);

            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getBoolean("photo"),
                        rs.getInt("role_id")
                );
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from \"user\" where login=?");
            psmt.setString(1, login.toLowerCase());

            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getBoolean("photo"),
                        rs.getInt("role_id")
                );
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
