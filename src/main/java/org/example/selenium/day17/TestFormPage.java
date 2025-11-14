package org.example.selenium.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author:Liang
 * Descprtion:因为测试页面没有对应编辑和删除功能，只是测试了表格中元素的定位
 * Time:11/9/2025-11:08 AM
 */
public class TestFormPage {






    @ParameterizedTest
    @CsvSource({
            "John,Smith",
            "Jane,Doe",
            "Tom,Lee"
    })
    public void testModelDriver(String firstName,String lastName) {//数据驱动


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
    @CsvFileSource(resources = "/person.csv",numLinesToSkip=1)
    public void testModelDriverByCvs(String firstName, String lastName,
                                     int age, boolean active) {//数据驱动


        System.out.println(firstName + " " + lastName + ", Age: " + age + ", Active: " + active);

        // 简单断言示例：年龄 > 0
        Assertions.assertTrue(age > 0);
    }
}
