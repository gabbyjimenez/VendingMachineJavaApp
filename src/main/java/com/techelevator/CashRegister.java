package com.techelevator;

public class CashRegister {
    // CLASS VARIABLES
    private double totalBalance = 0.00;
    //CONSTRUCTOR
    public CashRegister(){};
    //METHODS
    public double addToBalance(int insertedMoney){
        //REMOVE PARSING

            return totalBalance += insertedMoney;

    }

    //GETTER

    public double getTotalBalance() {
        return totalBalance;
    }
}
