package com.techelevator;

import java.io.FileNotFoundException;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {


		//do amazing stuff here!

		//Read in file
		FileReader readInitial = new FileReader();
        try {
            readInitial.readInventoryFile();
        } catch (FileNotFoundException e) {
			//Move to UI
			System.out.println("Unable to access vending machine items. Come back later.");
        }
        //Move file data into data object
		//Call UI to print prompt
		//Take in user input
		//Do something based on user input
		//Return to main menu/exit app


	}
}
