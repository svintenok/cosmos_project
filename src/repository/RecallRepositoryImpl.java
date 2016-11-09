package repository;

import models.Recall;
import singletons.DBSingleton;

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

    }

    @Override
    public void removeRecall(int id) {

    }

    @Override
    public void updateRecall(Recall recall) {

    }

    @Override
    public List<Recall> getRecallsList() {
        return null;
    }

    @Override
    public List<Recall> getRecallsByTour(int tourId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from recall " +
                    "join departure_date on departure_date.id=recall.departure_date_id where tour_id=?");

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
    public int getRatingByTour(int tourId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select avg(estimate) as rating from recall " +
                    "join departure_date on departure_date.id=recall.departure_date_id where tour_id=?");

            psmt.setInt(1, tourId);
            ResultSet rs = psmt.executeQuery();
            List<Recall> recalls = new ArrayList<>();

            if (rs.next()) {
                return rs.getInt("rating");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public Recall getRecallById(int id) {
        return null;
    }
}
