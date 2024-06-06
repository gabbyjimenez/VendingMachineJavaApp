package com.techelevator;

public class CashRegister {
    // CLASS VARIABLES
    private double totalBalance = 0.00;
    //CONSTRUCTOR
    public CashRegister(){};
    //METHODS
    public double addFunds(String insertedMoney){

        int insertedMoneyAsInteger = Integer.parseInt(insertedMoney);
        if(insertedMoneyAsInteger > 0){
            return totalBalance += insertedMoneyAsInteger;
        }

        return totalBalance;
    }

    //GETTER

    public double getTotalBalance() {
        return totalBalance;
    }
}
