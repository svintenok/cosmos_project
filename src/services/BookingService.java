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

    List<Booking> getTravelsListByUser(int user_id);
    int getTravelsCountByUser(int user_id);
    List<Booking> getBookingListByTour(int tour_id);
    int getBookingCountByTour(int tour_id);
}
