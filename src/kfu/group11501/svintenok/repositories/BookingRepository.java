package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.Booking;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface BookingRepository {
    void addBooking(Booking booking);
    void removeBooking(Booking booking);

    List<Booking> getBookingListByUserAndActual(int userId, boolean actual);
    List<Booking> getBookingListByDepartureDate(int departureDate);
    Booking getBookingByUserAndDepartureDate(int userId, int departureDateId);
}
