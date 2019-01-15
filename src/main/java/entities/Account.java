package entities;

import java.sql.Date;

public class Account {
    private int id;
    private String login;
    private String password;
    private Date date;

    public Account() {

    }

    public Account(int id, String login, String password, Date date) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.date = date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLogin(String id) {
        this.login = login;
    }

    public String getLogin(String login) {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(String password) {
        return password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
