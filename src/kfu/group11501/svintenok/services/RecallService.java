package kfu.group11501.svintenok.services;

import kfu.group11501.svintenok.models.Recall;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 09.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface RecallService {
    void addRecall(Recall recall);
    void removeRecall(int id);
    List<Recall> getRecallListByTour(int tour_id);
}
