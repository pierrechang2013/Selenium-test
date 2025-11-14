package org.example.selenium.day17;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/9/2025-10:49 AM
 */
public class FormPage {

    private final WebDriver webDriver;
//    private final By table1Field = By.id("table");

    public FormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://demoqa.com/automation-practice-form?utm_source=chatgpt.com");
    }


}
