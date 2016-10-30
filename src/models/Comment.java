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
    public String id;
    public String sender;
    public String text;
    public Timestamp date;


    public Comment(String id, String sender, String text, Timestamp date) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }

}
