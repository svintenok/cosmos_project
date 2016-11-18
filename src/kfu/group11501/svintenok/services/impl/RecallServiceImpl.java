package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.Recall;
import kfu.group11501.svintenok.repositories.RecallRepository;
import kfu.group11501.svintenok.repositories.impl.RecallRepositoryImpl;
import kfu.group11501.svintenok.repositories.UserRepository;
import kfu.group11501.svintenok.repositories.impl.UserRepositoryImpl;
import kfu.group11501.svintenok.services.RecallService;

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
