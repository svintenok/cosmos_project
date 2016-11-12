package services;

import models.ForumTopic;
import models.TopicMessage;
import models.User;
import repository.*;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 12.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class ForumServiceImpl implements ForumService {
    ForumTopicRepository forumTopicRepository = new ForumTopicRepositoryImpl();
    TopicMessageRepository topicMessageRepository = new TopicMessageRepositoryImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public void addForumTopic(ForumTopic forumTopic) {
        User user = userService.getUser(forumTopic.getUserId());

        if (user.getRole().getRole().equals("admin"))
            forumTopic.setTechnical(true);
        else
            forumTopic.setTechnical(false);
        forumTopicRepository.addForumTopic(forumTopic);
    }

    @Override
    public void addTopicMessage(TopicMessage topicMessage) {
        topicMessageRepository.addTopicMessage(topicMessage);
    }

    @Override
    public List<ForumTopic> getForumTopicsList(boolean isTechical) {
        List<ForumTopic> forumTopics = forumTopicRepository.getForumTopicsListByBlock(isTechical);
        for (ForumTopic forumTopic : forumTopics){
            forumTopic.setMessagesCount(topicMessageRepository.getMessagesCountByTopic(forumTopic.getId()));
            TopicMessage topicMessage = topicMessageRepository.getLastTopicMessage(forumTopic.getId());
            topicMessage.setUser(userService.getUser(topicMessage.getUserId()));
            forumTopic.setLastMessage(topicMessage);
        }
        return forumTopics;
    }

    @Override
    public ForumTopic getForumTopic(int id) {
        ForumTopic forumTopic = forumTopicRepository.getForumTopicById(id);
        forumTopic.setTopicMessages(topicMessageRepository.getTopicMessagesListByTopic(id));
        return forumTopic;
    }

    @Override
    public ForumTopic getForumTopic(String name) {
        return forumTopicRepository.getForumTopicByName(name);
    }

    @Override
    public List<TopicMessage> getForumTopicMessages(int forumTopicId) {
        List<TopicMessage> topicMessages = topicMessageRepository.getTopicMessagesListByTopic(forumTopicId);
        for(TopicMessage topicMessage : topicMessages)
            topicMessage.setUser(userService.getUser(topicMessage.getUserId()));
        return  topicMessages;
    }

}
