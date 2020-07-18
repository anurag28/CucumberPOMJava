package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/anuraggarg/" +
                    "Desktop/CucumberPOM/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public static void initialization(){
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/anuraggarg/Desktop/CucumberPOM/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }

        else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/anuraggarg/Desktop/CucumberPOM/src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
