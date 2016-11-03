package models;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task:
 */
public class News {

    public long id;
    public String title;
    public String description;
    public String text;
    public Timestamp date;


    public News(long id, String title, String description, String text, Timestamp date) {
        this.id = id;
        this.title = title;

        this.text = text;
        this.date = date;
        this.description = description;
    }

    public long getId() {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.toLocalDateTime().format(formatter);
    }

}
