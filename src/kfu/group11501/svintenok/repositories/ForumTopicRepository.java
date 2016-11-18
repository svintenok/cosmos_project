package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.ForumTopic;

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

    List<ForumTopic> getForumTopicsListByBlock(boolean isTechnical);
    ForumTopic getForumTopicById(int id);
}
