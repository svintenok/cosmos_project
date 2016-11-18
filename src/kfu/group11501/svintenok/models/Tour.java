package kfu.group11501.svintenok.models;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */

public class Tour {
    private int id;
    private String title;
    private String place;
    private String rocket;
    private String description;
    private int departureDateId;
    private Interval interval;
    private int seatsNumber;
    private int cost;

    private DepartureDate departureDate;
    private int bookingCount;
    private double rating;
    private List<Recall> recallList;

    public Tour(int id, String title, String place, String rocket, String description, int departureDateId, Interval interval, int seatsNumber, int cost) {
        this.id = id;
        this.title = title;
        this.place = place;
        this.rocket = rocket;
        this.description = description;
        this.departureDateId = departureDateId;
        this.interval = interval;
        this.seatsNumber = seatsNumber;
        this.cost= cost;
    }

    public Tour(String title, String place, String rocket, String description, Interval interval, int seatsNumber, int cost) {
        this.title = title;
        this.place = place;
        this.rocket = rocket;
        this.description = description;
        this.interval = interval;
        this.seatsNumber = seatsNumber;
        this.cost = cost;
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

    public Interval getInterval() {
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

    public int getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(int bookingCount) {
        this.bookingCount = bookingCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Recall> getRecallList() {
        return recallList;
    }

    public void setRecallList(List<Recall> recallList) {
        this.recallList = recallList;
    }
}

