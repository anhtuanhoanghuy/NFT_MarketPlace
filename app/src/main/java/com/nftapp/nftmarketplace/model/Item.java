package com.nftapp.nftmarketplace.model;

public class Item {
    private int resourceImage;
    private String item_name;
    private String item_price;

    public Item(int resourceImage, String item_name, String item_price) {
        this.resourceImage = resourceImage;
        this.item_name = item_name;
        this.item_price = item_price;
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
}
