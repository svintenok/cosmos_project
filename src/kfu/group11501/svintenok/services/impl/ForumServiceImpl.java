package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.ForumTopic;
import kfu.group11501.svintenok.models.TopicMessage;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.repositories.*;
import kfu.group11501.svintenok.repositories.impl.ForumTopicRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.TopicMessageRepositoryImpl;
import kfu.group11501.svintenok.services.ForumService;
import kfu.group11501.svintenok.services.UserService;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 12.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class ForumServiceImpl implements ForumService {
    final static int messagesLimit = 12;
    ForumTopicRepository forumTopicRepository = new ForumTopicRepositoryImpl();
    TopicMessageRepository topicMessageRepository = new TopicMessageRepositoryImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public int addForumTopic(ForumTopic forumTopic) {
        User user = userService.getUser(forumTopic.getUserId());

        if (user.getRole().getRole().equals("admin"))
            forumTopic.setTechnical(true);
        else
            forumTopic.setTechnical(false);
        return forumTopicRepository.addForumTopic(forumTopic);
    }

    @Override
    public void addTopicMessage(TopicMessage topicMessage) {
        topicMessageRepository.addTopicMessage(topicMessage);
    }

    @Override
    public void removeTopicMessage(int id) {
        topicMessageRepository.removeTopicMessage(id);
    }

    @Override
    public void removeForumTopic(int id) {
        forumTopicRepository.removeForumTopic(id);
    }

    @Override
    public List<ForumTopic> getForumTopicsList(boolean isTechical) {
        List<ForumTopic> forumTopics = forumTopicRepository.getForumTopicsListByBlock(isTechical);
        for (ForumTopic forumTopic : forumTopics){
            forumTopic.setMessagesCount(topicMessageRepository.getMessagesCountByTopic(forumTopic.getId()));
            TopicMessage lastTopicMessage = topicMessageRepository.getLastTopicMessage(forumTopic.getId());
            if (lastTopicMessage != null) {
                lastTopicMessage.setUser(userService.getUser(lastTopicMessage.getUserId()));
                forumTopic.setLastMessage(lastTopicMessage);
            }
        }
        return forumTopics;
    }

    @Override
    public ForumTopic getForumTopic(int id, int page) {
        ForumTopic forumTopic = forumTopicRepository.getForumTopicById(id);
        setTopicMessages(forumTopic, page);
        int messagesCount = topicMessageRepository.getMessagesCountByTopic(id);
        if(messagesCount > 0)
            forumTopic.setPagesCount((int) Math.ceil((double)messagesCount/messagesLimit));
        else
            forumTopic.setPagesCount(1);
        return forumTopic;
    }


    private void setTopicMessages(ForumTopic forumTopic, int page) {
        List<TopicMessage> topicMessages = topicMessageRepository.getTopicMessagesListByTopic(
                forumTopic.getId(), page, messagesLimit);
        for(TopicMessage topicMessage : topicMessages)
            topicMessage.setUser(userService.getUser(topicMessage.getUserId()));
        forumTopic.setMessages(topicMessages);
    }

    public static int getMessagesLimit() {
        return messagesLimit;
    }
}
