package Service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverService {
        private static String CHROME_PATH = "D:\\PHPMyadmin\\Drivers\\chromedriver.exe";
        private WebDriver webDriver;

        public void closeDriver(WebDriver webDriver) {
           webDriver.close();
           webDriver.quit();
        }

        public WebDriver login (String path) {

            getWebDriver();
            webDriver.get(path);
            return webDriver;
        }

        private WebDriver getWebDriver() {
            if (webDriver != null) {
                return webDriver;
            }
            System.setProperty("webdriver.chrome.driver", CHROME_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--no`-sandbox");

            webDriver = new ChromeDriver(options);
            return webDriver;
        }

    }


