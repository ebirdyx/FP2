package com.company.views;

import com.company.controllers.StoreController;
import com.company.models.Fruit;

import java.util.List;
import java.util.Scanner;

public class Console {

    private StoreController storeController;

//    public Console(StoreController storeController1){
//        this.storeController = storeController1;
//    }

    public Console() {

    }

    public void addFruit(){
        String name = getUserInput("Enter fruit name: ");
        System.out.println("Fruit "+ name + " successfully added.");
        displayMenu();
    }

    public void  listFruit(){
        List<Fruit> fruits = this.storeController.getFruits();

        for (int i = 0; i< fruits.size(); i++){
            System.out.println(fruits.get(i));
        }
    }

    public  void removeFruit(){

    }

    public void findFruit(){

    }

    public void displayMenu() {
        System.out.println();
        System.out.println("1. Add fruit");
        System.out.println("2. List fruits");
        System.out.println("3. Remove fruit");
        System.out.println("4. Find fruit ");

        switch (getUserInput("Choose option: ")) {
            case "1":
                addFruit();
                break;
            case "2":
                listFruit();
                break;
            case "3":
                removeFruit();
                break;
            case "4":
               findFruit();
                break;
            default:
                System.out.println("Invalid input.");

        }
    }
    public String getUserInput(String msg) {
        System.out.print(msg);

        Scanner scanner = new Scanner(System.in);
        String UserInput = scanner.nextLine();
        return UserInput;

    }

    public void run(){
        displayMenu();
    }
}

