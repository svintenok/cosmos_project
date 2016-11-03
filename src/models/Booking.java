package models;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */
public class Booking {
    private int id;
    private int userId;
    private int departureDateId;


    public Booking(int id, int user_id, int departure_date_id) {
        this.id = id;
        this.userId = user_id;
        this.departureDateId = departure_date_id;
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





}
