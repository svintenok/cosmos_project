package models;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 07.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Recall {
    private int id;
    private int estimate;
    private String text;
    private int userId;
    private int departureDataId;
    private Timestamp date;

    private User user;

    public Recall(int id, int estimate, String text, int userId, int departureDataId, Timestamp date) {
        this.id = id;
        this.estimate = estimate;
        this.text = text;
        this.userId = userId;
        this.departureDataId = departureDataId;
        this.date = date;
    }

    public Recall(int estimate, String text, int userId, int departureDataId) {
        this.estimate = estimate;
        this.text = text;
        this.userId = userId;
        this.departureDataId = departureDataId;
    }

    public int getId() {
        return id;
    }

    public int getEstimate() {
        return estimate;
    }

    public String getText() {
        return text;
    }

    public int getUserId() {
        return userId;
    }

    public int getDepartureDataId() {
        return departureDataId;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.toLocalDateTime().format(formatter);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
