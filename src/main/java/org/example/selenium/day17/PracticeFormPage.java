package org.example.selenium.day17;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PracticeFormPage extends BasePage {

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By mobile = By.id("userNumber");
    private By submitButton = By.id("submit");

    public PracticeFormPage(String browser) {
        super(browser);

    }

    public void open(){

        driver.get("https://demoqa.com/automation-practice-form?utm_source=chatgpt.com");
    }

    @Step("输入名字: {name}")
    public void enterFirstName(String name) {
        type(firstName, name);
        Allure.addAttachment("输入了名字1", name);
//        attachText("输入名字", name); // 可以选择性截图
    }

    @Step("输入姓氏: {name}")
    public void enterLastName(String name) {
        type(lastName, name);
        Allure.addAttachment("输入了名字2", name);
    }

    @Step("输入邮箱: {emailStr}")
    public void enterEmail(String emailStr) {
        type(email, emailStr);
    }

    @Step("选择性别: Male")
    public void selectGenderMale() {
        forceClick(genderMale);
    }

    @Step("输入手机号: {mobileNum}")
    public void enterMobile(String mobileNum) {
        type(mobile, mobileNum);
    }

    @Step("点击提交按钮")
    public void clickSubmit() {
        forceClick(submitButton);
    }
}
