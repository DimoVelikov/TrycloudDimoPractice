package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Dashboard_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.dashboardModule).perform();

        List<String> actualModules = new ArrayList<>();

        for (WebElement eachModule : basePage.modules) {

            actualModules.add(eachModule.getText());

        }

        Assert.assertEquals(expectedModules,actualModules);




    }


}
