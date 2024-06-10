package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemClassTest {

    private ItemClass sysToTest;

    @Before
    public void setup() {
        sysToTest = new GumClass("D2", "Little League Chew", 0.95, "Gum");
    }

//    @Test
//    public void quantityReduction_happyTest(){
//        ItemClass testClass = new ChipsClass("E4", "Test Chip", 0.95, "Chip");
//        sysToTest.setQuantityOfItem(10);
//        Assert.assertEquals(7,sysToTest.quantityReduction(sysToTest.,3));
//    }

}
