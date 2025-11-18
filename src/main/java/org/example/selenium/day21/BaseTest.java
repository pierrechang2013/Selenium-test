package org.example.selenium.day21;


import org.junit.jupiter.api.*;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        DriverManager.init();

    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}