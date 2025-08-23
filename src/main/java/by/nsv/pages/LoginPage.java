package by.nsv.pages;

import by.nsv.webdriver.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    org.openqa.selenium.WebDriver driver;

    private final String HEAD_FORM_TITLE = "//div[@class='form_head']/h2";
    private final String USER_LOGIN_POPUP = "USER_LOGIN_POPUP";
    private final String USER_PASSWORD_POPUP = "USER_PASSWORD_POPUP";
    private final String BUTTON_LOGIN = "Login";
    private final String USER_LOGIN_POPUP_ERROR = "USER_LOGIN_POPUP-error";
    private final String USER_PASSWORD_POPUP_ERROR = "USER_PASSWORD_POPUP-error";
    private final String LOGIN_OR_PASSWORD_ARE_NOT_CORRECT_ERROR = "//div[@class='alert alert-danger']/p";

    public LoginPage() {
        this.driver = WebDriver.getDriver();
    }

    public String getHeadFormTitleText() {
        return WebDriver.getTextFromElement(HEAD_FORM_TITLE);
    }

    public void sendKeysLogin(String login) {
        driver.findElement(By.id(USER_LOGIN_POPUP)).sendKeys(login);
    }

    public void sendKeysPassword(String password) {
        driver.findElement(By.id(USER_PASSWORD_POPUP)).sendKeys(password);
    }

    public void clickButtonLogin() {
        driver.findElement(By.name(BUTTON_LOGIN)).click();
    }

    public String getUserLoginPopupError() {
        return driver.findElement(By.id(USER_LOGIN_POPUP_ERROR)).getText();
    }

    public String getUserPasswordPopupError() {
        return driver.findElement(By.id(USER_PASSWORD_POPUP_ERROR)).getText();
    }

    public String getLoginOrPasswordNotCorrectError() {
        return driver.findElement(By.xpath(LOGIN_OR_PASSWORD_ARE_NOT_CORRECT_ERROR)).getText();
    }
}

