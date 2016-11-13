package repository;

import models.Tour;
import org.postgresql.util.PGInterval;
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
    public List<Tour> getToursList(String sorting, boolean reverse, String search) {

        PreparedStatement psmt = null;
        try {
            String SQL = "select * from tour";

            if (search != null) {
                SQL = SQL + " where title like ? or place like ?";
                SQL = setOrder(SQL, sorting, reverse);
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, "%" + search + "%");
                psmt.setString(2, "%" + search + "%");;
            }
            else {
                SQL = setOrder(SQL, sorting, reverse);
                psmt = con.prepareStatement(SQL);

            }

            ResultSet rs = psmt.executeQuery();
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

    @Override
    public void updateTours() {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from tour " +
                    "join departure_date on departure_date_id=departure_date.id where departure_date.date <'now'");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("id");
                psmt = con.prepareStatement("insert into departure_date(tour_id, \"date\") " +
                        "values(?, (select \"time_interval\" + \"date\" from tour " +
                        "join departure_date on departure_date_id=departure_date.id where tour_id=?)) returning id");
                psmt.setInt(1, tourId);
                psmt.setInt(2, tourId);
                psmt.execute();
                ResultSet resultId = psmt.getResultSet();
                psmt = con.prepareStatement("update tour set departure_date_id=? where id=?");
                if (resultId.next()) {
                    System.out.println();
                    psmt.setInt(1, resultId.getInt("id"));
                    psmt.setInt(2, tourId);
                    psmt.executeUpdate();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String setOrder(String SQL, String sorting, boolean reverse){
        SQL = SQL + " ORDER BY ";

        if (sorting.equals("cost"))
            SQL = SQL + "cost";
        else if (sorting.equals("rating"))
            SQL = SQL + "(select avg(estimate) as rating from recall \n" +
                    "join departure_date on departure_date.id=recall.departure_date_id where tour_id=tour.id)";
        else
            SQL = SQL + "(select date from departure_date where departure_date.id=tour.departure_date_id)";

        if (reverse)
            SQL = SQL + " desc";

        return SQL;
    }
}
