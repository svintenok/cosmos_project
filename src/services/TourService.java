package services;

import models.Tour;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 06.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TourService {

    Tour getTourById(int id);
    List<Tour> getToursList();
}
