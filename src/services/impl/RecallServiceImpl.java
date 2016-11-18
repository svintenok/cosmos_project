package services.impl;

import models.Recall;
import repository.RecallRepository;
import repository.impl.RecallRepositoryImpl;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import services.RecallService;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 09.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class RecallServiceImpl implements RecallService {
    RecallRepository recallRepository = new RecallRepositoryImpl();
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void addRecall(Recall recall) {
        recallRepository.addRecall(recall);
    }

    @Override
    public List<Recall> getRecallListByTour(int tourId) {
        List<Recall> recallList = recallRepository.getRecallListByTour(tourId);
        for (Recall recall: recallList)
            recall.setUser(userRepository.getUserById(recall.getUserId()));
        return recallList;
    }
}
