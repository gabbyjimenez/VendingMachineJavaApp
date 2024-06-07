package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    //Make Item Class
    private Map<String, ItemClass> inventory;

    private List<ItemClass> inventoryList = new ArrayList<>();
    private FileReader fileReader;


    public Inventory(){
        fileReader = new FileReader();
        try {
            inventory = fileReader.readInventoryFile();

        } catch (FileNotFoundException e) {
            //Move to UI
            System.out.println("Unable to access vending machine items. Come back later.");
        }

    }



   public List<ItemClass> retrieveItems(){
        for(Map.Entry<String, ItemClass> item : inventory.entrySet()){
            inventoryList.add(item.getValue());
        }
       return inventoryList;
   }



}
