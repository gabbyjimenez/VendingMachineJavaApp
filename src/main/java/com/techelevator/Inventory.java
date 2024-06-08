package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        }
    }


   public List<ItemClass> retrieveItems(){
       List<ItemClass> inventoryList = new ArrayList<>();

        for(Map.Entry<String, ItemClass> item : inventory.entrySet()){
            inventoryList.add(item.getValue());

        }
       return inventoryList;
   }


}
