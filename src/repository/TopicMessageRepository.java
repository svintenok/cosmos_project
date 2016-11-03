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

    List<TopicMessage> getTopicMessagesListByTopic(int topicId, int limit, int offset);
    TopicMessage getTopicMessageById(int id);
}
