package com.example.dhruv.sooadproject;

/**
 * Created by DHRUV on 02-10-2017.
 */

public class Cart {

    private int id;
    private String name;
    private String qty;
    private String price;

    public Cart(int item_id, String item_name, String item_qty, String item_price) {
        id = item_id;
        name = item_name;
        qty = item_qty;
        price = item_price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }

}
