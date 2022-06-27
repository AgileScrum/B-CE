package uk.co.bandce.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import uk.co.bandce.utility.Utility;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "logo")
    WebElement logo;

    @CacheLookup
    @FindBy(id = "wt-cli-accept-btn")
    WebElement acceptCookies;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-info']")
    WebElement alertMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Careers')]")
    WebElement careersTab;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Current vacancies')]")
    WebElement currentVacancies;

    @CacheLookup
    @FindBy(xpath = "//select[@class='form-control']")
    WebElement productDropdown;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Manage account')]")
    WebElement manageAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(tagName = "a")
    List<WebElement> links;



    public void clickOnAcceptCookies() {
        acceptCookies.click();
        log.info("Clicking on accept cookies "+ acceptCookies.toString());
    }

    public String getTextfromAlert() {
        String alertText = getTextFromElement(alertMessage);
        log.info("Getting homepage alert text " + alertMessage.toString());
        return alertText;
    }

    public void mouseHoverOnCareersTab() {
        mouseHoverToElement(careersTab);
        log.info("mouse hover on careers tab "+ careersTab.toString());
    }

    public void clickOnCurrentVacancies() {
        clickOnElement(currentVacancies);
        log.info("Clicking on current vacancies link "+ currentVacancies.toString());

    }

    public void clickOnProductDropdown() {
        productDropdown.click();
        log.info("Clicking on product dropdown "+ productDropdown.toString());
    }

    public void listOfAllProducts() {
        Select select = new Select(productDropdown);
        List<WebElement> alloptions = select.getOptions();
        alloptions.remove(0);
        System.out.println("Total number of products available = " + alloptions.size());
        System.out.println("List of Products are below: ");
        log.info("Retrieving the list of products");
        for (WebElement element : alloptions) {
            System.out.println(element.getText());
          }
    }

    public void clickOnManageAccountLink() {
        manageAccountLink.click();
        log.info("Clicking on manage account link" + manageAccountLink.toString());

    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        log.info("Clicking on login button" + loginButton.toString());
    }

    public void verifyLogoVisible() {
        boolean logoPresent = logo.isDisplayed();
        Assert.assertTrue(logoPresent);
        if (!logoPresent) {
            System.out.println("Logo not Visible");
        } else {
            System.out.println("Logo is Visible");
        }
    }
    public void verifyNumberOfLinksPresent() {
        int numberOfLinks = links.size();
        System.out.println("Number Of Links Present On HomePage = " + numberOfLinks);
    }
    public void printOutAllLinksPresent(){
        System.out.println("All the links details are below:");
        for (WebElement allLinks : links) {
            System.out.println(allLinks.getText() + " - " + allLinks.getAttribute("href"));
        }
    }
}