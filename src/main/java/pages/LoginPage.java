package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(css = "input[autocomplete='username']")
    WebElement inputEmail;

    @FindBy(css = "input[autocomplete='current-password']")
    WebElement inputPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnYalla;

    @FindBy(css = "button[class='positive-button ng-star-inserted']")
    WebElement btnOk;

    @FindBy(xpath = "//h2[contains(text(),'Login or Password incorrect')]")
    WebElement popUpTextLoggedIncorrect;

    @FindBy(xpath = "//h2[text()='Logged in success']")
    WebElement popUpTextLoggedSuccess;


    public boolean isLoggedDisplayed(){
        return elementIsDisplayed(popUpTextLoggedSuccess);
    }

    public boolean isLoggedIncorrect(){
        return elementIsDisplayed(popUpTextLoggedIncorrect);
    }

    public void typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        btnYalla.click();
        btnOk.click();
    }

    public void typeLoginFormWithUser (User user){
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnYalla.click();
    }


}
