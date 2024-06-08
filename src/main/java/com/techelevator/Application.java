package com.techelevator;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {


		boolean isOn = true;
		VendingUI UI = new VendingUI();
		CashRegister cashRegister = new CashRegister();
		LogWriter logWriter = new LogWriter();
		Inventory inventory = new Inventory();

		while (isOn) {
			String userInput = UI.printStartMenu();
			if (userInput.equals("1")) {
				UI.printItems(inventory.retrieveItems());
			} else if (userInput.equals("2")) {

				while (true) {
					String menuInput = UI.printPurchaseMenu(cashRegister.getTotalBalance());
					if(menuInput.equals("1")){
						String amount = UI.printMoneyInsertionMenu();
						cashRegister.addToBalance(amount);
						logWriter.writeToLog(cashRegister.addFundsLog(amount));
					}
					else if(menuInput.equals("2")){

						UI.printItems(inventory.retrieveItems());

						while (true){
							String order = UI.getItemToPurchase();
							makePurchase(order, inventory.retrieveItems(),cashRegister, UI);
							break;
						}
					}
					else if (menuInput.equals("3")) {
					UI.printChange(cashRegister.makeChange());
					break;

					}
				}
			}
			if (userInput.equals("3")) {
				isOn = false;
			}
			if(userInput.equals("4")){
				UI.printSalesReport(inventory.retrieveItems());
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

}
		}












