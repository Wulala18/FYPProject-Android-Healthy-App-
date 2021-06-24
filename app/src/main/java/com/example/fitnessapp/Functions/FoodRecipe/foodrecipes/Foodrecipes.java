package com.example.fitnessapp.Functions.FoodRecipe.foodrecipes;

public class Foodrecipes {

    private int id;
    private String name;
    private String calories;
    private String protein;
    private String sugar;
    private String fat;
    private String ingredients ;
    private String instructions;
    private String imgg;


    public Foodrecipes()
    {

    }

    public Foodrecipes(int id, String name, String calories, String protein, String sugar, String fat, String ingredients, String instructions,String imgg) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.sugar = sugar;
        this.fat = fat;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imgg = imgg;


    }


    public String getImgg() {
        return imgg;
    }

    public void setImgg(String imgg) {
        this.imgg = imgg;
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

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
