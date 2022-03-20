package com.learn.blazedemo.pageclass;

import com.learn.blazedemo.util.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends CommonPage{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy (name = "fromPort")
    private WebElement eleFrom;

    @FindBy (name = "toPort")
    private WebElement eleDestination;

    @FindBy(xpath = "(//input[@value='Find Flights'])")
    private WebElement btnFindFlight;

    public void launchUrl(){
        try {
            logger.debug("Opening base url");
            webDriver.get(Config.getPropertyValue(Config.getResourcePath(this.getClass(), "./global/global.properties"), "BASE_URL"));
            logger.info("Launched Site Successfully");
            Reporter.log("Launched site Successfully");
        }catch(Exception e){
            logger.error("Unable to launch website"+e.getLocalizedMessage());
            Reporter.log("Unable to launch website"+e.getLocalizedMessage());
        }
    }

    public void selectFrom(String sFrom){
        selectByText(eleFrom,sFrom);
    }

    public void selectDestination(String sDestination){
        selectByText(eleDestination,sDestination);
    }

    public void findFlight(){
        logger.trace("Finding Flight");
        clickWebElement(btnFindFlight);
     }

    public void searchFlight(String sFrom, String sDestination){
        try{
            selectFrom(sFrom);
            selectDestination(sDestination);
            findFlight();
            Reporter.log(String.format("Searched Flights: From: %s To: %s",sFrom,sDestination));
        }catch(Exception e){
            logger.error(String.format("Unable to Search Flight: From: %s To: %s",sFrom,sDestination));
            Reporter.log(String.format("Unable to Search Flight: From: %s To: %s, %s",sFrom,sDestination,e.getLocalizedMessage()));
        }
    }

    public void selectByText(WebElement webElement, String option){
        Select select = new Select(webElement);
        List<WebElement> list = select.getOptions();
        select.selectByVisibleText(option);
        logger.info("Selected Item: " + select.getFirstSelectedOption().getText());
    }

    public String getPageTitle(){
        try {
            logger.info("Page Title: " + getTitle());
            return getTitle();
        }catch(Exception e){
            logger.error("Unable to getTitle:"+e.getLocalizedMessage());
            Reporter.log("Unable to getTitle:"+e.getLocalizedMessage());
            return null;
        }
    }
}
