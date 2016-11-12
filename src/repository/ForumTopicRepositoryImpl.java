package repository;

import models.ForumTopic;
import singletons.DBSingleton;

import java.sql.*;
import java.util.ArrayList;
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
        try {
            PreparedStatement psmt = con.prepareStatement("insert into forum_topic(\"name\", user_id, is_technical, \"date\") values(?, ?, ?, 'now')");
            psmt.setString(1, forumTopic.getName());
            psmt.setInt(2, forumTopic.getUserId());
            psmt.setBoolean(3, forumTopic.is_tehnical());
            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeForumTopic(int id) {

    }

    @Override
    public void updateForumTopic(ForumTopic forumTopic) {

    }

    @Override
    public List<ForumTopic> getForumTopicsListByBlock(boolean isTechnical) {

        try {
            PreparedStatement psmt = con.prepareStatement("select * from forum_topic where is_technical=?");
            psmt.setBoolean(1, isTechnical);
            ResultSet rs = psmt.executeQuery();

            List<ForumTopic> forumTopics = new ArrayList<>();

            while (rs.next()) {
                ForumTopic forumTopic = new ForumTopic(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("user_id"),
                        rs.getBoolean("is_technical"),
                        rs.getTimestamp("date"));
                forumTopics.add(forumTopic);
            }
            return  forumTopics;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ForumTopic getForumTopicById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from forum_topic where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                ForumTopic forumTopic = new ForumTopic(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("user_id"),
                        rs.getBoolean("is_technical"),
                        rs.getTimestamp("date"));
                return  forumTopic;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ForumTopic getForumTopicByName(String name) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from forum_topic where \"name\"=?");
            psmt.setString(1, name);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                ForumTopic forumTopic = new ForumTopic(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("user_id"),
                        rs.getBoolean("is_technical"),
                        rs.getTimestamp("date"));
                return  forumTopic;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
