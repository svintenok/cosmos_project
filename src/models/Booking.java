package models;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Booking {
    private int id;
    private int userId;
    private int departureDateId;

    private DepartureDate departureDate;
    private Recall recall;


    public Booking(int id, int user_id, int departure_date_id) {
        this.id = id;
        this.userId = user_id;
        this.departureDateId = departure_date_id;
    }

    public Booking(int userId, int departureDateId) {
        this.userId = userId;
        this.departureDateId = departureDateId;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public int getDepartureDateId() {
        return departureDateId;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

    public Recall getRecall() {
        return recall;
    }

    public void setRecall(Recall recall) {
        this.recall = recall;
    }
}
