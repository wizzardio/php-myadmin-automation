import Pages.HomePage;
import Pages.LoginPage;
import Service.DriverService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest {
    private static String LOGIN_URL = "http://127.0.0.1/openserver/phpmyadmin/index.php";
    private DriverService driverService = new DriverService();
    private WebDriver webDriver;
    private HomePage homePage;

    @Before
    public void setUp() {
        webDriver = new DriverService().login(LOGIN_URL);
        homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.register("root","");
    }

    @Test
    public void getHomePageLogoTest  () {
        String heading = homePage.getHomePageText("");
        Assert.assertEquals("Appearance settings", heading);
    }


    @After
    public void tearDown (){
        webDriver.quit();
    }
}