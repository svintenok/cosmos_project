package services;

import models.DepartureDate;
import models.Tour;
import repository.DepartureDateRepository;
import repository.DepartureDateRepositoryImpl;
import repository.TourRepository;
import repository.TourRepositoryImpl;

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


    @Override
    public Tour getTourById(int id) {
        Tour tour = tourRepository.getTourById(id);
        tour.setDepartureDate(departureDateRepository.getDepartureDateById(tour.getDepartureDateId()));
        return tour;
    }

    @Override
    public List<Tour> getToursList() {
        List<Tour> tours = tourRepository.getToursList();
        for (Tour tour : tours){
            tour.setDepartureDate(departureDateRepository.getDepartureDateById(tour.getDepartureDateId()));
        }
        return tours;
    }
}
