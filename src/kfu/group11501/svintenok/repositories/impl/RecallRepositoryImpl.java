package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.Recall;
import kfu.group11501.svintenok.repositories.RecallRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 07.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class RecallRepositoryImpl implements RecallRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addRecall(Recall recall) {
        try {
            PreparedStatement psmt = con.prepareStatement("insert into recall (estimate, \"text\", user_id, departure_date_id, \"date\") values(?,?,?,?,'now')");
            psmt.setInt(1, recall.getEstimate());
            psmt.setString(2, recall.getText());
            psmt.setInt(3, recall.getUserId());
            psmt.setInt(4, recall.getDepartureDataId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRecall(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("delete from recall where id=?");
            psmt.setInt(1, id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recall> getRecallListByTour(int tourId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from recall " +
                    "join departure_date on departure_date.id=recall.departure_date_id where tour_id=? ORDER BY recall.\"date\" desc");

            psmt.setInt(1, tourId);
            ResultSet rs = psmt.executeQuery();
            List<Recall> recalls = new ArrayList<>();

            while (rs.next()) {
                Recall recall = new Recall(
                        rs.getInt("id"),
                        rs.getInt("estimate"),
                        rs.getString("text"),
                        rs.getInt("user_id"),
                        rs.getInt("departure_date_id"),
                        rs.getTimestamp("date"));
                recalls.add(recall);
            }

            return recalls;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getRatingByTour(int tourId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select avg(estimate) as rating from recall " +
                    "join departure_date on departure_date.id=recall.departure_date_id where tour_id=?");

            psmt.setInt(1, tourId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("rating");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public Recall getRecallByUserAndDepartureDate(int userId, int departureDateId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from recall where user_id=? and departure_date_id=?");

            psmt.setInt(1, userId);
            psmt.setInt(2, departureDateId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                Recall recall = new Recall(
                        rs.getInt("id"),
                        rs.getInt("estimate"),
                        rs.getString("text"),
                        rs.getInt("user_id"),
                        rs.getInt("departure_date_id"),
                        rs.getTimestamp("date"));
                return recall;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
