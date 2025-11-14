package org.example.selenium.day18;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/9/2025-10:49 AM
 */
public class FormPage {

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public By getFirstNameField() {
        return firstNameField;
    }

    public By getLastNameField() {
        return lastNameField;
    }

    public By getUserEmailField() {
        return userEmailField;
    }

    public By getGenderradioField1() {
        return genderradioField1;
    }

    public By getGenderradioField2() {
        return genderradioField2;
    }

    public By getGenderradioField3() {
        return genderradioField3;
    }

    public By getUserNumberField() {
        return userNumberField;
    }

    public By getDateOfBirthField() {
        return dateOfBirthField;
    }

    public By getSubjectsField() {
        return subjectsField;
    }

    public By getUploadPictureField() {
        return uploadPictureField;
    }

    public By getCurrentAddressField() {
        return currentAddressField;
    }

    public By getSelectStateField() {
        return selectStateField;
    }

    public By getSelectCityField() {
        return selectCityField;
    }

    private final WebDriver webDriver;
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");

    private final By userEmailField = By.id("userEmail");


    //private final By genderradioField1 = By.id("gender-radio-1");
    private final By genderradioField1 = By.cssSelector("label[for='gender-radio-1']");

    private final By genderradioField2 = By.id("gender-radio-2");
    private final By genderradioField3 = By.id("gender-radio-3");

    private final By userNumberField = By.id("userNumber");

    private final By dateOfBirthField = By.id("dateOfBirthInput");

    private final By subjectsField = By.id("subjectsInput");

    private final By uploadPictureField = By.id("uploadPicture");
    private final By currentAddressField = By.id("currentAddress");

    private final By selectStateField = By.id("react-select-3-input");

    private final By selectCityField = By.id("react-select-4-input");

    private final By submitBtnField = By.id("submit");

    public By getDialogTableField() {
        return dialogTableField;
    }

    //dialog还没写
    private final By dialogTableField = By.cssSelector("table.table.table-dark.table-striped." +
            "table-bordered.table-hover");

    public By getRowsField() {
        return rowsField;
    }

    private final By rowsField = By.xpath("//tbody/tr");


    public FormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://demoqa.com/automation-practice-form?utm_source=chatgpt.com");
    }

    public void inputLastName(String lastName){
        webDriver.findElement(firstNameField).sendKeys(lastName);
    }

    public void inputFirstName(String lastName){
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputUserEmail(String userEmail){
        webDriver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void inputPhoNum(String phoNum){
        webDriver.findElement(userNumberField).sendKeys(phoNum);
    }

    public String selectRadio1(){
        webDriver.findElement(genderradioField1).click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(genderradioField1));

        return webDriver.findElement(genderradioField1).getText();
    }

    public String selectRadio2(){
        return webDriver.findElement(genderradioField2).getAttribute("value");
    }
    public String selectRadio3(){
        return webDriver.findElement(genderradioField3).getAttribute("value");
    }

    public void selectDate(String date){
        webDriver.findElement(dateOfBirthField).sendKeys(date);
    }

    public void inputSubject(String subject){
        webDriver.findElement(subjectsField).sendKeys(subject);
    }

    public void uploadPic(String file){
        webDriver.findElement(uploadPictureField).sendKeys(file);
    }

    public void  inputState(String state){
        WebElement input = webDriver.findElement(this.selectStateField);

        // 滚动到元素可见
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", input);

        // JS 强制点击 input
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", input);

        // 清空并输入文字
        input.clear();
        input.sendKeys(state);

        // 等待下拉选项出现并点击
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        By optionLocator = By.xpath("//div[contains(@class,'subjects-auto-complete__option') and text()='" + state + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        
        // JS 点击下拉选项，避免遮挡
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", option);
    }

    public void inputCity(String city){
        WebElement input = webDriver.findElement(this.selectCityField);

        // 滚动到元素可见
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", input);

        // JS 强制点击 input
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", input);

        // 清空并输入文字
        input.clear();
        input.sendKeys(city);

        // 等待下拉选项出现并点击
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        By optionLocator = By.xpath("//div[contains(@class,'subjects-auto-complete__option') and text()='" + city + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        // JS 点击下拉选项，避免遮挡
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", option);
    }

    public void clickSubmitBtn(){
        WebElement element = webDriver.findElement(submitBtnField);
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
        }
    }


}
