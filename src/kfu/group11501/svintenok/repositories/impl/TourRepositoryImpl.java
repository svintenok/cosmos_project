package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.Interval;
import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.repositories.TourRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;
import org.postgresql.util.PGInterval;

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
    public int addTour(Tour tour, String date) {
        try {
            PGInterval interval = null;
            if (tour.getInterval() != null)
                interval = tour.getInterval().getInterval();

            PreparedStatement psmt = con.prepareStatement(
                    "insert into tour(title, place, rocket, description,  time_interval, seats_number, cost) " +
                            "values(?,?,?,?,?,?,?) returning id");
            psmt.setString(1, tour.getTitle());
            psmt.setString(2, tour.getPlace());
            psmt.setString(3, tour.getRocket());
            psmt.setString(4, tour.getDescription());
            psmt.setObject(5, interval, Types.OTHER);
            psmt.setInt(6, tour.getSeatsNumber());
            psmt.setInt(7, tour.getCost());

            psmt.execute();
            ResultSet resultId = psmt.getResultSet();
            if (resultId.next()) {
                int tourId = resultId.getInt("id");
                psmt = con.prepareStatement(
                        "insert into departure_date(tour_id, \"date\") values(?,  to_date(?, 'YYYY-MM-DD')) returning id");
                psmt.setInt(1, tourId);
                psmt.setObject(2, date);
                psmt.execute();
                resultId = psmt.getResultSet();
                if (resultId.next()) {
                    psmt = con.prepareStatement("update tour set departure_date_id=? where id=?");
                    psmt.setInt(1, resultId.getInt("id"));
                    psmt.setInt(2, tourId);
                    psmt.executeUpdate();
                }
                return tourId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void updateTour(Tour tour) {
        try {
            PGInterval interval = null;
            if (tour.getInterval() != null)
                interval = tour.getInterval().getInterval();

            PreparedStatement psmt = con.prepareStatement("update tour " +
                    "set title=?, place=?, rocket=?, description=?, time_interval=?, seats_number=?, cost=? where id=?");
            psmt.setString(1, tour.getTitle());
            psmt.setString(2, tour.getPlace());
            psmt.setString(3, tour.getRocket());
            psmt.setString(4, tour.getDescription());
            psmt.setObject(5, interval, Types.OTHER);
            psmt.setInt(6, tour.getSeatsNumber());
            psmt.setInt(7, tour.getCost());
            psmt.setInt(8, tour.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tour> getToursList(String sorting, boolean reverse, String search, int page, int limit) {

        PreparedStatement psmt = null;
        try {
            String SQL = "select * from tour where departure_date_id notnull";

            if (search != null) {
                SQL = SQL + " and title ilike ? or place ilike ?";
                SQL = setOrder(SQL, sorting, reverse);
                SQL = SQL + " limit " + limit + " offset " + (page-1)*limit;
                psmt = con.prepareStatement(SQL);
                psmt.setString(1, "%" + search + "%");
                psmt.setString(2, "%" + search + "%");;
            }
            else {
                SQL = setOrder(SQL, sorting, reverse);
                SQL = SQL + " limit " + limit + " offset " + (page-1)*limit;
                psmt = con.prepareStatement(SQL);

            }

            ResultSet rs = psmt.executeQuery();
            List<Tour> tours = new ArrayList<>();

            while (rs.next()) {
                Interval interval = null;
                PGInterval pgInterval = (PGInterval) rs.getObject("time_interval");
                if ( rs.getObject("time_interval") != null)
                    interval = new Interval(pgInterval);
                Tour tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("place"),
                        rs.getString("rocket"),
                        rs.getString("description"),
                        rs.getInt("departure_date_id"),
                        interval,
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
                Interval interval = null;
                PGInterval pgInterval = (PGInterval) rs.getObject("time_interval");
                if ( rs.getObject("time_interval") != null)
                    interval = new Interval(pgInterval);

                Tour tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("place"),
                        rs.getString("rocket"),
                        rs.getString("description"),
                        rs.getInt("departure_date_id"),
                        interval,
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
                    "join departure_date on departure_date_id=departure_date.id " +
                    "where departure_date.date <'now' and \"time_interval\" notnull");
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
            SQL = SQL + "(select date from departure_date where departure_date.id=tour.departure_date_id) ";

        if (reverse)
            SQL = SQL + " desc";

        SQL = SQL + " NULLS LAST";

        return SQL;
    }
}
