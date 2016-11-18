package kfu.group11501.svintenok.models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TopicMessage {
    private int id;
    private int forumTopicId;
    private int userId;
    private String text;
    private Timestamp date;

    private User user;

    public TopicMessage(int id, int forum_topic_id, int user_id, String text, Timestamp date) {
        this.id = id;
        this.forumTopicId = forum_topic_id;
        this.userId = user_id;
        this.text = text;
        this.date = date;
    }

    public TopicMessage(int forumTopicId, int userId, String text) {
        this.forumTopicId = forumTopicId;
        this.userId = userId;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
