package com.learn.blazedemo.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GlobalUtil {
    private WebDriver webDriver;
    public GlobalUtil(String browserName) {

        switch(browserName){
            case "edge":
                System.setProperty("webdriver.edge.driver", Config.getResourcePath(this.getClass(),"./drivers/msedgedriver.exe").getFile());
                WebDriverManager manager = WebDriverManager.edgedriver();
                manager.config().setEdgeDriverVersion("96.0.1054.43");
                manager.setup();
                EdgeOptions options = new EdgeOptions();
                webDriver = new EdgeDriver(options);
                webDriver.manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Config.getResourcePath(this.getClass(),"./drivers/geckodriver.exe").getFile());
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Config.getResourcePath(this.getClass(),"./drivers/chromedriver.exe").getFile());
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", Config.getResourcePath(this.getClass(),"./drivers/IEDriverServer.exe").getFile());
                webDriver = new InternetExplorerDriver();
                webDriver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Invalid Browser Type: BROSWER_NAME:"+browserName);
        }
    }
    
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
