package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    // CLASS VARIABLES
    private double totalBalance = 0.00;
    //CONSTRUCTOR
    public CashRegister(){};
    //METHODS

    public double addToBalance(String insertedMoney) {
        //REMOVE PARSING
        int fundsAddedInt = Integer.parseInt(insertedMoney);
        if (fundsAddedInt > 0 && fundsAddedInt <= 10) {
            totalBalance += (double) fundsAddedInt;
        }
        return totalBalance;
    }

    public double makePurchase(double itemPrice) {
        //REMOVE PARSING
       if (itemPrice <= totalBalance){
           totalBalance -= itemPrice;
       }
        return totalBalance;
    }

    //GETTER

    public double getTotalBalance() {
        return totalBalance;
    }
    public String makeChange(){
        String change = "";
        int totalQuarters = 0;
        int totalDimes = 0;
        int totalNickles = 0;
        int totalInPennies = (int)(totalBalance * 100);
        while(totalInPennies>0){
            if (totalInPennies % 25 == 0) {
                change += " quarter ";
                totalQuarters += 1;
                totalInPennies -= 25;
            }


            if (totalInPennies % 10 == 0) {
                change += " dime ";

                totalDimes += 1;
                totalInPennies -= 10;

            }
            if (totalInPennies % 5 == 0) {
                change += " nickle ";
                totalNickles += 1;
                totalInPennies -= 5;


            }



        }
        totalBalance = 0;
        return "Your change is: "  + String.valueOf(totalQuarters ) + " quarters " + String.valueOf(totalDimes ) + " dimes " + String.valueOf(totalNickles ) + " nickles ";
    }


}
