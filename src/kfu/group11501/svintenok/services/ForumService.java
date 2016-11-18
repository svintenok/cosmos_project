package kfu.group11501.svintenok.services;

import kfu.group11501.svintenok.models.ForumTopic;
import kfu.group11501.svintenok.models.TopicMessage;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 12.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface ForumService {
    void addTopicMessage(TopicMessage topicMessage);
    void removeTopicMessage(int id);

    void removeForumTopic(int id);
    int addForumTopic(ForumTopic forumTopic);
    List<ForumTopic> getForumTopicsList(boolean isTechical);
    ForumTopic getForumTopic(int id, int page);
}
