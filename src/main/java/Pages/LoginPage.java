package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    //public LoginPage(WebDriver driver) {
   //     this.driver = driver;
   // }

    private By goButton = By.xpath("//input[@id='input_go']");
    private By userNameField = By.xpath("//input[@id='input_username']");
    private By passwordField = By.xpath("//input[@id='input_password']");
    private By selectLanguage = By.xpath("//select[@id='sel-lang']");
    private By selectEnglish = By.xpath("(//option[contains(text(),'English')])[1]");

    public LoginPage setLanguage (){
       driver.findElement(selectLanguage).click();
       driver.findElement(selectEnglish).click();
       return this;
    }

    public HomePage clickGo () {
        driver.findElement(goButton).click();
        return new HomePage(driver);
    }


   public LoginPage typeUserName (String username) {
       driver.findElement(userNameField).sendKeys(username);
       return this;
    }

    public LoginPage passwordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomePage register (String username, String password){
        this.setLanguage();
        this.typeUserName(username);
        this.passwordField(password);
        this.clickGo();
        return new HomePage(driver);
   }

   // ініціалізувати в констукторі вебдрайвер//
    // driver factory
  // navigation separately




}
