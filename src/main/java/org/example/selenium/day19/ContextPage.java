package org.example.selenium.day19;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/10/2025-10:47 AM
 */
public class ContextPage {

    private final WebDriver webDriver;
    private final By contextField = By.id("hot-spot");

    public ContextPage(WebDriver webDriver){
        this.webDriver = webDriver;

    }

    public void open(){

        webDriver.get("" +
                "https://the-internet.herokuapp.com/context_menu?utm_source=chatgpt.com");
    }

    public void doubleClick(){
        WebElement webElement = webDriver.findElement(contextField);
        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement).perform();
    }

    public String  alter(){
         Alert alert = webDriver.switchTo().alert();
         String text = alert.getText();

         alert.accept();

         return text;
    }

}
