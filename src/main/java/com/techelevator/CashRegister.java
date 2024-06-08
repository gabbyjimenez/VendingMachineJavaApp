package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CashRegister {
    // CLASS VARIABLES
    private double totalBalance = 0.00;

    //CONSTRUCTOR
    public CashRegister(){};
    //METHODS

    public double addToBalance(String insertedMoney) throws InvalidInputException{
        //REMOVE PARSING
        try {
            int fundsAddedInt = Integer.parseInt(insertedMoney);
            if (fundsAddedInt > 0 && fundsAddedInt <= 10) {
               totalBalance += (double) fundsAddedInt;
            }
            return totalBalance;
        } catch (Exception e) {
            throw new InvalidInputException();
        }

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
        int totalNickels = 0;
        int totalInPennies = (int)(totalBalance * 100);

            totalQuarters = totalInPennies/25;
            totalInPennies = totalInPennies % 25;
            totalDimes = totalInPennies / 10;
            totalInPennies = totalInPennies % 10;
            totalNickels = totalInPennies / 5;

            totalBalance = 0;

            return "Your change is: "  + String.valueOf(totalQuarters) + " Quarters, " + String.valueOf(totalDimes) + " Dimes, " + String.valueOf(totalNickels) + " Nickels.";
    }

    public String addFundsLog(String amount) throws InvalidInputException{

        double fundsAdded = Double.parseDouble(amount);


        return "FEED MONEY: $" + toString(fundsAdded) + " $" + toString(totalBalance);

    }
    public String addChangeToLog(double amount){

        double changeGiven = amount;


        return "GIVE CHANGE: $" + toString(changeGiven) + " $" + toString(totalBalance - changeGiven);

    }
    public String addPurchaseToLog(String name,String slotId,double price){


            return name + " " +  slotId.toUpperCase() + " " + " $" + toString(price) + " $" + toString(totalBalance);

    }
    public String toString(Double doubleNum){
        String formattedNumber = String.format("%.2f",doubleNum);
        return formattedNumber;
    }


}
