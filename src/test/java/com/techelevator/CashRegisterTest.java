package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CashRegisterTest{

    private CashRegister sysToTest;

    @Before
    public void setup(){
        sysToTest = new CashRegister();
    }

    @Test
    public void addToBalance_happyPathTest() throws InvalidInputException{
        double balanceToTest = 10.00;
        String inputToTest = "10";
        Assert.assertEquals(balanceToTest,sysToTest.addToBalance(inputToTest),.00001);
    }

    @Test
    public void addToBalance_negativeStringTest() throws InvalidInputException{
        double balanceToTest = 0.00;
        String inputToTest = "-10";
        Assert.assertEquals(balanceToTest,sysToTest.addToBalance(inputToTest),.00001);
    }

    @Test
    public void addToBalance_zeroTest() throws InvalidInputException{
        double balanceToTest = 0.00;
        String inputToTest = "0";
        Assert.assertEquals(balanceToTest,sysToTest.addToBalance(inputToTest),.00001);
    }
    @Test
    public void addToBalance_outOfBoundsHighTest() throws InvalidInputException{
        double balanceToTest = 0.00;
        String inputToTest = "11";
        Assert.assertEquals(balanceToTest,sysToTest.addToBalance(inputToTest),.00001);
    }

    @Test
    public void removeItemFromBalance_happyPathTest() throws InvalidInputException{
        sysToTest.addToBalance("3");
        double balanceToTest = 3.00;
        double priceToTest = .95;
        Assert.assertEquals(balanceToTest-priceToTest,sysToTest.removeItemFromBalance(priceToTest),.00001);
    }

    @Test
    public void removeItemFromBalance_zeroBalanceTest() throws InvalidInputException{
        sysToTest.addToBalance("0");
        double balanceToTest = 0.00;
        double priceToTest = .95;
        Assert.assertEquals(balanceToTest,sysToTest.removeItemFromBalance(priceToTest),.00001);
    }

    @Test
    public void removeItemFromBalance_priceGreaterThanBalanceTest() throws InvalidInputException{
        sysToTest.addToBalance("1");
        double balanceToTest = 1.00;
        double priceToTest = 1.50;
        Assert.assertEquals(balanceToTest,sysToTest.removeItemFromBalance(priceToTest),.00001);
    }

    @Test
    public void removeItemFromBalance_balanceAndPriceEqualsTest() throws InvalidInputException{
        sysToTest.addToBalance("1");
        double balanceToTest = 0.00;
        double priceToTest = 1.00;
        Assert.assertEquals(balanceToTest,sysToTest.removeItemFromBalance(priceToTest),.00001);
    }

    @Test
    public void makeChange_happyPathTest() throws InvalidInputException{
        sysToTest.addToBalance("1");
        Assert.assertEquals("Your change is: " + 4 + " Quarters, " + 0 + " Dimes, " + 0 + " Nickels.",sysToTest.makeChange());
    }

    @Test
    public void makeChange_oneOfEachCoinTest() throws InvalidInputException{
        sysToTest.setTotalBalance(1.15);
        Assert.assertEquals("Your change is: " + 4 + " Quarters, " + 1 + " Dimes, " + 1 + " Nickels.",sysToTest.makeChange());
    }

    @Test
    public void makeChange_zeroBalance() throws InvalidInputException{
        sysToTest.setTotalBalance(0.00);
        Assert.assertEquals("Your change is: " + 0 + " Quarters, " + 0 + " Dimes, " + 0 + " Nickels.",sysToTest.makeChange());
    }


}
