package org.example.selenium.day20;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/14/2025-6:28 PM
 */
public class IFramePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By singleTab = By.linkText("Single Iframe");
    private final By iframeField = By.id("singleframe");


    //    private final By msgField = By.tagName("h5");
    private final By msgField = By.xpath("//html/body/section/div/h5");

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://demo.automationtesting.in/Frames.html?utm_source=chatgpt.com");
    }

    // 点击 tab，让 iframe 可见
    public void clickSingleTab() {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("aswift_6")));
        //强制点击
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(singleTab));
        //driver.findElement(singleTab).click();
    }

    // 切换到 iframe
    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeField));
        driver.switchTo().frame(iframe);
    }

    // 获取 h5 文本
    public String getMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msgField)).getText();
    }
}
