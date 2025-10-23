package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {
Random random = new Random();
int randomNumber = random.nextInt(1000);

    String randomEmail = "test_feliks" +randomNumber+ "@gmail.com";

    @Test
    public void positiveRegistrationTest() {
        UserLombok userLombok = new UserLombok("Feliks", "Weiss", randomEmail, "Test1234!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnSingUpHeader();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(userLombok);
        Assert.assertTrue(registrationPage.isLoggedSuccess());
    }
}
