package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader{

    public void readInventoryFile() throws FileNotFoundException {

        File inventoryFile = new File("C:\\Users\\Student\\workspace\\Module1MiniCapstone\\m-1-capstone-team-0\\vendingmachine.csv");
        Inventory inventory = new Inventory();

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
                        inventory.addItemToInventory(lineItem[1],chips);
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
                }{



//                    if
                    //populate based on line read using constructor

                }
            }
        } catch (Exception e){
            throw new FileNotFoundException();
        }
    }









}
