package com.techelevator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingUI {

    public void printStartMenu(){

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

    }

    public void printMenu(Inventory inventory){
        for(ItemClass i : inventory.retrieveItems()){
            System.out.printf("\n %s %s %.2f %d",i.getSlotId(), i.getNameOfItem(), i.getPriceOfItem(), i.getQuantityOfItem());
        }

    }

}
