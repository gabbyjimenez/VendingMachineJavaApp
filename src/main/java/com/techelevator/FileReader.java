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
                        ItemClass chip = new ChipsClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        map.put(lineItem[0], chip);
                    }
                    else if (lineItem[3].equalsIgnoreCase("gum")){
                        ItemClass gum = new GumClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        map.put(lineItem[0],gum);
                    }
                    else if (lineItem[3].equalsIgnoreCase("candy")){
                        ItemClass candy = new CandyClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        map.put(lineItem[0],candy);
                    }
                    else if (lineItem[3].equalsIgnoreCase("drink")){
                        ItemClass drink = new DrinksClass(lineItem[0],lineItem[1],Double.parseDouble(lineItem[2]),lineItem[3]);
                        map.put(lineItem[0],drink);
                    }
                }
            }
            return map;
        } catch (Exception e){
            throw new FileNotFoundException();
        }
    }



}
