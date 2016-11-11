package services;

import models.Recall;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 09.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface RecallService {
    void addRecall(Recall recall);
    List<Recall> getRecallListByTour(int tour_id);
}
