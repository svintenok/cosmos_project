package repository.impl;

import models.UpdateDate;
import repository.UpdateDateRepository;
import singletons.DBSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: Svintenok Kate
 * Date: 13.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class UpdateDateRepositoryImpl implements UpdateDateRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void updateUpdateDate() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update update_date set \"date\"='now'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUpdate() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from update_date where \"date\"='now'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
