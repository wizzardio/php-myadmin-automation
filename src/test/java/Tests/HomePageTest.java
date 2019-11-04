package Tests;


import BaseClasses.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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

    @Test
    public void checkDisplayingMenuTabs () {
        HomePage homePage = new HomePage(driver);
        Assertions.assertAll(
            () -> Assertions.assertTrue(homePage.getDatabaseLogo()),
            () -> Assertions.assertTrue(homePage.getSqlLogo()));
    }

    @Test
    public void checkCreateNewDatabase() {
        HomePage homePage= new HomePage(driver);
        homePage.createNewDatabase("qwert1");
        Assert.assertTrue(homePage.isDatabaseVisible("qwert1"));
    }

    @Test
    public void checkCreateNewTable() {
        HomePage homePage= new HomePage(driver);
        homePage.createNewDatabase("testdb");
        homePage.createNewTable("test", "testColumn");
        Assert.assertTrue(homePage.isTableSidebarVisible("12"));
    }

    @Test
    public void checkDeletionDatabaseTable() {
        HomePage homePage= new HomePage(driver);
        homePage.deleteDatabase("testdb");
        Assert.assertFalse(homePage.isDatabaseVisibleAfterDeletion("testdb"));
    }
}





