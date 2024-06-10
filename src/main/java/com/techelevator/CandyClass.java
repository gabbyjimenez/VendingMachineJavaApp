package com.techelevator;

public class CandyClass extends ItemClass{

    public CandyClass(String slotId, String nameOfItem, double priceOfItem, String itemType) {
        super(slotId, nameOfItem, priceOfItem, itemType);
    }

    public String toString(){
        return "Munch Munch, Yum!";
    }


}
