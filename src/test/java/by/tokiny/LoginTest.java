package by.tokiny;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToHomePage();
        loginPage.clickLinkAccount();
        loginPage.waitForAccountFormTitle();

        Assertions.assertEquals("Авторизация", loginPage.getTitleAccountForm());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
