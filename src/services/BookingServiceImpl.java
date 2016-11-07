package services;

import models.Booking;
import models.DepartureDate;
import models.Tour;
import repository.*;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 08.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository = new BookingRepositoryImpl();
    DepartureDateRepository departureDateRepository = new DepartureDateRepositoryImpl();
    TourRepository tourRepository = new TourRepositoryImpl();


    @Override
    public List<Booking> getTravelsListByUser(int user_id) {

        List<Booking> bookings = bookingRepository.getBookingListByUserAndActual(user_id, false);

        for ( Booking booking : bookings){
            DepartureDate departureDate = departureDateRepository.getDepartureDateById(booking.getDepartureDateId());
            Tour tour = tourRepository.getTourById(departureDate.getTourId());
            departureDate.setTour(tour);
            booking.setDepartureDate(departureDate);
        }
        return bookings;
    }


    @Override
    public int getTravelsCountByUser(int user_id) {
        return getTravelsListByUser(user_id).size();
    }

    @Override
    public List<Booking> getBookingListByTour(int tour_id) {
        Tour tour = tourRepository.getTourById(tour_id);
        return bookingRepository.getBookingListByDepartureDate(tour.getDepartureDateId());
    }

    @Override
    public int getBookingCountByTour(int tour_id) {
        return getBookingListByTour(tour_id).size();
    }

}
