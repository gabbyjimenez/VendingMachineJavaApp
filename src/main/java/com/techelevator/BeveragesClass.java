package com.techelevator;

public class BeveragesClass extends ItemClass{
    public BeveragesClass(String slotId, String nameOfItem, double priceOfItem, String itemType) {
        super(slotId, nameOfItem, priceOfItem, itemType);
    }


    public String toString(){
        return "Glug Glug, Yum!";
    }


}
