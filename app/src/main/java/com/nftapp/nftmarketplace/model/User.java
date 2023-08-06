package com.nftapp.nftmarketplace.model;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;
    private int user_avatar;
    private int user_background;
    private String user_name;
    private String address;
    private String privateKey;
    private Float balance;
    private String email;
    private String phoneNumber;
    private String password;
    private String bio;

    public User(int user_id, int user_avatar,
                int user_background, String user_name,
                String address, String privateKey,
                Float balance, String email,
                String phoneNumber, String password,
                String bio) {
        this.user_id = user_id;
        this.user_avatar = user_avatar;
        this.user_background = user_background;
        this.user_name = user_name;
        this.address = address;
        this.privateKey = privateKey;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.bio = bio;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(int user_avatar) {
        this.user_avatar = user_avatar;
    }

    public int getUser_background() {
        return user_background;
    }

    public void setUser_background(int user_background) {
        this.user_background = user_background;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
