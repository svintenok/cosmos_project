package models;


import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: ${DATE}
 * Group: 11-501
 * Task:
 */
public class Comment {
    private int id;
    private int userId;
    private String text;
    public Timestamp date;


    public Comment(int id, int userId, String text, Timestamp date) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }

}