package com.codegym.model;

public class Product {
    private Integer id;
    private String product_name;
    private Integer price;
    private Integer quantity;
    private String color;
    private String description;
    private Integer categoryId;

    public Product(){

    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Product(int id, String product_name, int price, int quantity, String color, String description, String category_name){
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;

    }

    public Product(String product_name, int price, int quantity, String color, String description, String category_name){
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;

    }

    public Product(String product_name, int price, int quantity, String color, String description){
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
