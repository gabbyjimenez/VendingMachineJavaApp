package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    //Make Item Class
    private Map<String, ItemClass> inventory;

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





    public ItemClass addItemToInventory(String name, ItemClass item) {
        return inventory.put(name, item);
    }


   public List<ItemClass> retrieveItems(){
        //Key entry to list
       //Call when option one is chosen
       return null;
   }





}
