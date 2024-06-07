package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
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
		//List<ItemClass> inventoryList = inventory.retrieveItems();

		//Call UI to print prompt
		//Take in user input
		//Do something based on user input
		//Return to main menu/exit app


		while (isOn) {
			String userInput = UI.printStartMenu();
			if (userInput.equals("1")) {
				UI.printItems(inventory.retrieveItems());
			} else if (userInput.equals("2")) {

				while (true) {
					userInput = UI.printPurchaseMenu(cashRegister.getTotalBalance());
					if(userInput.equals("1")){
						String amount = UI.printMoneyInsertionMenu();
						cashRegister.addToBalance(amount);
					}
					else if(userInput.equals("2")){


//						userInput = UI.printPurchaseMenu();
						UI.printItems(inventory.retrieveItems());


						while (true){
//							UI.printBalance(cashRegister.getTotalBalance());
							String order = UI.getItemToPurchase();
							makePurchase(order , inventory.retrieveItems(),cashRegister );
						}
					}
					else if (userInput.equals("3")) {
					return;

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

	public void makePurchase(String userInput, List<ItemClass> inventoryList, CashRegister register){
		String slotIdAndQuantity = userInput;
		String[] splitIdAndQuantity = slotIdAndQuantity.split(" ");


		for(ItemClass item : inventoryList){
				if (splitIdAndQuantity[0].equalsIgnoreCase(item.getSlotId())){
					register.makePurchase(item.getPriceOfItem() * Integer.parseInt(splitIdAndQuantity[1]) );
					item.quantityReduction(item, Integer.parseInt(splitIdAndQuantity[1]));
				}
			}
		}





}