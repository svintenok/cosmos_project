package services;

import models.DepartureDate;
import models.Recall;
import models.Tour;
import repository.*;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 06.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TourServiceImpl implements TourService{
    TourRepository tourRepository = new TourRepositoryImpl();
    DepartureDateRepository departureDateRepository = new DepartureDateRepositoryImpl();
    RecallRepository recallRepository = new RecallRepositoryImpl();
    BookingService bookingService = new BookingServiceImpl();
    RecallService recallService = new RecallServiceImpl();


    @Override
    public Tour getTourById(int id) {
        Tour tour = tourRepository.getTourById(id);
        setTourAdditionalInfo(tour);
        tour.setRecallList(recallService.getRecallListByTour(id));
        return tour;
    }

    @Override
    public List<Tour> getToursList(String sorting, boolean reverse, String search) {
        List<Tour> tours = tourRepository.getToursList(sorting, reverse, search);
        for (Tour tour : tours){
            setTourAdditionalInfo(tour);
        }
        return tours;
    }

    private void setTourAdditionalInfo(Tour tour){
        tour.setDepartureDate(departureDateRepository.getDepartureDateById(tour.getDepartureDateId()));
        tour.setBookingCount(bookingService.getBookingCountByTour(tour.getId()));
        double rating = recallRepository.getRatingByTour(tour.getId());
        if (rating != -1)
            tour.setRating(rating);
    }
}
