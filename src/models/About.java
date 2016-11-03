package models;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task:
 */
public class About {
    private int id;
    private String text;
    private String phoneNumber;
    private String address;
    private String email;

    public About(String text, String phone_number, String address, String email, int id) {
        this.text = text;
        this.phoneNumber = phone_number;
        this.address = address;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
