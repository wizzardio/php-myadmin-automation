import Pages.LoginPage;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\PHPMyadmin\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1/openserver/phpmyadmin/index.php");

        loginPage = new LoginPage(driver);

    }

    @Test
    public void signIn(){

    }

    @After
    public void tearDown (){
        driver.quit();
    }
}
 // base test class

