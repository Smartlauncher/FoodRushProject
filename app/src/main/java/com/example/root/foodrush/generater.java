package com.example.root.foodrush;

import com.google.android.gms.maps.model.LatLng;

public class generater {
    private String name_user;
    private String order;
    private String reward;
    private String location;
    private String Accept;
    private String picture;




    public generater(String s, String name, String was, String name_user, String order, String reward) {
        this.name_user = name_user;
        this.order = order;
        this.reward = reward;
        this.location = location;
        this.picture = picture;
        this.Accept = Accept;
    }

    public String getName_user() {
        return name_user;
    }

    public String getAccept() {
        return Accept;
    }

    public void setAccept(String accept) {
        Accept = accept;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
