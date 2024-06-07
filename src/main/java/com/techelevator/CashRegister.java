package com.techelevator;

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

}
