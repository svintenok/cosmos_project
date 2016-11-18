package kfu.group11501.svintenok.models;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CompanyInfo {
    private String text;
    private String phone;
    private String address;
    private String email;

    public CompanyInfo(String text, String phone, String address, String email) {
        this.text = text;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
