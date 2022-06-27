package uk.co.bandce.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.bandce.utility.Utility;

public class VacancyPage extends Utility {

    private static final Logger log = LogManager.getLogger(VacancyPage.class.getName());
    public VacancyPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'We have 37 vacancies')]")
    WebElement vacancyMessage;

    public String getTextFromVacancyMessage(){
    String vacancyText = getTextFromElement(vacancyMessage);
        log.info("Retrieving the text from total vacancy text");
    return vacancyText;
    }
}
