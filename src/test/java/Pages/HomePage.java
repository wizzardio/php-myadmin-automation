package Pages;


import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By headingTitle = xpath("//h2[contains(text(),'Appearance settings')]");
    private By databaseLogo = xpath("//img[@class='icon ic_s_db']");
    private By sqlLogo = xpath("//img[@class='icon ic_b_sql']");
    private By databaseNameInput = xpath("//input[@id='text_create_db']");
    private By createDatabaseButton = xpath("//input[@id='buttonGo']");
    private By databaseTab = By.partialLinkText("Databas");
    private By operationsTab = By.xpath("//div[@id='floating_menubar']//li[7]//a[1]");
    private By dropDatabaseButton = By.xpath("//a[@id='drop_db_anchor']");
    private By confirmDropDatabaseButton = By.xpath("//button[@class='submitOK ui-button ui-corner-all ui-widget']");

    private String databaseByTextSidebar = "//a[@class='hover_show_full' and text()='%s']";
    private String databaseTextMenu = "//td[@class='name']//a[contains(text(),'@s')]";
    private String databaseTextSidebar = "//a[contains(text(),'qa')]";
    private By databaseMenuInput = xpath("//input[@type='text' and @name='table'] ");
    private By menuGoButton = xpath("//fieldset[@class='tblFooters']//input");
    private By columnTableName = xpath("//input[@id='field_0_1']");
    private By columnSaveButton = xpath("//input[@name='do_save_data']");




    public String getHomePageText(String s) {
        return find(headingTitle).getText();
    }

    public Boolean getSqlLogo (){
        return find(sqlLogo).isDisplayed();
    }

    public Boolean getDatabaseLogo (){
        return find(databaseLogo).isDisplayed();
    }

    private HomePage clickDatabaseTab() {
        find(databaseTab).click();
        return this;
    }

    private HomePage confirmDeleteDatabase() {
        find(confirmDropDatabaseButton).click();
        return this;
    }

    private HomePage clickMenuSaveButton() {
        find(columnSaveButton).click();
        return this;
    }
    private HomePage clickDropDatabaseButton() {
        find(dropDatabaseButton).click();
        return this;
    }

    private HomePage clickOperationsButton() {
        find(operationsTab).click();
        return this;
    }

    private HomePage clickMenuDatabaseGoButton() {
        find(menuGoButton).click();
        return this;
    }

    private HomePage typeColumnTableName(String databaseColumnName) {
        find(columnTableName).sendKeys(databaseColumnName);
        return this;
    }

    private HomePage typeDatabaseName(String databaseName) {
        find(databaseNameInput).sendKeys(databaseName);
        return this;
    }

    private HomePage typeMenuTableName(String databaseMenuName) {
        find(databaseMenuInput).sendKeys(databaseMenuName);
        return this;
    }

    private HomePage clickCreateDatabaseButton() {
        find(createDatabaseButton).click();
        return this;
    }

    public boolean isDatabaseVisible(String message){
        return driver.findElements(By.xpath(format(databaseByTextSidebar, message))).size()>0 &&
                driver.findElements(By.xpath(format(databaseByTextSidebar, message))).get(0).isDisplayed();
    }

    public boolean isTableSidebarVisible(String message){
        return driver.findElements(By.xpath(format(databaseTextSidebar, message))).size()>0 &&
                driver.findElements(By.xpath(format(databaseTextSidebar, message))).get(0).isDisplayed();
    }

    public void createNewDatabase(String databaseName) {
        this.clickDatabaseTab();
        this.typeDatabaseName(databaseName);
        this.clickCreateDatabaseButton();
        new HomePage(driver);
    }

    public void createNewTable(String databaseMenuName, String databaseColumnName ) {
        this.typeMenuTableName(databaseMenuName);
        this.clickMenuDatabaseGoButton();
        this.typeColumnTableName(databaseColumnName);
        this.clickMenuSaveButton();
        new HomePage(driver);
    }
}