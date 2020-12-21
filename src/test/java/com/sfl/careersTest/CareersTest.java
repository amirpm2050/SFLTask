package com.sfl.careersTest;

import com.sfl.pages.CareersPage;
import com.sfl.pages.HomePage;
import com.sfl.pages.JobPage;
import com.sfl.testinitiate.Testinitiate;
import com.sfl.utils.DriverAgent;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class CareersTest extends Testinitiate {

    static WebDriver driver;
    HomePage homePage ;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = DriverAgent.getDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void seeCareers()throws Exception {
        homePage = new HomePage(driver);
        String careersCount = homePage.getCareersCount();
        System.out.println("Careers Count is :"+careersCount);
        CareersPage careersPage = homePage.goToCareersPage();
        Integer jobListCount = careersPage.jobCounts();
        Assert.assertTrue(Integer.parseInt(careersCount)==jobListCount);
        Assert.assertFalse(careersPage.isVacancyAvailable("Manual QA Engineer"));
        JobPage jobPage = careersPage.clickOnJob("Automation QA Enginee");
        jobPage.fillApplicantForm("Test","Tester","test@test.com" , DriverAgent.getProperty("resume.file"));
    }
}
