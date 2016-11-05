package repository;

import models.ForumTopic;
import singletons.DBSingleton;

import java.sql.Connection;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class ForumTopicRepositoryImpl implements ForumTopicRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addForumTopic(ForumTopic forumTopic) {

    }

    @Override
    public void removeForumTopic(int id) {

    }

    @Override
    public void updateForumTopic(ForumTopic forumTopic) {

    }

    @Override
    public List<ForumTopic> getForumTopicsListByBlock(boolean isTechnical, int limit, int offset) {
        return null;
    }

    @Override
    public ForumTopic getForumTopicById(int id) {
        return null;
    }
}
