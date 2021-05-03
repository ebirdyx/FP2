package com.company.models;

public class Fruit {
    private String name;
    private int index;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Fruit(String name, int index){
        this.name = name;
        this.index = index;


    }
}
