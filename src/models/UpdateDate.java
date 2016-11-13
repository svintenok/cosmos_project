package models;

import java.sql.Timestamp;

/**
 * Author: Svintenok Kate
 * Date: 13.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class UpdateDate {
    private Timestamp date;

    public UpdateDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getDate() {
        return date;
    }
}
