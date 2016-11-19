package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.Booking;
import kfu.group11501.svintenok.models.DepartureDate;
import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.repositories.*;
import kfu.group11501.svintenok.repositories.impl.BookingRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.DepartureDateRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.RecallRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.TourRepositoryImpl;
import kfu.group11501.svintenok.services.BookingService;

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
    RecallRepository recallRepository = new RecallRepositoryImpl();


    @Override
    public void removeBooking(int id) {
        bookingRepository.removeBooking(id);
    }

    @Override
    public void addBooking(int user_id, int tour_id) {

        Tour tour = tourRepository.getTourById(tour_id);
        Booking booking = new Booking(user_id, tour.getDepartureDateId());
        bookingRepository.addBooking(booking);
    }

    @Override
    public List<Booking> getTravelsListByUser(int userId) {

        List<Booking> bookings = bookingRepository.getBookingListByUserAndActual(userId, false);
        setBookingAdditionalInfo(bookings);
        for ( Booking booking : bookings)
            booking.setRecall(recallRepository.getRecallByUserAndDepartureDate(userId, booking.getDepartureDateId()));

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

    @Override
    public List<Booking> getBookingListByUser(int userId) {

        List<Booking> bookings = bookingRepository.getBookingListByUserAndActual(userId, true);
        setBookingAdditionalInfo(bookings);
        return bookings;
    }

    @Override
    public Booking getBoookingByUserAndTour(int userId, int tourId) {
        Tour tour = tourRepository.getTourById(tourId);
        return bookingRepository.getBookingByUserAndDepartureDate(userId, tour.getDepartureDateId());
    }

    private void setBookingAdditionalInfo(List<Booking> bookings){
        for ( Booking booking : bookings){
            DepartureDate departureDate = departureDateRepository.getDepartureDateById(booking.getDepartureDateId());
            Tour tour = tourRepository.getTourById(departureDate.getTourId());
            departureDate.setTour(tour);
            booking.setDepartureDate(departureDate);
        }
    }

}
