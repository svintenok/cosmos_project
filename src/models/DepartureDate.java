package models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */
public class DepartureDate {
    private int id;
    private int tourId;
    private Timestamp date;


    public DepartureDate(int id, int tour_id, Timestamp date) {
        this.id = id;
        this.tourId = tour_id;
        this.date = date;
    }

    public int getTourId() {
        return tourId;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.toLocalDateTime().format(formatter);
    }
}
