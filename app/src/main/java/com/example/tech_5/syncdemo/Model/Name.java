package com.example.tech_5.syncdemo.Model;

public class Name {

    private String name;
    private String mobileno;
    private String emailid;
    private String city;
    private int status;

    public Name(String name, String mobileno, String emailid, String city, int status) {
        this.name = name;
        this.mobileno = mobileno;
        this.emailid = emailid;
        this.city = city;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getCity() {
        return city;
    }

    public int getStatus() {
        return status;
    }
}
