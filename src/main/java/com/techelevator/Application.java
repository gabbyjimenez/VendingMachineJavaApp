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
							String order = UI.getItemToPurchase();
							makePurchase(order, inventory.retrieveItems(),cashRegister, UI);
							break;
						}
					}
					else if (userInput.equals("3")) {
					return;

					}
				}
			}
			if (userInput.equals("3")) {
				isOn = false;
			}
		}
	}

	public void makePurchase(String userInput, List<ItemClass> inventoryList, CashRegister register,VendingUI output){
		String slotIdAndQuantity = userInput;
		String[] splitIdAndQuantity = slotIdAndQuantity.split(" ");
		int quantity = Integer.parseInt(splitIdAndQuantity[1]);
		String slotId = splitIdAndQuantity[0];
		boolean isFound = false;

		for (ItemClass item : inventoryList) {
			if(slotId.equalsIgnoreCase(item.getSlotId())){
				isFound = true;
				if (register.getTotalBalance() >= item.getPriceOfItem()) {
					if(item.getQuantityOfItem() > 0){
						register.makePurchase(item.getPriceOfItem() * quantity);
						item.quantityReduction(item, quantity);
						output.printItemMessage(item);
						break;
					} else {
						output.inventoryOutOfStockMessage();
							}
				} else {
					output.insufficientFundsMessage();
						}
			}
		}

		if(!isFound){
			output.invalidSlotAndQuantityMessage();
		}











		//Insane loop method

//		for(int i= 0; i < Integer.parseInt(splitIdAndQuantity[1]); i++){
//			for (ItemClass item : inventoryList) {
//					if (splitIdAndQuantity[0].equalsIgnoreCase(item.getSlotId())) {
//						if (register.getTotalBalance() >= item.getPriceOfItem()) {
//							if(item.getQuantityOfItem() > 0){
//								register.makePurchase(item.getPriceOfItem());
//								item.quantityReduction(item, 1);
//								output.printItemMessage(item);
//							} else {
//								output.inventoryOutOfStockMessage();
//							}
//						} else {
//							output.insufficientFundsMessage();
//						}
//					} else {
//						output.invalidSlotAndQuantityMessage();
//					}
//				}
//			}
		}






}





