package com.learn.blazedemo.tests;

import com.learn.blazedemo.pageclass.FlightConfirmation;
import com.learn.blazedemo.pageclass.FlightPurchase;
import com.learn.blazedemo.pageclass.FlightReserve;
import com.learn.blazedemo.pageclass.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFlight extends BaseTest {

    @Test(testName = "Book a Flight", description = "Search flight and register a passenger")
    public void tc_01_testBookFlight()  {
        WebDriver driver = getWebDriver();
        HomePage homePage=new HomePage(driver);
        FlightReserve flightreserve = new FlightReserve(driver);
        FlightPurchase flightPurchase = new FlightPurchase(driver);
        FlightConfirmation flightconfirmation = new FlightConfirmation(driver);

        homePage.launchUrl();
        Assert.assertEquals(homePage.getPageTitle(),"BlazeDemo", "URL is not launched");

        homePage.searchFlight("São Paolo","New York");
        Assert.assertEquals(flightreserve.getSearchResult(),String.format("Flights from %s to %s:","São Paolo","New York"),"Search Result is Empty");

        flightreserve.selectFlight("Lufthansa");
        Assert.assertEquals(flightPurchase.getSelectedFlightResult(), String.format("Your flight from %s to %s has been reserved.","TLV","SFO"),"Reservation Form is not displayed");

        flightPurchase.fillDetailsAndPurchase("Anand","13 A Street","Bangalore","Karnataka","560001","1234567891011","12","2025","Anand Kumar");
        Assert.assertEquals(flightconfirmation.getConfirmationText(),"Thank you for your purchase today!","Confirmation Screen is not displayed");
    }

    @Test(testName = "Book a Flight", description = "Search flight with Invalid Source or Destination")
    public void tc_02_testBookFlight()  {
        WebDriver driver = getWebDriver();
        HomePage homePage=new HomePage(driver);
        FlightReserve flightreserve = new FlightReserve(driver);
        FlightPurchase flightPurchase = new FlightPurchase(driver);
        FlightConfirmation flightconfirmation = new FlightConfirmation(driver);

        homePage.launchUrl();
        Assert.assertEquals(homePage.getPageTitle(),"BlazeDemo", "URL is not launched");

        homePage.searchFlight("São Paoloed","New York");
        Assert.assertEquals(flightreserve.getSearchResult(),String.format("Flights from %s to %s:","São Paolo","New York"),"Search Result is Empty");

        flightreserve.selectFlight("Lufthansa");
        Assert.assertEquals(flightPurchase.getSelectedFlightResult(),String.format("Your flight from %s to %s has been reserved.","TLV","SFO"),"Reservation Form is not displayed");

        flightPurchase.fillDetailsAndPurchase("Anand","13 A Street","Bangalore","Karnataka","560001","1234567891011","12","2025","Anand Kumar");
        Assert.assertEquals(flightconfirmation.getConfirmationText(),"Thank you for your purchase today!","Confirmation Screen is not displayed");

    }

    @Test(testName = "Book a Flight", description = "Invalid Airline Specified")
    public void tc_03_testBookFlight()  {
        WebDriver driver = getWebDriver();
        HomePage homePage=new HomePage(driver);
        FlightReserve flightreserve = new FlightReserve(driver);
        FlightPurchase flightPurchase = new FlightPurchase(driver);
        FlightConfirmation flightconfirmation = new FlightConfirmation(driver);

        homePage.launchUrl();
        Assert.assertEquals(homePage.getPageTitle(),"BlazeDemo", "URL is not launched");

        homePage.searchFlight("São Paolo","New York");
        Assert.assertEquals(flightreserve.getSearchResult(),String.format("Flights from %s to %s:","São Paolo","New York"),"Search Result is Empty");

        flightreserve.selectFlight("Lufthansaes");
        Assert.assertEquals(flightPurchase.getSelectedFlightResult(), String.format("Your flight from %s to %s has been reserved.","TLV","SFO"),"Reservation Form is not displayed");

        flightPurchase.fillDetailsAndPurchase("Anand","13 A Street","Bangalore","Karnataka","560001","1234567891011","12","2025","Anand Kumar");
        Assert.assertEquals(flightconfirmation.getConfirmationText(),"Thank you for your purchase today!","Confirmation Screen is not displayed");
    }

    @Test(testName = "Book a Flight", description = "No Confirmation Form")
    public void tc_04_testBookFlight() {
        WebDriver driver = getWebDriver();
        HomePage homePage=new HomePage(driver);
        FlightReserve flightreserve = new FlightReserve(driver);
        FlightPurchase flightPurchase = new FlightPurchase(driver);
        FlightConfirmation flightconfirmation = new FlightConfirmation(driver);

        homePage.launchUrl();
        Assert.assertEquals(homePage.getPageTitle(),"BlazeDemo", "URL is not launched");

        homePage.searchFlight("São Paolo","New York");
        Assert.assertEquals(flightreserve.getSearchResult(),String.format("Flights from %s to %s:","São Paolo","New York"),"Search Result is Empty");

        flightreserve.selectFlight("Lufthansa");
        Assert.assertEquals(flightPurchase.getSelectedFlightResult(), String.format("Your flight from %s to %s has been reserved.","TLV","SFO"),"Reservation Form is not displayed");

        //flightPurchase.fillDetailsAndPurchase("Anand","13 A Street","Bangalore","Karnataka","560001","1234567891011","12","2025","Anand Kumar");
        Assert.assertEquals(flightconfirmation.getConfirmationText(),"Thank you for your purchase today!","Confirmation Screen is not displayed");
    }






}
