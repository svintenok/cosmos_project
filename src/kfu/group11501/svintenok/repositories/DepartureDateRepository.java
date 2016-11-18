package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.DepartureDate;

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

    DepartureDate getDepartureDateById(int id);
}
