package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {



		boolean isOn = true;

		Inventory inventory = new Inventory();




		//Call UI to print prompt
		//Take in user input
		//Do something based on user input
		//Return to main menu/exit app

		VendingUI UI = new VendingUI();
		while(isOn){

			UI.printStartMenu();
			myScanner.nextLine();

			UI.printMenu();
			myScanner.nextLine();

			//Call Print Menu

			//Take User Choice
		}


	}
}
