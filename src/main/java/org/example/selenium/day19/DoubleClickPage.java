package org.example.selenium.day19;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/12/2025-3:50 PM
 */
public class DoubleClickPage {

    private final WebDriver webDriver;
    private final By doubleClickBntField = By.xpath("//button[text()='Double-Click Me To See Alert']");

    public DoubleClickPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public void open(){

        webDriver.get("https://demo.guru99.com/test/simple_context_menu.html");
    }

    public void doubleClick(){

        WebElement webElement = webDriver.findElement(doubleClickBntField);
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webElement).perform();

    }
}
