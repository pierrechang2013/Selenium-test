package org.example.selenium.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Author:Liang
 * Descprtion:因为测试页面没有对应编辑和删除功能，只是测试了表格中元素的定位
 * Time:11/9/2025-11:08 AM
 */
public class TestFormPage extends BaseTest {


    @ParameterizedTest
    @CsvSource({
            "John,Smith",
            "Jane,Doe",
            "Tom,Lee"
    })
    public void testModelDriver(String firstName, String lastName) {//数据驱动


        System.out.println("First Name: " + firstName + ", Last Name: " + lastName);

        // 简单断言示例：名字不为空
        Assertions.assertTrue(!firstName.isEmpty() && !lastName.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "John,Smith,18,true",
            "Jane,Doe,190,true",
            "Tom,Lee,100,true"
    })
    public void testModelDriverMutiType(String firstName, String lastName, int age, boolean active) {//数据驱动


        System.out.println(firstName + " " + lastName + ", Age: " + age + ", Active: " + active);

        // 简单断言示例：年龄 > 0
        Assertions.assertTrue(age > 0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/info.csv", numLinesToSkip = 1)
    public void testModelDriverByCvs(String firstName, String lastName,
                                     int age, String email, String gender, String phoneNum,
                                     String date, String subject, String file, String address, String state, String city) {//数据驱动
//John,Smith,23,erwr@gmail.com,Male,1234567890,09 Dec 3000,SSSSS,file1,Rue xxxx,Uttar Pradesh,Lucknow
        FormPage formPage = new FormPage(webDriver);
        System.out.println(firstName + " " + lastName + ", Age: " + age + ", subject: " + subject);
        formPage.open();
        formPage.inputFirstName(firstName);
        formPage.inputLastName(lastName);
        formPage.inputUserEmail(email);
        String radio = formPage.selectRadio1();
        formPage.selectDate(date);
        formPage.inputPhoNum(phoneNum);
        formPage.inputSubject(subject);
        formPage.uploadPic(file);
        formPage.inputState(state);

        formPage.inputCity(city);
        formPage.clickSubmitBtn();

        WebElement webElement =
                getWait().
                        until(ExpectedConditions.
                                visibilityOfElementLocated(formPage.getDialogTableField()));

        List<WebElement> list =  webElement.findElements(formPage.getRowsField());
        for(WebElement w:list){
            List<WebElement> cells = w.findElements(By.tagName("td"));

                if(cells.get(0).getText().equalsIgnoreCase("Student Name")){
                    Assertions.assertEquals(cells.get(1),"John Smith");

                }else if(cells.get(0).getText().equalsIgnoreCase("Student Email")){
                    Assertions.assertEquals(cells.get(1),"erwr@gmail.com");
                }

        }
        // 简单断言示例：年龄 > 0
//        Assertions.assertTrue(age > 0);


    }
}
