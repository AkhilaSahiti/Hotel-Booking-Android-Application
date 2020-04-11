package com.example.miniproject.models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String email;
    private String room_type;
    private long phone;
    private int stay_days;
    private int pin;

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getRoom_type() {
        return room_type;
    }

    public int getStay_days() {
        return stay_days;
    }
    public int getPin() {
        return pin;
    }

    public void setName(String name) {
        this.name = name;
    }
    public long setPhone(long phone) {
        this.phone = phone;
        return phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int setStay_days(int stay_days) {
        this.stay_days = stay_days;
        return stay_days;
    }
    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }
}
