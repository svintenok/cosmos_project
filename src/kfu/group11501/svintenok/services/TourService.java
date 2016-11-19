package kfu.group11501.svintenok.services;

import kfu.group11501.svintenok.models.Tour;

import javax.servlet.http.Part;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 06.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TourService {

    int addTour(Tour tour, String date, Part tourPhoto);
    void updateTour(Tour tour, Part tourPhoto);
    Tour getTourById(int id);
    List<Tour> getToursList(String sorting, boolean reverse, String search, int page);
}
