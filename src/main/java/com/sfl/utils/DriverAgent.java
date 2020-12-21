package com.sfl.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverAgent {
    private static Properties properties = null;
    private static WebDriver driver = null;

    static {
        try {
            properties = new Properties();
            properties.load(DriverAgent.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.path"));
            System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));

            switch (getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static String getProperty(String key) {
        return properties == null ? null : properties.getProperty(key, "");
    }

}
