package com.techelevator;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    //Make Item Class
    private Map<String, ItemClass> inventory = new TreeMap<>();

    public ItemClass addItemToInventory(String name, ItemClass item) {

        return inventory.put(name, item);
    }











}
