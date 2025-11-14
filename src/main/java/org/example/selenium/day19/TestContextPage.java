package org.example.selenium.day19;

import org.example.selenium.day18.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/10/2025-9:46 AM
 */
public class TestContextPage extends BaseTest {

    @Test
    public void testDoubleClick(){

        ContextPage contextPage = new ContextPage(webDriver);
        contextPage.open();
        contextPage.doubleClick();


        //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals("You selected a context menu",contextPage.alter());


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
