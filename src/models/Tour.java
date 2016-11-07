package models;

import org.postgresql.util.PGInterval;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */

public class Tour {
    private int id;
    private String title;
    private String place;
    private String rocket;
    private String description;
    private int departureDateId;
    private PGInterval interval;
    private int seatsNumber;
    private int cost;
    private DepartureDate departureDate;

    public Tour(int id, String title, String place, String rocket, String description, int departureDateId, Object interval, int seatsNumber, int cost) {
        this.id = id;
        this.title = title;
        this.place = place;
        this.rocket = rocket;
        this.description = description;
        this.departureDateId = departureDateId;
        this.interval = (PGInterval) interval;
        this.seatsNumber = seatsNumber;
        this.cost= cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    public String getRocket() {
        return rocket;
    }

    public String getDescription() {
        return description;
    }

    public int getDepartureDateId() { return departureDateId; }

    public PGInterval getInterval() {
        return interval;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public int getCost() { return cost; }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }
}

