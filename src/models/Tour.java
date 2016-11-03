package models;

import org.postgresql.util.PGInterval;

import java.sql.Timestamp;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */

public class Tour {
    private String tour;
    private String title;
    private String place;
    private String rocket;
    private String description;
    private Timestamp departureDate;
    private PGInterval interval;
    private int seatsNumber;

    public Tour(String tour, String title, String place, String rocket, String description, Timestamp departure_date, PGInterval interval, int seats_number) {
        this.tour = tour;
        this.title = title;
        this.place = place;
        this.rocket = rocket;
        this.description = description;
        this.departureDate = departure_date;
        this.interval = interval;
        this.seatsNumber = seats_number;
    }

    public String getTour() {
        return tour;
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

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public int getDate() {
        return interval.getMonths();
    }
    public PGInterval getInterval() {
        return interval;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }
}

