package com.qa.pages;

import com.qa.util.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = ".//a[@href='/dashboard/']//img")
    WebElement img_logo;

    @FindBy(css = ".text-success")
    WebElement link_expire_msg;

    @FindBy(css = ".fe-log-out")
    WebElement btn_logout;

    @FindBy(xpath = ".//a[@href='/dashboard/api_key']")
    WebElement link_api_key;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    // Actions

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyLogoIsDisplayed(){
        return img_logo.isDisplayed();
    }

    public boolean verifyLogoutIsDisplayed(){
        link_expire_msg.click();
        return btn_logout.isDisplayed();
    }

    public APIKeyPage clickAPIKey(){
        link_api_key.click();
        return new APIKeyPage();
    }
}
