package com.example.android.ecommerce.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("size")
    @Expose
    private long size;
    @SerializedName("price")
    @Expose
    private long price;

    /**
     * No args constructor for use in serialization
     */
    public Variant() {
    }

    /**
     * @param color
     * @param size
     * @param price
     * @param id
     */
    public Variant(long id, String color, long size, long price) {
        super();
        this.id = id;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
