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
    private String password;
    private String email;
    private String name;
    private String country;
    private boolean photo;
    private int roleId;
    private Role role;

    public User(int id, String login, String password, String email, String name, String country, boolean photo, int roleId) {
        this.id = id;
        this.login = login.toLowerCase();
        this.password = password;
        this.email = email;
        this.name = name;
        this.country = country;
        this.photo = photo;
        this.roleId = roleId;
    }

    public User(String login, String password, String email, String name, String country, boolean photo) {
        this.login = login.toLowerCase();
        this.password = password;
        this.email = email;
        this.name = name;
        this.country = country;
        this.photo = photo;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
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

    public boolean getPhoto() {
        return photo;
    }

    public int getRoleId() {
        return roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
