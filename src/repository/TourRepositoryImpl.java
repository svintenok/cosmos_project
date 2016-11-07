package repository;

import models.Tour;
import singletons.DBSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TourRepositoryImpl implements TourRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addTour(Tour tour) {

    }

    @Override
    public void removeTour(int id) {

    }

    @Override
    public void updateTour(Tour tour) {

    }

    @Override
    public List<Tour> getToursList() {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tour ORDER BY \"departure\"");
            List<Tour> tours = new ArrayList<>();

            while (rs.next()) {
                Tour tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("place"),
                        rs.getString("rocket"),
                        rs.getString("description"),
                        rs.getInt("departure_date_id"),
                        rs.getObject("time_interval"),
                        rs.getInt("seats_number"),
                        rs.getInt("cost"));
                tours.add(tour);
            }
            return  tours;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tour getTourById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from tour where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                Tour tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("place"),
                        rs.getString("rocket"),
                        rs.getString("description"),
                        rs.getInt("departure_date_id"),
                        rs.getObject("time_interval"),
                        rs.getInt("seats_number"),
                        rs.getInt("cost"));
                return tour;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
