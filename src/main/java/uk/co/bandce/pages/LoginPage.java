package uk.co.bandce.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.bandce.utility.Utility;

import java.util.Set;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "UserName")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@id='loginSubmit']")
    WebElement mainLogin;

    @CacheLookup
    @FindBy(id = "cky-btn-accept")
    WebElement acceptAll;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Your password/username may be incorrect - please t')]")
    WebElement errorMessage;

    public void clickOnAcceptAllButton() {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
          for (String handle : handles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                clickOnElement(acceptAll);
                break;
            }
        }
    }

        public void performLoginOperation() {
            sendTextToElement(userName, "test@gmail.com");
            // log.info("Inputting user name <br>");
            sendTextToElement(password, "test123");
            //  log.info("Inputting password <br>");
            clickOnElement(mainLogin);
            log.info("Clicking on main login button " + mainLogin.toString());
        }

      public String verifyErrorMessageText(){
        log.info("Verifying error message text: " + errorMessage.toString());
        return getTextFromElement(errorMessage);
      }

    }
