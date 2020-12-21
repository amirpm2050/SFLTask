package com.sfl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class PageModel {

    public WebDriver driver;

    public PageModel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    public WebElement scrollToFindElement(By by) throws InterruptedException {
        WebElement element = null;
        try {
            element = driver.findElement(by);
            System.out.println(element.isDisplayed());
            System.out.println(element.isEnabled());
            System.out.println(element.isSelected());
            if (element.isDisplayed()!=true){
                throw new Exception("Element is not displayed");
            }
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
            sleep(500);
            scrollToFindElement(by);
        }
        return element;
    }
}
