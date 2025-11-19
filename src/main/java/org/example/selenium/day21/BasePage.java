package org.example.selenium.day21;


import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.ByteArrayInputStream;
import java.time.Duration;


public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(String browserName) {
        this.driver = DriverManager.getDriver(browserName);
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }


   //灵活控制时间
    protected WebElement waitForVisible(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForVisible(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement ele = waitForVisible(locator);
        ele.clear();
        ele.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    protected void forceClick(By locator) {
        try {
            waitForVisible(locator).click();
        } catch (Exception e) {
            // 处理 iframe 遮挡问题
            WebElement ele = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);




        }
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // 等待元素可点击，自定义超时
    protected WebElement waitForClickable(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // 等待元素消失
    protected boolean waitForInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // 等待元素消失，自定义超时
    protected boolean waitForInvisible(By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void takeScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }
}