package com.techelevator;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                        try {
                            cashRegister.addToBalance(amount);
							logWriter.writeToLog(cashRegister.addFundsLog(amount));
                        } catch (InvalidInputException e) {
                           UI.printInvalidInputErrorMessage();
                        }

					}
					else if(menuInput.equals("2")){

						UI.printItems(inventory.retrieveItems());

						while (true){
							String order = UI.getItemToPurchase();
							String condition = "[A-Za-z][1-9]\\s[0-9]+";
							Pattern pattern = Pattern.compile(condition);
							Matcher match = pattern.matcher(order);
							try {
								if(match.matches()){
									makePurchase(order, inventory.retrieveItems(),cashRegister, UI, logWriter);
									break;
								}
							} catch (InvalidInputException e) {
								UI.printInvalidInputErrorMessage();
							}

						}
					}
					else if (menuInput.equals("3")) {
						logWriter.writeToLog(cashRegister.addChangeToLog(cashRegister.getTotalBalance()));
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


	public void makePurchase(String userInput, List<ItemClass> inventoryList, CashRegister register,VendingUI output,LogWriter purchaseWriter) throws InvalidInputException {

		String slotIdAndQuantity = userInput;


		String[] splitIdAndQuantity = slotIdAndQuantity.split(" ");
		int quantity = Integer.parseInt(splitIdAndQuantity[1]);
		String slotId = splitIdAndQuantity[0];
		boolean isFound = false;
			for (ItemClass item : inventoryList) {
				if (slotId.equalsIgnoreCase(item.getSlotId())) {
					isFound = true;
					if (register.getTotalBalance() >= item.getPriceOfItem()) {
						for (int i = 0; i < quantity; i++) {
						if (item.getQuantityOfItem() > 0 && item.getQuantityOfItem() <= 10) {

								register.makePurchase(item.getPriceOfItem());
								item.quantityReduction(item, 1);
								output.printItemMessage(item);
								purchaseWriter.writeToLog(register.addPurchaseToLog(item.getNameOfItem(), slotId, item.getPriceOfItem()));

							} else {
							output.inventoryOutOfStockMessage();
							}
						}
						break;
					} else {
						output.insufficientFundsMessage();
					}
				}
			}
			if (!isFound) {
				output.invalidSlotAndQuantityMessage();
			}

	}
}












