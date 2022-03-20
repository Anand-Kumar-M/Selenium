package com.learn.blazedemo.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FlightReserve extends CommonPage {
    public FlightReserve(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(tagName = "h3")
    private WebElement lblSearchResult;

    private WebElement getFlightByName(String flightname){

        WebElement element= webDriver.findElement(By.xpath(String.format("//table//td[contains(text(),'%s')]/preceding-sibling::td/input",flightname)));
        return element;
    }

    public void selectFlight(String flightname) {
        try {
            logger.trace("Selecting Flight");
            clickWebElement(getFlightByName(flightname));
            Reporter.log(String.format("Successfully selected. Airline: %s", flightname));
        } catch (Exception e) {
            logger.error(String.format("Unable to Select Flight: FlightName: %s", flightname));
            Reporter.log(String.format("Unable to Select Flight: FlightName: %s : %s", flightname, e.getLocalizedMessage()));
        }
    }

        public String getSearchResult(){
            try{
                String searchText = getText(lblSearchResult);
                logger.trace("Search Flight Validation: "+ searchText);
                return searchText;
            }catch(Exception e){
                logger.error("Search Result screen is not displayed");
                Reporter.log("Search Result screen is not displayed");
                return "";
            }
        }




}
