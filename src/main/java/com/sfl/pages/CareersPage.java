package com.sfl.pages;

import com.sfl.utils.DriverAgent;
import com.sfl.utils.PageModel;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

public class CareersPage extends PageModel {

    List<WebElement> jobList ;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public Integer jobCounts(){
        WebDriver driver = DriverAgent.getDriver();
        jobList = driver.findElements(By.className("smartrecruitersJobListElement"));
        return jobList.size();
    }

    public WebElement getJobElement(String jobTitle)throws Exception{
        for (Iterator<WebElement> iter = jobList.iterator(); iter.hasNext(); ) {
                WebElement element = iter.next();
                if (element.getText().equals(jobTitle))
                    return element;
            }
        return null;
    }

    public Boolean isVacancyAvailable(String jobTitle) throws Exception {
        if (getJobElement(jobTitle)!=null)
                return true;
        return false;
    }

    public JobPage clickOnJob(String jobTitle)throws Exception{
        WebElement job = getJobElement(jobTitle);
        job.click();
        return new JobPage(driver);
    }
}

