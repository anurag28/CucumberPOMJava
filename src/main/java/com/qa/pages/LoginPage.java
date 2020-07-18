package com.qa.pages;

import com.qa.util.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(css = "#email")
    WebElement input_email;

    @FindBy(id = "password")
    WebElement input_password;

    @FindBy(css = ".btn.btn-primary.btn-block")
    WebElement btn_login;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String email, String password){
        input_email.sendKeys(email);
        input_password.sendKeys(password);

        btn_login.click();
        return new HomePage();
    }


}
