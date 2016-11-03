package models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */
public class ForumTopic {
    private int id;
    private String name;
    private int userId;
    private boolean isTechnical;
    private Timestamp date;

    public ForumTopic(int id, String name, int user_id, boolean is_tehnical, Timestamp date) {
        this.id = id;
        this.name = name;
        this.userId = user_id;
        this.isTechnical = is_tehnical;
        this.date = date;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }
}
