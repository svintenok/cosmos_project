package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.DepartureDate;
import kfu.group11501.svintenok.repositories.DepartureDateRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

import java.sql.*;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class DepartureDateRepositoryImpl implements DepartureDateRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public DepartureDate getDepartureDateById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from departure_date where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                DepartureDate departureDate = new DepartureDate(
                        rs.getInt("id"),
                        rs.getInt("tour_id"),
                        rs.getTimestamp("date"));
                return departureDate;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
