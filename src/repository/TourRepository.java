package repository;

import models.Tour;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TourRepository {

    void addTour(Tour tour);
    void removeTour(int id);
    void updateTour(Tour  tour);

    List<Tour> getToursList();
    Tour getTourById(int id);

}
