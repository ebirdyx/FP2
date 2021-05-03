package com.company.models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    public Fruit addFruit(String name) {

        Fruit fruit = new Fruit(name);
        fruits.add(fruit);

        return fruit;
    }

    public Fruit findFruit(String name) {
        for (int i = 0; 1 < fruits.size(); i++) {
            if (fruits.get(i).getName().equals(name))
                return fruits.get(i);
        }
        return null;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

}


