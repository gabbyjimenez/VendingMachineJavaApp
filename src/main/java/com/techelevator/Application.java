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
		VendingUI UI = new VendingUI();
		CashRegister cashRegister = new CashRegister();


		//Call UI to print prompt
		//Take in user input
		//Do something based on user input
		//Return to main menu/exit app


		while (isOn) {
			String userInput = UI.printStartMenu();
			if (userInput.equals("1")) {
				UI.printMenu(inventory);
			} else if (userInput.equals("2")) {
				while (true) {
					PurchaseMenu purchaseMenu = new PurchaseMenu();
					userInput = UI.printPurchaseMenu();
					if(userInput.equals("1")){
						System.out.println("feed me money");
					}
					else if(userInput.equals("2")){
						UI.printMenu(inventory);
						UI.getItemToPurchase();
					}
					else if (userInput.equals("3")) {
						break;
					}
				}


				//Call Print Menu

				//Take User Choice3
			}

			if (userInput.equals("3")) {
				isOn = false;
			}
		}
	}
}