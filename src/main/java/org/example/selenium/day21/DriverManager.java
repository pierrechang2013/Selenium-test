package org.example.selenium.day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private final static ThreadLocal<Map<String, WebDriver>> drivers =
            ThreadLocal.withInitial(HashMap::new);
//
//    private final static ThreadLocal<WebDriver> driver =
//            ThreadLocal.withInitial(() -> null);


    public static void init(String browserName) {
        Map<String, WebDriver> map = drivers.get();
        String key = browserName.toLowerCase();

        if (!map.containsKey(key)) {
            WebDriver driver;
            switch (key) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Browser not supported: " + browserName);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

            map.put(key, driver);

        }
    }

    public static WebDriver getDriver(String browserName) {

        init(browserName);

        return drivers.get().get(browserName);

    }

    public static void quitDriver(String browserName) {
        if (drivers.get() != null &&
                drivers.get().get(browserName.toLowerCase()) != null) {

            drivers.get().get(browserName.toLowerCase()).quit();
            drivers.get().remove(browserName);
        }

    }

    public static void clearAll() {
        Map<String, WebDriver> map = drivers.get();
        if (map != null) {
            // 先关闭所有 driver
            for (WebDriver driver : map.values()) {
                if (driver != null) {
                    driver.quit();//逐个退出
                }
            }
            map.clear();       // 清空 Map
        }
        drivers.remove();      // 清理 ThreadLocal
    }

}
