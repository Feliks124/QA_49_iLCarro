package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends ApplicationManager {

    @Test
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("test_mail@gmail.com",
                "Test124!");
    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        User user = new User("test_mail@gmail.com",
                "test124!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
    }


}
