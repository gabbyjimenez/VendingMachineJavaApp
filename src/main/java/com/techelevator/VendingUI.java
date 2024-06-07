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

    public void printMenu(List<ItemClass> inventoryList){
        for(ItemClass i : inventoryList){
            System.out.printf("\n %s %s %.2f %d",i.getSlotId(), i.getNameOfItem(), i.getPriceOfItem(), i.getQuantityOfItem());

        }
        System.out.println("\n");



    }

    public void printBalance(double balance){

        System.out.println("Current balance: $" + balance);
    }

    public String getItemToPurchase(){

        System.out.println("Please enter an item number, and the quantity, separated by a space.");
        String itemToPurchase = myScanner.nextLine();
        return itemToPurchase;


    }

    public String printPurchaseMenu(){
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();


        return myScanner.nextLine();



    }

    public String printMoneyInsertionMenu(){
        System.out.println("Please insert up to 10 dollars. Whole dollars only.");
        return myScanner.nextLine();
    }
}
