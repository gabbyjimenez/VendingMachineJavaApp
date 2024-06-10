package com.techelevator;

public abstract class ItemClass {

    private String slotId;
    private String nameOfItem;
    private double priceOfItem;
    private String itemType;
    private int quantityOfItem;

    public ItemClass(String slotId, String nameOfItem, double priceOfItem, String itemType) {
        this.quantityOfItem = 10;
        this.slotId = slotId;
        this.nameOfItem = nameOfItem;
        this.priceOfItem = priceOfItem;
        this.itemType = itemType;
    }

    public void quantityReduction(ItemClass item, int quantity){
            this.quantityOfItem -= quantity;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public String getItemType() {
        return itemType;
    }

    public int getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setQuantityOfItem(int quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }

}
