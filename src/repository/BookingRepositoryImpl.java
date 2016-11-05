package repository;

import models.Booking;
import singletons.DBSingleton;

import java.sql.Connection;
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

    }

    @Override
    public void removeBooking(Booking id) {

    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public List<Booking> getBookingListByUserByDate(int userId, boolean actual, int limit, int offset) {
        return null;
    }

    @Override
    public List<Booking> getBookingListByTourByDate(int tourId, boolean actual, int limit, int offset) {
        return null;
    }

    @Override
    public Booking getBookingById(int id) {
        return null;
    }
}
