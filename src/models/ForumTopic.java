package models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class ForumTopic {
    private int id;
    private String name;
    private int userId;
    private boolean isTechnical;
    private Timestamp date;

    private int messagesCount;
    private TopicMessage lastMessage;
    private List<TopicMessage> messages;
    private int pagesCount;

    public ForumTopic(int id, String name, int user_id, boolean is_tehnical, Timestamp date) {
        this.id = id;
        this.name = name;
        this.userId = user_id;
        this.isTechnical = is_tehnical;
        this.date = date;
    }

    public ForumTopic(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public boolean is_tehnical() {
        return isTechnical;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }

    public void setTechnical(boolean technical) {
        isTechnical = technical;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public TopicMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(TopicMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public List<TopicMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<TopicMessage> topicMessages) {
        this.messages = topicMessages;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
}
