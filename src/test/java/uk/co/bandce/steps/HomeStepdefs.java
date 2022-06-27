package uk.co.bandce.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import uk.co.bandce.pages.HomePage;
import uk.co.bandce.pages.LoginPage;
import uk.co.bandce.pages.VacancyPage;

public class HomeStepdefs {

    @Given("^I try to launch the homepage$")
    public void iTryToLaunchTheHomepage() {
    }

    @And("^I click on accept cookies$")
    public void iClickOnAcceptCookies() {
        new HomePage().clickOnAcceptCookies();
    }

    @Then("^I should see the alert text displayed$")
    public void iShouldSeeTheAlertTextDisplayed() {
        String expectedText = "You may be concerned about reports of market turbulence as a result of the Russia-Ukraine conflict and how this might affect the value of your pension savings. Find out more";
        String actualText = new HomePage().getTextfromAlert();
        Assert.assertEquals("Alert text is not present",expectedText,actualText);
        }

    @And("^I mouse hover on careers tab$")
    public void iMouseHoverOnCareersTab() {
        new HomePage().mouseHoverOnCareersTab();
    }

    @And("^I click on current vacancies$")
    public void iClickOnCurrentVacancies() {
        new HomePage().clickOnCurrentVacancies();
    }

    @Then("^I should be able to see number of vacancies$")
    public void iShouldBeAbleToSeeNumberOfVacancies() {
        String expectedText = "We have 37 vacancies";
        String actualText = new VacancyPage().getTextFromVacancyMessage();
        Assert.assertEquals("Vacancy message is not present",expectedText,actualText);

    }

    @And("^I click on product dropdown$")
    public void iClickOnProductDropdown() {
        new HomePage().clickOnProductDropdown();
    }

    @And("^I print the list of products available$")
    public void iPrintTheListOfProductsAvailable() {
        new HomePage().listOfAllProducts();
    }

    @And("^I perform login operations$")
    public void iPerformLoginOperations() throws InterruptedException {
        new HomePage().clickOnManageAccountLink();
        new HomePage().clickOnLoginButton();
        new LoginPage().clickOnAcceptAllButton();
                new LoginPage().performLoginOperation();
    }


    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage() {
        String expectedMessage = "Your password/username may be incorrect - please try again";
        String actualMessage = new LoginPage().verifyErrorMessageText();
        Assert.assertEquals("Error message text is not correct", expectedMessage, actualMessage);
    }

    @Then("^I should be able to see the B&CE logo is present$")
    public void iShouldBeAbleToSeeTheBCELogoIsPresent() {
        new HomePage().verifyLogoVisible();
    }

    @Then("^I should be able to verify number of links present$")
    public void iShouldBeAbleToVerifyNumberOfLinksPresent() {
        new HomePage().verifyNumberOfLinksPresent();
    }

    @And("^I should be able to print out all the links$")
    public void iShouldBeAbleToPrintOutAllTheLinks() {
        new HomePage().printOutAllLinksPresent();
    }
}
