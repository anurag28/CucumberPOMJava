package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageSteps extends TestBase{
    LoginPage loginPage;
    HomePage homePage;

    @Given("user opens browser")
    public void user_opens_browser() {
        TestBase.initialization();
    }


    @Then("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage();
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertTrue(actualTitle.contains("Login"));
    }

    @Then("user enters username and password")
    public void user_enters_username_and_password() {
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Then("validate home page title")
    public void validate_home_page_title() {
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertTrue(actualTitle.contains("Alias"));
    }


    @Then("validate logout button is displayed")
    public void validate_logout_button_is_displayed() {
        Assert.assertTrue(homePage.verifyLogoutIsDisplayed());
    }

    @Then("validate logo is displayed")
    public void validate_logo_is_displayed() {
        Assert.assertTrue(homePage.verifyLogoIsDisplayed());
    }

}
