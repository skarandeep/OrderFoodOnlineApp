package com.example.orderfoodonlineapp.Domains;
public class FoodDomain {
    private String title, image, description;
    private Double fee;
    private int stars, time, calories;
    private int numberInCart;

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
//generating setters and getters as all variables are set as private and will need to be accessed from other classes / methods
    //followed by generating constructors for each


    public FoodDomain(String title, String image, String description, Double fee, int stars, int time, int calories) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.fee = fee;

        this.stars = stars;
        this.time = time;
        this.calories = calories;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
