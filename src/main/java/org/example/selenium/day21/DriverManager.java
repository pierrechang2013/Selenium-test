package org.example.selenium.day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManage {
    private final static ThreadLocal<WebDriver> drivers   = new ThreadLocal<>();
    public static void init() {

        drivers.set(new ChromeDriver());
        drivers.get().manage().window().maximize();

    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void quitDriver() {
        if(drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
        }

    }
}
