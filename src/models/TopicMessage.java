package models;

import java.sql.Timestamp;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */
public class TopicMessage {
    private int id;
    private int forumTopicId;
    private int userId;
    private String text;
    private Timestamp date;

    public TopicMessage(int id, int forum_topic_id, int user_id, String text, Timestamp date) {
        this.id = id;
        this.forumTopicId = forum_topic_id;
        this.userId = user_id;
        this.text = text;
        this.date = date;
    }


    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public int getForumTopicId() {
        return forumTopicId;
    }


}
