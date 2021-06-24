package com.example.fitnessapp.Functions.FoodRecipe.FoodNutrtionSearch;


public class Food {

    private int id;
    private String name;
    private String calories;
    private String protein;
    private String sugar;
    private String fat;
    private String cabor;



    public Food(int id, String name, String calories, String protein, String sugar,String fat,String cabor) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.sugar = sugar;
        this.fat = fat;
        this.cabor = cabor;
    }

    public Food() {

    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCabor() {
        return cabor;
    }

    public void setCabor(String cabor) {
        this.cabor = cabor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }


    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }


}
