package com.example.root.foodrush;

public class generater {
    private String name_user;
    private String order;
    private String reward;
    private String location;
    private boolean Accept;
    private int picture;




    public generater(int picture, String location, String name_user, String order, String reward) {
        this.name_user = name_user;
        this.order = order;
        this.reward = reward;
        this.location = location;
        this.picture = picture;

    }

    public String getName_user() {
        return name_user;
    }

    public boolean getAccept() {
        return Accept;
    }

    public void setAccept(boolean accept) {
        Accept = accept;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
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
