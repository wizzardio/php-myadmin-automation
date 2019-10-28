package Pages;

import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    String url = "http://127.0.0.1/openserver/phpmyadmin/index.php";
    By goButton = By.xpath("//input[@id='input_go']");
    By userNameField = By.xpath("//input[@id='input_username']");
    By passwordField = By.xpath("//input[@id='input_password']");
    By selectLanguage = By.xpath("//select[@id='sel-lang']");
    By registerError = By.xpath("//div[contains(text(),'Cannot log in to the MySQL server')]");
    By selectEnglish = By.xpath("(//option[contains(text(),'English')])[1]");


    private void visit(){
        driver.get(this.url);
    }

    private void setLanguage() {
        find(selectLanguage).click();
        find(selectEnglish).click();
    }

    private HomePage clickGo() {
        find(goButton).click();
        return new HomePage(driver);
    }


    private LoginPage typeUserName(String username) {
        find(userNameField).sendKeys(username);
        return this;
    }

    private LoginPage passwordField(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }

    public String getErrorText (){
        return find(registerError).getText();
    }

    public void register(String username, String password) {
        this.visit();
        this.setLanguage();
        this.typeUserName(username);
        this.passwordField(password);
        this.clickGo();
        new HomePage(driver);
    }
}



