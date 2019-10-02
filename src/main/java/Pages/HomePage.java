package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By headingTitle = By.xpath("//h2[contains(text(),'Appearance settings')]");



    public String getHomePageText(String s){

        return driver.findElement(headingTitle).getText();
    }
}


