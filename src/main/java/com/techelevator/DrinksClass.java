package com.techelevator;

public class DrinksClass extends ItemClass{
    public DrinksClass(String slotId, String nameOfItem, double priceOfItem, String itemType) {
        super(slotId, nameOfItem, priceOfItem, itemType);
    }

    public String toString(){
        return "Glug Glug, Yum!";
    }


}
