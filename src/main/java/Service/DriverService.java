package Service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverService {
        private static String CHROME_PATH = "D:\\PHPMyadmin\\Drivers\\chromedriver.exe";
        private WebDriver webDriver;
        private String path;

        public DriverService( String path) {
            this.path = path;
        }

        public WebDriver getWebDriver() {
            if (webDriver != null) {
                return webDriver;
            }
            System.setProperty("webdriver.chrome.driver", CHROME_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--no`-sandbox");

            webDriver = new ChromeDriver(options);
            webDriver.get(path);
            return webDriver;
        }

    }


