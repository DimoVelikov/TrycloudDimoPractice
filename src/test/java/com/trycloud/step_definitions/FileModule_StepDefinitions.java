package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.FilePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileModule_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    FilePage filePage = new FilePage();



    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String desiredModule) {

        basePage.filesModule.click();

        /*
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.filesModule).perform();

        for (WebElement eachModule : basePage.modules) {
            if(eachModule.getText().equals(desiredModule)){
                eachModule.click();
            }
        }

         */

    }


    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }


    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        filePage.selectAllCheckBox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {

        //boolean allCheckBoxSelected = true;

        for (WebElement eachCheckBox : filePage.allCheckBox) {

            Assert.assertTrue(eachCheckBox.isSelected());

        }

    }


    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {

    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {

    }
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {

    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

    }

}
