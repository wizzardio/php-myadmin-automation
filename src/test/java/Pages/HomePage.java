package Pages;


import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    private By operationsTab = By.xpath("//ul[@id='topmenu']/li/a/img[@title='Operations']");
    private By dropDatabaseButton = By.xpath("//a[@id='drop_db_anchor']");
    private By confirmDropDatabaseButton = By.xpath("//button[@class='submitOK ui-button ui-corner-all ui-widget']");
    private String databaseByTextSidebar = "//a[@class='hover_show_full' and text()='%s']";
    private String databaseTextSidebar = "//a[contains(text(),'%s')]";
    private By databaseMenuInput = xpath("//input[@type='text' and @name='table'] ");
    private By menuGoButton = xpath("//fieldset[@class='tblFooters']//input");
    private By columnTableName = xpath("//input[@id='field_0_1']");
    private By columnSaveButton = xpath("//input[@name='do_save_data']");
    private By successMessageTableCreation = xpath("//div[@class='success']");
    private By sqlTextarea = xpath("//div[@id='sqlquerycontainerfull']/div/div/textarea");
    private By sqlTabGoButton = xpath("//input[@id='button_submit_query']");



    public String getHomePageText(String s) {
        return find(headingTitle).getText();
    }

    public Boolean getSqlLogo (){
        return find(sqlLogo).isDisplayed();
    }

    public Boolean getSQLSuccessMessage (){
        return find(successMessageTableCreation).isDisplayed();
    }

    public Boolean getDatabaseLogo (){
        return find(databaseLogo).isDisplayed();
    }

    private void clickSQLTab() {
        find(sqlLogo).click();
    }

    private void clickDatabaseTab() {
        find(databaseTab).click();
    }

    private void clickSqlTabGoButton() {find(sqlTabGoButton).click();}

    private void confirmDeleteDatabase() {
        find(confirmDropDatabaseButton).click();
    }

    private void clickMenuSaveButton() {
        find(columnSaveButton).click();
    }

    private void clickDropDatabaseButton() {
        find(dropDatabaseButton).click();
    }

    private void clickMenuDatabaseGoButton() {
        find(menuGoButton).click();
    }

    private void typeColumnTableName(String databaseColumnName) {
        find(columnTableName).sendKeys(databaseColumnName);
    }

    private void typeSQLQuery(String sqlQuery) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", find(By.cssSelector(".CodeMirror-line:nth-child(2)")));
        find(sqlTextarea).sendKeys(sqlQuery);
    }

    private void typeDatabaseName(String databaseName) {
        find(databaseNameInput).sendKeys(databaseName);
    }

    private void typeMenuTableName(String databaseMenuName) {
        find(databaseMenuInput).sendKeys(databaseMenuName);
    }

    private void clickCreateDatabaseButton() {
        find(createDatabaseButton).click();
    }

    private void clickOnDatabaseSidebar(String value){
        driver.findElement(By.xpath(format(databaseByTextSidebar, value))).click();
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(operationsTab)).click();
    }

    public boolean isDatabaseVisible(String message){
        return driver.findElements(By.xpath(format(databaseByTextSidebar, message))).size()>0 &&
                driver.findElements(By.xpath(format(databaseByTextSidebar, message))).get(0).isDisplayed();
    }

    public boolean isTableSidebarVisible(String message){
        return driver.findElements(By.xpath(format(databaseTextSidebar, message))).size()>0 &&
                driver.findElements(By.xpath(format(databaseTextSidebar, message))).get(0).isDisplayed();
    }

    public boolean isDatabaseVisibleAfterDeletion(String message){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
        String databaseFindLink = "%s";
        return driver.findElement(By.linkText(format(databaseFindLink, message))).getText().isEmpty();
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

    public void deleteDatabase(String value ) {
        this.clickOnDatabaseSidebar(value);
        this.clickDropDatabaseButton();
        this.confirmDeleteDatabase();
        this.clickDatabaseTab();
        new HomePage(driver);
    }

    public void typeQuery (String value, String sqlQuery) {
        this.clickOnDatabaseSidebar(value);
        this.clickSQLTab();
        this.typeSQLQuery(sqlQuery);
        this.clickSqlTabGoButton();
        new HomePage(driver);
    }
}