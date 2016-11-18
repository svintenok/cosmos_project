package repository.impl;

import models.Role;
import repository.RoleRepository;
import singletons.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class RoleRepositoryImpl implements RoleRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public Role getRoleById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from role where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                Role role = new Role(
                        rs.getInt("id"),
                        rs.getString("role"));
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
