package entities;

import java.sql.Date;

public class Term {
    private int id;
    private String name;
    private String duration;
    private int status;
    private Date dateDelete;

    public Term() {

    }

    private Term(int id, String name, String duration, int status, Date dateDelete) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.status = status;
        this.dateDelete = dateDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(Date dateDelete) {
        this.dateDelete = dateDelete;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", dateDelete=" + dateDelete +
                '}';
    }
}
