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
    void addForumTopic(ForumTopic forumTopic);
    void removeForumTopic(int id);
    void updateForumTopic(ForumTopic forumTopic);

    List<ForumTopic> getForumTopicsListByBlock(boolean isTechnical, int limit, int offset);
    ForumTopic getForumTopicById(int id);
}
