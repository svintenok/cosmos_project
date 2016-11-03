package models;

/**
 * Author: Svintenok Kate
 * Date: 31.10.2016
 * Group: 11-501
 * Task: semester project
 */
public class User {
    private int id;
    private String login;
    private String name;
    private String email;
    private String country;
    private boolean photo;
    private int roleId;

    public User(int id, String login, String name, String email, String country, boolean photo, int role_id) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
        this.country = country;
        this.photo = photo;
        this.roleId = role_id;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public boolean isPhoto() {
        return photo;
    }

    public int getRoleId() {
        return roleId;
    }
}
