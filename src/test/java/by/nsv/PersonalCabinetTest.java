package by.nsv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonalCabinetTest extends BaseTest {

    @BeforeEach
    public void openHomePageClickAcceptCookie() {
        HomePage homePage = new HomePage(driver);
        homePage.openSite();
        homePage.clickAcceptCookie();
        homePage.clickPersonalCabinet();
    }

    @Test
    public void loginTitleTest() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        Assertions.assertEquals("Личный кабинет", loginPage.getHeadFormTitleText());
    }

    @Test
    public void test2() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserLoginPopupError());
        Assertions.assertEquals("Заполните это поле", loginPage.getUserPasswordPopupError());
    }

    @Test
    public void test3() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Weack");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserPasswordPopupError());
    }

    @Test
    public void test4() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysPassword("test12345");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserLoginPopupError());
    }
}
