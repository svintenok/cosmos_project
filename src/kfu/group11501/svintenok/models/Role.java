package kfu.group11501.svintenok.models;

/**
 * Author: Svintenok Kate
 * Date: 31.10.2016
 * Group: 11-501
 * Task: semester project
 */
public class Role {
    private int id;
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
