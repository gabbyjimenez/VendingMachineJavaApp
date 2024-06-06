package com.techelevator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingUI {

    private Scanner myScanner = new Scanner(System.in);
    public String printStartMenu(){

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        return myScanner.nextLine();
    }

    public void printMenu(Inventory inventory){
        for(ItemClass i : inventory.retrieveItems()){
            System.out.printf("\n %s %s %.2f %d",i.getSlotId(), i.getNameOfItem(), i.getPriceOfItem(), i.getQuantityOfItem());

        }
        System.out.println("\n");



    }

    public String getItemToPurchase(){
         String itemSlotId = myScanner.nextLine();
         return itemSlotId;

    }

    public String printPurchaseMenu(){
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();


        return myScanner.nextLine();



    }

}
