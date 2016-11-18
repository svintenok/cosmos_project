package repository;

import models.ForumTopic;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface ForumTopicRepository {
    int addForumTopic(ForumTopic forumTopic);
    void removeForumTopic(int id);
    void updateForumTopic(ForumTopic forumTopic);

    List<ForumTopic> getForumTopicsListByBlock(boolean isTechnical);
    ForumTopic getForumTopicById(int id);
}
