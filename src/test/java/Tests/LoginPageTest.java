package Tests;


import BaseClasses.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends BaseTest {

    @Before
    public  void setupTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithInvalidCred("root2", "test");
    }

    @Test
    public void loginWithInvalidCredsTest() {
        LoginPage loginPage = new LoginPage(driver);
        String errorText = loginPage.getErrorText();
        Assert.assertEquals("Cannot log in to the MySQL server", errorText);
    }
}




