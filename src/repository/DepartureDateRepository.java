package repository;

import models.DepartureDate;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface DepartureDateRepository {
    void addDepartureDate(DepartureDate departureDate);
    void removeDepartureDate(int id);
    void updateDepartureDate(DepartureDate departureDate);

    List<DepartureDate> getDepartureDatesListByTour(int tourId, int limit, int offset);
}
