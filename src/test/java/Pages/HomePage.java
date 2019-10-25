package Pages;


import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);

    }

    private By headingTitle = By.xpath("//h2[contains(text(),'Appearance settings')]");
    private By databaseLogo = By.xpath("//img[@class='icon ic_s_db']");
    private By sqlLogo = By.xpath("//img[@class='icon ic_b_sql']");


    public String getHomePageText(String s) {
        return find(headingTitle).getText();
    }

    public Boolean getSqlLogo (){
        return find(sqlLogo).isDisplayed();
    }

    public Boolean getDatabaseLogo (){
        return find(databaseLogo).isDisplayed();
    }






}