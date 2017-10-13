package com.example.dhruv.sooadproject;

/**
 * Created by DHRUV on 15-09-2017.
 */

public class Item {

    private float price;
    private String name;
    private int food_id;

    public Item(float item_price, String item_name,int image_id)
    {
        price = item_price;
        name = item_name;
        food_id = image_id;
    }

    public float getPrice()
    {
        return price;
    }

    public String getName(){
        return name;
    }

    public int getFood_id(){return food_id;}
}
