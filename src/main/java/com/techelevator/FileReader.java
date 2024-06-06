package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader{

    public void readInventoryFile() throws FileNotFoundException {

        File inventoryFile = new File("C:\\Users\\Student\\workspace\\mini-capstone-1\\m-1-capstone-team-0\\vendingmachine.csv");
        try(Scanner fileScanner = new Scanner(inventoryFile)){
            while (fileScanner.hasNextLine()){

                String listItem = fileScanner.nextLine();
                //System.out.println(listItem);
                //TODO: Put this into the map;
                String[] lineItem = listItem.split("\\|");
                for(String item : lineItem){
                    //Create object based on line read

                }
            }
        } catch (Exception e){
            throw new FileNotFoundException();
        }
    }









}
