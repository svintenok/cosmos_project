package repository;

import models.TopicMessage;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TopicMessageRepository {
    void addTopicMessage(TopicMessage topicMessage);
    void removeTopicMessage(int id);
    void updateTopicMessage(TopicMessage topicMessage);

    List<TopicMessage> getTopicMessagesListByTopic(int topicId, int page, int limit);
    TopicMessage getTopicMessageById(int id);
    int getMessagesCountByTopic(int topicId);
    TopicMessage getLastTopicMessage(int topicId);
}
