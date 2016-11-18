package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.Tour;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TourRepository {

    int addTour(Tour tour, String date);
    void updateTour(Tour  tour);

    List<Tour> getToursList(String sorting, boolean reverse, String search, int page, int limit);
    Tour getTourById(int id);
    void updateTours();
}
