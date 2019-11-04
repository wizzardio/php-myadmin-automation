package Tests;


import BaseClasses.BaseTest;
<<<<<<< HEAD
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends BaseTest {

=======
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;


public class LoginPageTest extends BaseTest {


>>>>>>> 611ac786956b9c5fc2b961eecc93d078bb323ef0
    @Test
    public void loginWithInvalidCredsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.register("root2", "test");
        String errorText = loginPage.getErrorText();
        Assert.assertEquals("Cannot log in to the MySQL server", errorText);
    }
}




