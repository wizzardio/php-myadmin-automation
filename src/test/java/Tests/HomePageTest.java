package Tests;


import BaseClasses.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    @Before
    public  void setupTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.register("root", "");
    }

    @Test
    public void getHomePageLogoTest() {
        HomePage homePage= new HomePage(driver);

        String heading = homePage.getHomePageText("");
        Assert.assertEquals("Appearance settings", heading);
    }
}




