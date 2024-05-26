package com.fatec.trabalhoPOO.model;

public class Produto {
    private String name;
    private String description;
    private double price;
    private Integer categoryId;

    public Produto() {}

    public Produto(String name, String description, double price, Integer categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Integer getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(Integer categoryId){
        this.categoryId = categoryId;
    }
}
