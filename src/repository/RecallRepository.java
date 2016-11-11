package repository;

import models.Recall;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 07.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface RecallRepository {
    void addRecall(Recall recall);
    void removeRecall(int id);
    void updateRecall(Recall recall);

    List<Recall> getRecallsList();
    List<Recall> getRecallListByTour(int tourId);
    double getRatingByTour(int tourId);
    Recall getRecallById(int id);
    Recall getRecallByUserAndDepartureDate(int userId, int departureDateId);
}
