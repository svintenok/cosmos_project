package kfu.group11501.svintenok.models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
public class News {

    public int id;
    public String title;
    public String description;
    public String text;
    public Timestamp date;


    public News(int id, String title, String description, String text, Timestamp date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.description = description;
    }

    public News(String title, String description, String text) {
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDescription() { return description; }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.toLocalDateTime().format(formatter);
    }

    public Timestamp getDateTimestamp() {
        return date;
    }

}
