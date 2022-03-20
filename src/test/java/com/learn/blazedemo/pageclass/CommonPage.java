package com.learn.blazedemo.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends AbstractBasePage {
    protected CommonPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(linkText = "Travel The World")
    public WebElement lnkTravelTheWorld;

    @FindBy(linkText = "home")
    public WebElement home;
}
