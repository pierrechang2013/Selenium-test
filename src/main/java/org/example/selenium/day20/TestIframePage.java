package org.example.selenium.day20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/14/2025-6:56 PM
 */
public class TestIframePage extends BaseTest{


    @Test
    public void testIframeContent() {

        IFramePage page = new IFramePage(webDriver);
        page.open();

        page.clickSingleTab();     // ★ 必须点击，否则 iframe 不会加载
        page.switchToIframe();      // ★ 切换 iframe

        String actual = page.getMessage();

        Assertions.assertEquals("iFrame Demo", actual);


    }
}
