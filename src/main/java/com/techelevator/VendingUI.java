package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class VendingUI {



    public void printStartMenu(){

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");


    }

    public void printMenu(){

       Inventory inventory = new Inventory();

        for(Map.Entry<String, ItemClass> item : inventory.getInventory().entrySet()){
            System.out.println("I'm here");
            //System.out.println(item.getValue().getSlotId(), item.getValue().getNameOfItem(), item.getValue().getPriceOfItem(), item.getValue().getQuantityOfItem());
            //System.out.printf("\n%s %5s %5d %5int", );
        }


    }



}
