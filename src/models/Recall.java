package models;

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

    public Recall(int id, int estimate, String text, int userId, int departureDataId) {
        this.id = id;
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
}
