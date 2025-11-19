package org.example.selenium.day20;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Author:Liang
 * Descprtion:
 * Time:11/14/2025-6:22 PM
 */
public abstract class BaseTest {

    protected WebDriver webDriver;
//    protected WebDriverWait wait;

    @BeforeAll
    public static void setAll(){


    }

    @BeforeEach
    public void set(){

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @AfterEach
    public void clean(){

        if(webDriver!=null){
            webDriver.quit();
        }
    }

    @AfterAll
    public static void finish(){

        System.out.println("本page测试完成");
    }

//    public WebDriverWait getWait(){
//        wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
//        return wait;
//
//    }
}
