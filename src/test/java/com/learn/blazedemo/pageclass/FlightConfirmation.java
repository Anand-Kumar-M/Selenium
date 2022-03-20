package com.learn.blazedemo.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FlightConfirmation extends CommonPage {
    public FlightConfirmation(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(tagName = "h1")
    private WebElement lblSearchResult;

    public String getConfirmationText(){
        try{
            String searchText = getText(lblSearchResult);
            logger.trace("Search Flight Validation: "+ searchText);
            return searchText;
        }catch(Exception e){
            logger.error("Confirmation screen is not displayed");
            Reporter.log("Confirmation screen is not displayed");
            return "";
        }
    }
}
