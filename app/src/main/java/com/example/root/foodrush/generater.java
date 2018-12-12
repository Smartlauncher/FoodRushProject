package com.example.root.foodrush;

import com.google.android.gms.maps.model.LatLng;

public class generater {
    private String name_user;
    private String order;
    private String reward;
    private LatLng location;



    public generater(String name_user, String order, String reward) {
        this.name_user = name_user;
        this.order = order;
        this.reward = reward;
        this.location = location;
    }

    public String getName_user() {
        return name_user;
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

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
