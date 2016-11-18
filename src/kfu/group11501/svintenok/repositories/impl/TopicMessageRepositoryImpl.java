package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.TopicMessage;
import kfu.group11501.svintenok.repositories.TopicMessageRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TopicMessageRepositoryImpl implements TopicMessageRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addTopicMessage(TopicMessage topicMessage) {
        try {

            PreparedStatement psmt = con.prepareStatement("INSERT into message(user_id, forum_topic_id, text, date) values(?, ?, ?, 'now')");
            psmt.setInt(1, topicMessage.getUserId());
            psmt.setInt(2, topicMessage.getForumTopicId());
            psmt.setString(3, topicMessage.getText());
            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTopicMessage(int id) {
        try {

            PreparedStatement psmt = con.prepareStatement("delete from message where id=?");
            psmt.setInt(1, id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTopicMessage(TopicMessage topicMessage) {

    }

    @Override
    public List<TopicMessage> getTopicMessagesListByTopic(int topicId, int page, int limit) {

        try {
            PreparedStatement psmt = con.prepareStatement("select * from message where forum_topic_id=? order by \"date\" limit " + limit + " offset " + (page-1)*limit);
            psmt.setInt(1, topicId);
            ResultSet rs = psmt.executeQuery();
            List<TopicMessage> messages = new ArrayList<>();

            while (rs.next()) {
                TopicMessage message= new TopicMessage(
                        rs.getInt("id"),
                        rs.getInt("forum_topic_id"),
                        rs.getInt("user_id"),
                        rs.getString("text"),
                        rs.getTimestamp("date"));
                messages.add(message);
            }

            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TopicMessage getTopicMessageById(int id) {
        return null;
    }

    @Override
    public int getMessagesCountByTopic(int topicId) {

        try {
            PreparedStatement psmt = con.prepareStatement("select count(*) messages_count from message where forum_topic_id=?");
            psmt.setInt(1, topicId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next())
                return rs.getInt("messages_count");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public TopicMessage getLastTopicMessage(int topicId) {

        try {
            PreparedStatement psmt = con.prepareStatement("select * from message m1 " +
                    "where m1.forum_topic_id=? and \"date\" = (select max(\"date\") from message m2 where m1.forum_topic_id=m2.forum_topic_id) ");
            psmt.setInt(1, topicId);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                TopicMessage message = new TopicMessage(
                        rs.getInt("id"),
                        rs.getInt("forum_topic_id"),
                        rs.getInt("user_id"),
                        rs.getString("text"),
                        rs.getTimestamp("date"));
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
