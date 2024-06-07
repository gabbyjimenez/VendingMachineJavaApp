package com.techelevator;

import java.util.Scanner;

public class PurchaseMenu {
    //CLASS VARIABLES
    CashRegister register = new CashRegister();
    VendingUI vendingUI = new VendingUI();

    //CONSTRUCTOR
    public PurchaseMenu(){

    }
    public void addFunds(String fundsAdded){

        int fundsAddedInt = Integer.parseInt(fundsAdded);
        if(fundsAddedInt > 0 && fundsAddedInt <= 10){
            register.addToBalance(fundsAddedInt);
        }
    }

    //METHOD

    public void makePurchase(String itemSlotId){
        itemSlotId = vendingUI.getItemToPurchase();

    }


    //GETTER


}
