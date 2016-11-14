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

    int addTour(Tour tour, String date);
    void removeTour(int id);
    void updateTour(Tour  tour);

    List<Tour> getToursList(String sorting, boolean reverse, String search);
    Tour getTourById(int id);
    void updateTours();
}
