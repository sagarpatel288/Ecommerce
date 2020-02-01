package com.example.android.ecommerce.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("child_categories")
    @Expose
    private List<Object> childCategories = null;

    /**
     * No args constructor for use in serialization
     */
    public Category() {
    }

    /**
     * @param name
     * @param childCategories
     * @param id
     * @param products
     */
    public Category(long id, String name, List<Product> products, List<Object> childCategories) {
        super();
        this.id = id;
        this.name = name;
        this.products = products;
        this.childCategories = childCategories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Object> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Object> childCategories) {
        this.childCategories = childCategories;
    }
}


