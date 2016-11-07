package repository;

import models.Recall;
import singletons.DBSingleton;

import java.sql.Connection;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 07.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class RecallRepositoryImpl implements RecallRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addRecall(Recall recall) {

    }

    @Override
    public void removeRecall(int id) {

    }

    @Override
    public void updateRecall(Recall recall) {

    }

    @Override
    public List<Recall> getRecallsList() {
        return null;
    }

    @Override
    public List<Recall> getRecallsByTour(int tour_id) {
        return null;
    }

    @Override
    public Recall getRecallById(int id) {
        return null;
    }
}
