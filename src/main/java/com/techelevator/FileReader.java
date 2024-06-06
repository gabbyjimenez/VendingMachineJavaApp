package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader{

    public Map<String, ItemClass> readInventoryFile() throws FileNotFoundException {

        Map<String, ItemClass> map = new TreeMap<>();
        File inventoryFile = new File("vendingmachine.csv");


        try(Scanner fileScanner = new Scanner(inventoryFile)){
            while (fileScanner.hasNextLine()){

                String listItem = fileScanner.nextLine();
                //System.out.println(listItem);
                //TODO: Put this into the map;
                String[] lineItem = listItem.split("\\|");

                //Instantiate new Item for new line
                for (int i = 0; i < lineItem.length; i++) {
                    if (lineItem[3].equalsIgnoreCase("chip")){
                        ItemClass chips = new ChipsClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        map.put(lineItem[0], chips);
                    }
                    else if (lineItem[3].equalsIgnoreCase("gum")){
                        ItemClass gum = new GumClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        inventory.addItemToInventory(lineItem[1],gum);
                    }
                    else if (lineItem[3].equalsIgnoreCase("candy")){
                        ItemClass candy = new CandyClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        inventory.addItemToInventory(lineItem[1],candy);
                    }
                    else if (lineItem[3].equalsIgnoreCase("drink")){
                        ItemClass drink = new BeveragesClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        inventory.addItemToInventory(lineItem[1],drink);
                    }
                }
//                    if
                //populate based on line read using constructor


            }
            return inventory;
        } catch (Exception e){
            throw new FileNotFoundException();
        }
    }









}
