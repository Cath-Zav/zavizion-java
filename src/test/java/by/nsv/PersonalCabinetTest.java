package by.nsv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Checking the loading of Personal Cabinet modal window after clicking \"Войти\" icon")
    public void test1() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        Assertions.assertEquals("Личный кабинет", loginPage.getHeadFormTitleText());
    }

    @Test
    @DisplayName("Checking error messages when clicking \"Войти\" with Login and Password fields being empty")
    public void test2() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserLoginPopupError());
        Assertions.assertEquals("Заполните это поле", loginPage.getUserPasswordPopupError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with Password field being empty")
    public void test3() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Weack");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserPasswordPopupError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with Login field being empty")
    public void test4() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysPassword("test12345");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", loginPage.getUserLoginPopupError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with Password < 6 symbols")
    public void test5() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Dow");
        loginPage.sendKeysPassword("1");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Минимум 6 символов", loginPage.getUserPasswordPopupError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with min length(1 symbol) Password")
    public void test6() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Dow");
        loginPage.sendKeysPassword("1");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Минимум 6 символов", loginPage.getUserPasswordPopupError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with max length(50 symbol) Password. Login and Password are not correct")
    public void test7() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Dow");
        loginPage.sendKeysPassword("12345678901234567890123456789012345678901234567890");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Неверный логин или пароль", loginPage.getLoginOrPasswordNotCorrectError());
    }

    @Test
    @DisplayName("Checking error message when clicking \"Войти\" with >max length(51 symbol) Password. Login and Password are not correct")
    public void test8() {
        PersonalCabinetPage loginPage = new PersonalCabinetPage(driver);
        loginPage.sendKeysLogin("John Dow");
        loginPage.sendKeysPassword("123456789012345678901234567890123456789012345678901");
        loginPage.clickButtonLogin();

        Assertions.assertEquals("Неверный логин или пароль", loginPage.getLoginOrPasswordNotCorrectError());
    }
}
