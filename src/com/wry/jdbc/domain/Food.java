package com.wry.jdbc.domain;

public class Food {
    private int id;
    private String foodname;
    private String foodloc;
    private String detailloc;
    private float foodprice;

    public int getId(){
        return id;
    }
    public void setId(int id){ this.id=id; }

    public String getFoodname(){
        return foodname;
    }
    public void setFoodname(String foodname){
        this.foodname=foodname;
    }

    public String getFoodloc(){
        return foodloc;
    }
    public void setFoodloc(String foodloc){
        this.foodloc=foodloc;
    }

    public String getDetailloc(){
        return detailloc;
    }
    public void setDetailloc(String detailloc){ this.detailloc=detailloc; }

    public float getFoodprice(){
        return foodprice;
    }
    public void setFoodprice(float foodprice){ this.foodprice=foodprice; }
}
