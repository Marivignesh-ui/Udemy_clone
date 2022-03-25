package com.ps.domain;

import java.util.Arrays;
import java.util.UUID;

public class User{
    private String id;
    private String firstname;
    private String lastname;
    private String password;
    private String avatarUrl;
    private String email;
    private String mobilenumber;
    private String[] interests;
    private String[] courses;
    private String[] favorites;
    private String[] cart;
    private boolean status;
    private String createdDate;
    private String lastLoginDate;
    
    public User(String firstname, String lastname, String password, String avatarUrl, String email,
            String mobilenumber, String[] interests, String[] courses, String[] favorites, String[] cart,
            boolean status, String createdDate, String lastLoginDate) {
        UUID id=UUID.randomUUID();
        this.id = id.toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.interests = interests;
        this.courses = courses;
        this.favorites = favorites;
        this.cart = cart;
        this.status = status;
        this.createdDate = createdDate;
        this.lastLoginDate = lastLoginDate;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public String[] getCart() {
        return cart;
    }

    public void setCart(String[] cart) {
        this.cart = cart;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User [avatarUrl=" + avatarUrl + ", cart=" + Arrays.toString(cart) + ", courses="
                + Arrays.toString(courses) + ", createdDate=" + createdDate + ", email=" + email + ", favorites="
                + Arrays.toString(favorites) + ", firstname=" + firstname + ", id=" + id + ", interests="
                + Arrays.toString(interests) + ", lastLoginDate=" + lastLoginDate + ", lastname=" + lastname
                + ", mobilenumber=" + mobilenumber + ", password=" + password + ", status=" + status + "]";
    }
    
}