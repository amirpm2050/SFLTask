package com.sfl.pages;

import com.sfl.utils.PageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageModel {

    @FindBy(id = "menu-item-3337")
    WebElement careers ;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://sflpro.com/");
    }

    public String getCareersText(){
        String s = careers.getText();
        return s;
    }

    public String getCareersCount(){
        String careersText = getCareersText();
        String[] careersCount = careersText.split("\n");
        return careersCount[1];
    }

    public CareersPage goToCareersPage(){
        careers.click();
        CareersPage careersPage = new CareersPage(driver);
        return careersPage;
    }
}

