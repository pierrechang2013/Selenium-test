package org.example.selenium.day17;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
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
//        attachScreenshotOnFailure(); // 每次测试后执行
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

    public void attachScreenshotOnFailure() {
        if (webDriver != null) {
            try {
                // 截图
                byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                // 添加到 Allure 报告
                Allure.addAttachment("失败截图", new ByteArrayInputStream(screenshot));
            } catch (WebDriverException e) {
                System.err.println("截图失败: " + e.getMessage());
            }
        }
    }
}
