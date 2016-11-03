package repository;

import models.Booking;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface BookingRepository {
    void addBooking(Booking booking);
    void removeBooking(Booking id);
    void updateBooking(Booking booking);

    List<Booking> getBookingListByUserByDate(int userId, boolean actual, int limit, int offset);
    List<Booking> getBookingListByTourByDate(int tourId, boolean actual, int limit, int offset);
    Booking getBookingById(int id);
}
