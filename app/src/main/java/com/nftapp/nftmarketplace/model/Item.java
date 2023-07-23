package com.nftapp.nftmarketplace.model;

import java.io.Serializable;

public class Item implements Serializable {
    public int resourceImage;
    public String item_name;
    public String item_price;
    public String author;

    public Item(int resourceImage, String item_name, String item_price, String author) {
        this.resourceImage = resourceImage;
        this.item_name = item_name;
        this.item_price = item_price;
        this.author = author;
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

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
