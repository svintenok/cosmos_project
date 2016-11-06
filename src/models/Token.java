package models;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class Token {
    private int id;
    private int user_id;
    private String token;

    public Token(int id, int user_id, String token) {
        this.id = id;
        this.user_id = user_id;
        this.token = token;
    }

    public Token() {}

    public Token(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getToken() {
        return token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
