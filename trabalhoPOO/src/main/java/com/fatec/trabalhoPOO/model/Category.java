package com.fatec.trabalhoPOO.model;

public class Category {
    private Integer id;
    private String name;

    public Category() {}
    
    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
