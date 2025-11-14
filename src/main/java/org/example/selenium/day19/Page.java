package org.example.selenium.day19;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/10/2025-9:25 AM
 */
public class Page {

    private final WebDriver webDriver;
    private final By avatarFields = By.xpath("//div[@class='figure']/img[@src='/img/avatar-blank.jpg']");
    private final By textFields = By.xpath("//div[@class='figure']/div[@class='figcaption']/h5");

    private final By hrefFields = By.xpath("//div[@class='figure']/div[@class='figcaption']/a");

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;

    }

    public void open(){

        webDriver.get("https://the-internet.herokuapp.com/hovers");
    }

    public List<WebElement> getAvatars(){


        List<WebElement> hovers = webDriver.findElements(avatarFields);
        return hovers;
    }

    public List<WebElement> getTexts(){


        List<WebElement> texts = webDriver.findElements(textFields);
        return texts;
    }

    public List<WebElement> getHrefs(){


        List<WebElement> hrefs = webDriver.findElements(hrefFields);
        return hrefs;
    }

    public void hoverAvatar(WebElement webElement){

        Actions action = new Actions(webDriver);

        action.moveToElement(webElement).perform();

    }

    public String getText(WebElement webElement){
        return webElement.getText();

    }

    public void  clickHref(WebElement webElement){
        Actions action = new Actions(webDriver);
        action.click(webElement).perform();


    }
}
