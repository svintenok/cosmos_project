package repository;

import models.Tour;
import singletons.DBSingleton;

import java.sql.Connection;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TourRepositoryImpl implements TourRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addTour(Tour tour) {

    }

    @Override
    public void removeTour(int id) {

    }

    @Override
    public void updateTour(Tour tour) {

    }

    @Override
    public List<Tour> getToursList(int limit, int offset) {
        return null;
    }

    @Override
    public Tour getTourById(int id) {
        return null;
    }
}
