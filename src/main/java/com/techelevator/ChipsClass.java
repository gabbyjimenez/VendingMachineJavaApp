package com.techelevator;

public class ChipsClass extends ItemClass{
    //Super

    public ChipsClass(String slotId, String nameOfItem, double priceOfItem, String itemType) {
        super(slotId, nameOfItem, priceOfItem, itemType);
    }

    @Override
    public String toString() {
        return "Crunch Crunch, Yum!";
    }
}
