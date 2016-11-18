package kfu.group11501.svintenok.models;

import org.postgresql.util.PGInterval;

import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 18.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Interval{
    private PGInterval interval;

    public Interval(int years, int months) {
        try {
            interval = new PGInterval(years + " years " +
                   months + " mons " + " 0 days 0 hours 0 mins 0.00 secs");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Interval(PGInterval interval) {
        this.interval = interval;
    }

    public PGInterval getInterval() {
        return interval;
    }

    public int getYears() {
        return interval.getYears();
    }
    public int getMonths() {
        return interval.getMonths();
    }

    @Override
    public String toString() {
        String inter = "";
        int years = interval.getYears();
        int months = interval.getMonths();
        if (years != 0) {
            inter += years;
            if (years == 1)
                inter += " год ";
            else if (years % 10 > 3 || years % 10 == 0 || years % 100 == 14)
                inter += " лет ";
            else
                inter += " года ";
        }
        if (months != 0) {
            inter += months;
            if (months == 1)
                inter += " месяц";
            if (months % 10 > 3 || months % 10 == 0|| months % 100 == 14)
                inter += " месяцев";
            else
                inter += " месяца";
        }
        return inter;
    }

}
