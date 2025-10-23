package pages;

import dto.UserLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(css = "input[formcontrolname='firstName']")
    WebElement inputFirstName;

    @FindBy(css = "input[formcontrolname='lastName']")
    WebElement inputLastName;

    @FindBy(css = "input[formcontrolname='email']")
    WebElement inputEmail;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement inputPassword;

    @FindBy(css = "label[for='terms-of-use']")
    WebElement checkBox;

    public void clickCheckBox(){
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox,50,5).click().perform();
    }

    @FindBy(css = "button[type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//h2[text()='You are logged in success']")
    WebElement popUpTextLoggedInSuccess;

    public void typeRegistrationForm(UserLombok user) {
        inputFirstName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        clickCheckBox();
        btnYalla.click();
    }

    public boolean isLoggedSuccess (){
        return elementIsDisplayed(popUpTextLoggedInSuccess);
    }

}
