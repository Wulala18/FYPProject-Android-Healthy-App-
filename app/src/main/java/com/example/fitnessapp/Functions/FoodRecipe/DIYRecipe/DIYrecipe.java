package com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe;


public class DIYrecipe {




    private String id;

    private String idd;



    private String did;
    private String userID;


    private String titlerecipe;
    private String ingredientsrecipe;
    private String instructionrecipe;
    private String timestamp;


    public DIYrecipe() {

    }


    /*public DIYrecipe(String id, String rname, String ringredients, String rinstructions, Timestamp timestamp, int priority, String UserID) {
        this.id = id;
        this.rname = rname;
        this.ringredients = ringredients;
        this.rinstructions = rinstructions;
        this.priority = priority;
        this.UserID = UserID;
        this.timestamp = timestamp;
    }*/

   /* public DIYrecipe(String idd, String userID, String titlerecipe, String ingredientsrecipe, String instructionrecipe, String timestamp) {
        this.idd = idd;
        this.userID = userID;
        this.titlerecipe = titlerecipe;
        this.ingredientsrecipe = ingredientsrecipe;
        this.instructionrecipe = instructionrecipe;
        this.timestamp = timestamp;
    }*/

    public DIYrecipe(String tempID, String recipe_id, String userID, String recipe_title, String ingredients, String instruction, String time_created) {
        this.did = tempID;
        this.idd = recipe_id;
        this.userID = userID;
        this.titlerecipe = recipe_title;
        this.ingredientsrecipe = ingredients;
        this.instructionrecipe = instruction;
        this.timestamp = time_created;

    }

    public DIYrecipe(String recipe_id, String userID, String recipe_title, String ingredients, String instruction, String time_created) {

        this.idd = recipe_id;
        this.userID = userID;
        this.titlerecipe = recipe_title;
        this.ingredientsrecipe = ingredients;
        this.instructionrecipe = instruction;
        this.timestamp = time_created;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDid() {
        return did;
    }


    public String getIdd() {
        return idd;
    }


    public String getTitlerecipe() {
        return titlerecipe;
    }



    public String getIngredientsrecipe() {
        return ingredientsrecipe;
    }


    public String getInstructionrecipe() {
        return instructionrecipe;
    }



    public String getTimestamp() {
        return timestamp;
    }


}
