package Tests;


import BaseClasses.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginWithInvalidCredsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.register("root2", "test");
        String errorText = loginPage.getErrorText();
        Assert.assertEquals("Cannot log in to the MySQL server", errorText);
    }
}




