package com.example.root.foodrush;

public class generater {
    private String name_user;
    private String order;
    private String reward;
    private String location;
    private String dringend;
    private String zeitraum;
    private boolean Accept;
    private String picture;




    public generater(String picture, String location, String name_user, String order, String reward, String zeitraum, String dringend) {
        this.name_user = name_user;
        this.order = order;
        this.reward = reward;
        this.location = location;
        this.picture = picture;
        this.zeitraum = zeitraum;
        this.dringend = dringend;

    }

    public String getDringend() {
        return dringend;
    }

    public void setDringend(String dringend) {
        this.dringend = dringend;
    }

    public String getZeitraum() {
        return zeitraum;
    }

    public void setZeitraum(String zeitraum) {
        this.zeitraum = zeitraum;
    }

    public boolean isAccept() {
        return Accept;
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
