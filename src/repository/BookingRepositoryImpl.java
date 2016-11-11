package repository;

import models.Booking;
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
public class BookingRepositoryImpl implements  BookingRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addBooking(Booking booking) {
        try {

            PreparedStatement psmt = con.prepareStatement("INSERT into booking(user_id, departure_date_id) values(?, ?)");
            psmt.setInt(1, booking.getUserId());
            psmt.setInt(2, booking.getDepartureDateId());
            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBooking(Booking booking) {
        try {
            PreparedStatement psmt = con.prepareStatement("delete from booking where id=?");

            psmt.setInt(1, booking.getId());
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public List<Booking> getBookingListByUserAndActual(int userId, boolean actual) {
        try {
            PreparedStatement psmt = null;
            if (actual) {
                psmt = con.prepareStatement("select * from booking where user_id=? " +
                        "and (select \"date\" from departure_date where id=departure_date_id) > 'now'");
            }
            else {
                psmt = con.prepareStatement("select * from booking where user_id=? " +
                        "and (select \"date\" from departure_date where id=departure_date_id) <= 'now'");
            }
            psmt.setInt(1, userId);
            ResultSet rs = psmt.executeQuery();
            List<Booking> bookings = new ArrayList<>();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("departure_date_id"));
                bookings.add(booking);
            }
            return  bookings;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Booking> getBookingListByDepartureDate(int departureDateId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from booking where departure_date_id=?");

            psmt.setInt(1, departureDateId);
            ResultSet rs = psmt.executeQuery();
            List<Booking> bookings = new ArrayList<>();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("departure_date_id"));
                bookings.add(booking);
            }
            return  bookings;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Booking getBookingById(int id) {
        return null;
    }

    @Override
    public Booking getBookingByUserAndDepartureDate(int userId, int departureDateId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from booking where user_id=? and departure_date_id=?");

            psmt.setInt(1, userId);
            psmt.setInt(2, departureDateId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("departure_date_id"));
                return  booking;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
