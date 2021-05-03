package com.company.controllers;

import com.company.models.Fruit;
import com.company.models.Store;

import java.util.List;

public class StoreController {
    private Store store;

    public StoreController(Store store) {
        this.store = store;
    }

    public List<Fruit> getFruits() {
        return this.store.getFruits();

    }
}
