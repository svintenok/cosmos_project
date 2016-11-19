package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.Recall;

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
    List<Recall> getRecallListByTour(int tourId);
    double getRatingByTour(int tourId);
    Recall getRecallByUserAndDepartureDate(int userId, int departureDateId);
}
