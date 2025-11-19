package org.example.selenium.day21;


import org.junit.jupiter.api.*;

public class BaseTest {

    protected final String[] browsers = {"chrome", "firefox"};


    @BeforeEach
    public void setUp() {
        for (String browser : browsers) {
            DriverManager.init(browser); // 初始化每个浏览器 driver
        }

    }

    @AfterEach
    public void clean() {
        for (String browser : browsers) {
            DriverManager.quitDriver(browser); // 退出每个浏览器 driver
        }
    }

    @AfterAll
    public static void cleanThreadLocal() {
        DriverManager.clearAll(); // 调用 DriverManager 提供的静态方法
    }
}