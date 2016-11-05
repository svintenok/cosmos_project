package repository;

import models.DepartureDate;
import singletons.DBSingleton;

import java.sql.Connection;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class DepartureDateRepositoryImpl implements DepartureDateRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addDepartureDate(DepartureDate departureDate) {

    }

    @Override
    public void removeDepartureDate(int id) {

    }

    @Override
    public void updateDepartureDate(DepartureDate departureDate) {

    }

    @Override
    public List<DepartureDate> getDepartureDatesListByTour(int tourId, int limit, int offset) {
        return null;
    }
}
