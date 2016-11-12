package services;

import models.ForumTopic;
import models.TopicMessage;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 12.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface ForumService {
    void addForumTopic(ForumTopic forumTopic);
    void addTopicMessage(TopicMessage topicMessage);
    List<ForumTopic> getForumTopicsList(boolean isTechical);
    ForumTopic getForumTopic(int id);
    ForumTopic getForumTopic(String name);
    List<TopicMessage> getForumTopicMessages(int forumTopicId);
}
