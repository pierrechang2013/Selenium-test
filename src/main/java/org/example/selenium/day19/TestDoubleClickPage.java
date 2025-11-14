package org.example.selenium.day19;

import org.example.selenium.day18.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/12/2025-3:59 PM
 */
public class TestDoubleClickPage extends BaseTest {

    @Test
    public void testDoubleClick(){

        DoubleClickPage doubleClickPage = new DoubleClickPage(webDriver);
        doubleClickPage.open();
        doubleClickPage.doubleClick();
        Alert alter  = getWait().until(ExpectedConditions.alertIsPresent());

        Assertions.assertEquals("You double clicked me.. Thank You..",alter.getText());
        alter.accept();
        webDriver.switchTo().defaultContent();

    }
}
