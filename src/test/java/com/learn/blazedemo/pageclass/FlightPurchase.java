package com.learn.blazedemo.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FlightPurchase extends CommonPage {
    public FlightPurchase(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "inputName")
    private WebElement idName;

    @FindBy(id = "address")
    private WebElement idAddress;

    @FindBy(id = "city")
    private WebElement idCity;

    @FindBy(id = "state")
    private WebElement idState;

    @FindBy(id = "zipCode")
    private WebElement idZipCode;

    @FindBy(id = "creditCardNumber")
    private WebElement idCreditCardNumber;

    @FindBy(id = "creditCardMonth")
    private WebElement idCreditCardMonth;

    @FindBy(id = "creditCardYear")
    private WebElement idCreditCardYear;

    @FindBy(id = "nameOnCard")
    private WebElement idnameOnCard;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement btnPurchaseFlight;

    @FindBy(tagName = "h2")
    private WebElement lblSearchResult;

    public void setName(String name){
        setText(idName, name);
    }

    public void setAddress(String address){
        setText(idAddress, address);
    }

    public void setCity(String city){
        setText(idCity, city);
    }

    public void setState(String state){
        setText(idState, state);
    }

    public void setZipCode(String zipcode){
        setText(idZipCode, zipcode);
    }

    public void setCreditCardNumber(String number){
        setText(idCreditCardNumber, number);
    }

    public void setCreditCardMonth(String month){
        setText(idCreditCardMonth, month);
    }

    public void setCreditCardYear(String year){
        setText(idCreditCardYear, year);
    }

    public void setNameAsInCard(String name){
        setText(idnameOnCard, name);
    }

    public void clickPurchaseFlight(){
        logger.trace("Purchase Flight");
        clickWebElement(btnPurchaseFlight);
    }

    public void fillDetailsAndPurchase(String name, String address, String city, String state, String zipcode, String number, String month, String year, String nameAsInCard){
        try {
            logger.trace("Selecting Flight");
            setName(name);
            setAddress(address);
            setCity(city);
            setState(state);
            setZipCode(zipcode);
            setCreditCardNumber(number);
            setCreditCardMonth(month);
            setCreditCardYear(year);
            setNameAsInCard(nameAsInCard);
            clickPurchaseFlight();
            Reporter.log("Filled in the details and Clicked on Purchase Flight");
        }catch(Exception e){
            logger.error("Error while filling details: Refer log for details.");
            Reporter.log(String.format("Error while filling details: Refer log for details: Error: %s", e.getLocalizedMessage()));
        }
    }

    public String getSelectedFlightResult(){
        try{
            String searchText = getText(lblSearchResult);
            logger.trace("Search Flight Validation: "+ searchText);
            return searchText;
        }catch(Exception e){
            logger.error("Reserved Flight screen is not displayed");
            Reporter.log("Reserved Flight screen is not displayed");
            return "";
        }
    }



}
