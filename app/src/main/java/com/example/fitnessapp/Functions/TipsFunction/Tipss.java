package com.example.fitnessapp.Functions.TipsFunction;

public class Tipss {
    private int id;
    private String title;
    private String description;
    private String imgg;


    public Tipss() {

    }

    public Tipss(int id, String title, String description, String imgg) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgg = imgg;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgg() {
        return imgg;
    }

    public void setImgg(String imgg) {
        this.imgg = imgg;
    }
}