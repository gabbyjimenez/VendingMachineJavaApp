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

    public void printItems(List<ItemClass> inventoryList){
        for(ItemClass i : inventoryList){

            if(i.getQuantityOfItem() <= 0){
                System.out.printf("\n %s %-20s %.2f %s",i.getSlotId(), i.getNameOfItem(), i.getPriceOfItem(), "SOLD OUT");
            }
            else {
                System.out.printf("\n %s %-20s %.2f %d", i.getSlotId(), i.getNameOfItem(), i.getPriceOfItem(), i.getQuantityOfItem());
            }
        }
        System.out.println("\n");



    }

    public void printItemMessage(ItemClass item){
        System.out.println(item.toString());



    }

    public void insufficientFundsMessage(){
        System.out.println("Insufficient balance. Please insert more money.");
        System.out.println("\n");
    }

    public void inventoryOutOfStockMessage(){
        System.out.println("This item is out of stock. Please choose a different item.");
        System.out.println("\n");
    }
//    public void printBalance(double balance){
//
////        System.out.println("Current balance: $" + balance);
//
//    }
    public void invalidSlotAndQuantityMessage(){
        System.out.println("Please enter a valid item slot and quantity.");
        System.out.println("\n");
    }

    public String getItemToPurchase(){

        System.out.println("Please enter an item number, and the quantity, separated by a space.");
        String itemToPurchase = myScanner.nextLine();
        return itemToPurchase;


    }

    public String printPurchaseMenu(double balance){
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: " + balance);


        return myScanner.nextLine();



    }

    public String printMoneyInsertionMenu(){
        System.out.println("Please insert up to 10 dollars. Whole dollars only.");
        return myScanner.nextLine();
    }
    public void printChange(String change){
        System.out.println(change);
    }
}
