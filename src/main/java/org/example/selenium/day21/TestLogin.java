package org.example.selenium.day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogin extends BaseTest{

    @Test
    public void testLoginChrome(){

        LoginPage loginPage = new LoginPage("chrome");
        loginPage.enterUsername("");
        loginPage.enterPwd("");
        loginPage.clickLoginButton();
        Assertions.assertEquals("","");


    }

    @Test
    public void testLoginFireFox(){

        LoginPage loginPage = new LoginPage("firefox");
        loginPage.enterUsername("");
        loginPage.enterPwd("");
        loginPage.clickLoginButton();
        Assertions.assertEquals("","");


    }
}
