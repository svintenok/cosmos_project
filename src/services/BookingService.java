package services;

import models.Booking;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 08.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface BookingService {

    void removeBooking(Booking booking);
    void addBooking(int userId, int tourId);
    Booking getBoookingByUserAndTour(int userId, int tourId);

    List<Booking> getTravelsListByUser(int userId);
    int getTravelsCountByUser(int userId);

    List<Booking> getBookingListByTour(int tourId);
    int getBookingCountByTour(int tourId);

    List<Booking> getBookingListByUser(int userId);
}
