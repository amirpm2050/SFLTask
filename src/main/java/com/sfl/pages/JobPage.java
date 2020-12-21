package com.sfl.pages;

import com.sfl.utils.DriverAgent;
import com.sfl.utils.PageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class JobPage extends PageModel {

    @FindBy(xpath = "//*[@id='wpcf7-f3772-o4']/form/div[2]/div[1]/div[2]/div[1]/div/span/input")
    WebElement inputFirstname;

    @FindBy(xpath = "//*[@id='wpcf7-f3772-o4']/form/div[2]/div[1]/div[2]/div[2]/div/span/input")
    WebElement inputLastname;

    @FindBy(xpath = "//*[@id=\"wpcf7-f3772-o4\"]/form/div[2]/div[1]/div[3]/div/span/input")
    WebElement inputEmail;

    @FindBy(xpath = "//*[@id='wpcf7-f3772-o4']/form/div[2]/div[1]/div[4]/p/span/div/input")
    WebElement inputFile;

    @FindBy(xpath = "//*[@id='wpcf7-f3772-o4']/form/div[2]/div[1]/div[5]/input")
    WebElement submitButton;

    public JobPage(WebDriver driver) {
        super(driver);
    }

    public void fillApplicantForm(String firstname , String lastname , String email , String resumeFile) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer y = driver.findElement(By.id("wpcf7-f3772-o4")).getLocation().y;//find y of form element and javascript executor will scroll to form
        js.executeScript("window.scrollBy(0,"+y+")");
        inputFirstname.sendKeys(firstname );
        inputLastname.sendKeys(lastname);
        inputEmail.sendKeys(email);
        inputFile.sendKeys(resumeFile);
        submitButton.click();
    }
}
