package kfu.group11501.svintenok.models;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Token {
    private int id;
    private int userId;
    private String token;

    public Token(int id, int userId, String token) {
        this.id = id;
        this.userId = userId;
        this.token = token;
    }

    public Token(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

}
