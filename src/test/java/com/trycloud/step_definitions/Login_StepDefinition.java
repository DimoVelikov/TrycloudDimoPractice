package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void userOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);

    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginBtn.click();

    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        BrowserUtils.verifyURLContains("dashboard");

    }


    @When("user enter invalid {string} and {string}")
    public void userEnterInvalidAnd(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("verify {string} message should be displayed")
    public void verifyMessageShouldBeDisplayed(String message) {

        Assert.assertEquals(loginPage.wrongUsernameOrPassword.getText(),message);

    }
}
