package com.nftapp.nftmarketplace.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private String nameCategory;
    private List<Item> items;

    public Category(String nameCategory, List<Item> items) {
        this.nameCategory = nameCategory;
        this.items = items;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
