package com.nftapp.nftmarketplace.model;

import java.io.Serializable;

public class Item implements Serializable {
    public int resourceImage;
    public String item_name;
    public float item_price;
    public String item_username;
    public String item_status;
    public String item_date_end;

    public Item(int resourceImage, String item_name,
                float item_price, String item_username,
                String item_status, String item_date_end) {
        this.resourceImage = resourceImage;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_username = item_username;
        this.item_status = item_status;
        this.item_date_end = item_date_end;
    }


    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }


    public String getItem_username() {
        return item_username;
    }

    public void setItem_username(String item_username) {
        this.item_username = item_username;
    }

    public String getItem_status() {
        return item_status;
    }

    public void setItem_status(String item_status) {
        this.item_status = item_status;
    }

    public String getItem_date_end() {
        return item_date_end;
    }

    public void setItem_date_end(String item_date_end) {
        this.item_date_end = item_date_end;
    }

}
