package com.ps.domain;

public class Course {
    private int id;
    private String title;
    private String author;
    private String description;
    private String category;
    private String imageUrl;
    private String lastUpdated;
    private float rating;
    private long numberOfRatings;
    private boolean isBestSeller;
    private int originalPrice;
    private int discountPrice;
    private String level;

    public Course(int id, String title, String author, String description, String category, String imageUrl,
            String lastUpdated, float rating, long numberOfRatings, boolean isBestSeller, int originalPrice,
            int discountPrice, String level) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;
        this.lastUpdated = lastUpdated;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
        this.isBestSeller = isBestSeller;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(long numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}