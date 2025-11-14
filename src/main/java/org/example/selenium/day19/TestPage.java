package org.example.selenium.day19;

import org.example.selenium.day18.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/10/2025-9:46 AM
 */
public class TestPage extends BaseTest {

    @Test
    public void testHoverAndClick(){

        Page page = new Page(webDriver);
        page.open();
        List<WebElement> avatars =  page.getAvatars();
        List<WebElement> texts =  page.getTexts();
        List<WebElement> hrefs = page.getHrefs();
        for(int i = 0;i<avatars.size();i++){

            page.hoverAvatar(avatars.get(i));

            Assertions.assertEquals("name: user"+(i+1),page.getText(texts.get(i)));

            WebElement webElement = getWait().until(ExpectedConditions.elementToBeClickable(hrefs.get(i)));
            page.clickHref(webElement);

            getWait().until(ExpectedConditions.urlContains("users"));

            String url = webDriver.getCurrentUrl();

            Assertions.assertTrue(url.endsWith(String.valueOf(i+1)));


            webDriver.navigate().back();

        }
    }
//    @Test
//    public void testClick(){
//
//        Page page = new Page(webDriver);
//        page.open();
//        List<WebElement> avatars =  page.getAvatars();
//        List<WebElement> texts =  page.getTexts();
//        for(int i = 0;i<avatars.size();i++){
//
//            page.hoverAvatar(avatars.get(i));
//
//            Assertions.assertEquals("name: user"+(i+1),page.getText(texts.get(i)));
//        }
//    }

}
