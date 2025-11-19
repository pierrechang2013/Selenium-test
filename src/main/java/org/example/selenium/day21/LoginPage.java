package org.example.selenium.day21;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By submitBnt = By.id("submitLogin");
    public void clickLoginButton(){
        this.click(submitBnt);
    }

    public LoginPage(String browser) {
        super(browser);

    }

    public void enterUsername(String username){

        this.type(userName, username);
    }

    public void enterPwd(String pwd){

        this.type(password, pwd);
    }


}
