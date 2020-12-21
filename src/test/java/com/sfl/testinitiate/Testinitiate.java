package com.sfl.testinitiate;

import com.sfl.utils.DriverAgent;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


public class Testinitiate {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = DriverAgent.getDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }



}
