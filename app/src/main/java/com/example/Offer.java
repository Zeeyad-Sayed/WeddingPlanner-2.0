package com.example;

public class Offer {
    private int id;
    private String place;
    private String foodType;
    private String details;

    public Offer(String place, String foodType, String details) {
        //this.id = id;
        this.place = place;
        this.foodType = foodType;
        this.details = details;
    }

    public Offer(int id, String place, String foodType, String details) {
        this.id = id;
        this.place = place;
        this.foodType = foodType;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return place;
    }

    public void setId(int id) {
        this.id = id;
    }
}
