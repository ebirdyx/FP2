package com.company;

import com.company.models.Store;
import com.company.views.Console;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Console console = new Console();

        console.run();
    }
}

