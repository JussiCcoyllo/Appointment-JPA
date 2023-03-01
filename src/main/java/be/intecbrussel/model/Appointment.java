package be.intecbrussel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointmentdb")
public class Appointment {
    @Id
    @Column(name = "id")
    public String id;
    public String title;
    public int day;
    public int month;
    public int year;
    public int minute;
    public int hour;

    public Appointment() {

    }

    public Appointment(String id, String title, int day, int month, int year, int minute, int hour) {
        this.id = id;
        this.title = title;
        this.day = day;
        this.month = month;
        this.year = year;
        this.minute = minute;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    public void updateWith(Appointment appointment) {
        this.id = appointment.id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", minute=" + minute +
                ", hour=" + hour +
                '}';
    }
}
