package org.example.selenium.day19;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/8/2025-10:41 PM
 */
public class BaseTest {


    protected WebDriver webDriver;
    protected WebDriverWait wait;
    @BeforeAll
    public static void setAll(){

    }

    @BeforeEach
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//停止隐式等待

    }

    @AfterEach
    public void finish(){
        if(webDriver!=null)
        webDriver.quit();
    }

    @AfterAll
    public static void clean(){

    }

    public WebDriverWait getWait(){
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        return wait;

    }
}
