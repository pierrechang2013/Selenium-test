package org.example.selenium.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//@ExtendWith(AllureTestWatcher.class)
public class TestPracticeForm extends BaseTest {

    @Test
    public void testFillPracticeFormChrome() {


        try {
            PracticeFormPage formPage = new PracticeFormPage("chrome");

            formPage.open();
            formPage.enterFirstName("John");
            formPage.enterLastName("Doe");
            formPage.enterEmail("john.doe@example.com");
            formPage.selectGenderMale();
            formPage.enterMobile("1234567890");
            formPage.clickSubmit();

            // 断言：提交后应该出现一个确认对话框或页面某个元素
            // DemoQA 的 Practice Form 提交后会弹出一个 modal，假设你有 locator
            By thanksModal = By.id("example-modal-sizes-title-lg"); // 仅示例
            Assertions.assertTrue(formPage.waitForVisible(thanksModal, 5).isDisplayed());
        } catch (Exception e) {
            attachScreenshotOnFailure(); // ✅ 只失败时截图

            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFillPracticeFormFirefox() {
        try {
            PracticeFormPage formPage = new PracticeFormPage("firefox");
            formPage.enterFirstName("Alice");
            formPage.enterLastName("Smith");
            formPage.enterEmail("alice.smith@example.com");
            formPage.selectGenderMale();
            formPage.enterMobile("0987654321");
            formPage.clickSubmit();

            By thanksModal = By.id("example-modal-sizes-title-lg");
            Assertions.assertTrue(formPage.waitForVisible(thanksModal, 5).isDisplayed());
        } catch (Exception e) {
            attachScreenshotOnFailure();
            throw new RuntimeException(e);
        } {

        }
    }
}