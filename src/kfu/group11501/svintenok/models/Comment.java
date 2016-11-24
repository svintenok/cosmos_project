package kfu.group11501.svintenok.models;


import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Comment {
    private int id;
    private int userId;
    private int newsId;
    private String text;
    private Timestamp date;
    private User user;

    public Comment(int id, int newsId, String text, Timestamp date, User user) {
        this.id = id;
        this.newsId = newsId;
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public Comment(int userId, int newsId, String text) {
        this.userId = userId;
        this.newsId = newsId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }

    public User getUser() {
        return user;
    }
}
