package Pages;


import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);

    }

    private By headingTitle = By.xpath("//h2[contains(text(),'Appearance settings')]");


    public String getHomePageText(String s) {

        return find(headingTitle).getText();
    }
}