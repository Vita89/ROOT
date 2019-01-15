package entities;

import java.sql.Date;

public class Discipline {
    private int id;
    private String name;
    private int status;
    private Date dateDelete;


    public Discipline() {

    }

    public Discipline(int id, String name, int status, Date dateDelete) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dateDelete = dateDelete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setDateDelete(Date dateDelete) {
        this.dateDelete = dateDelete;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", dateDelete=" + dateDelete +
                '}';
    }
}
