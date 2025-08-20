package by.nsv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinetPage {
    WebDriver driver;

    private final String HEAD_FORM_TITLE = "//div[@class='form_head']/h2";
    private final String USER_LOGIN_POPUP = "USER_LOGIN_POPUP";
    private final String USER_PASSWORD_POPUP = "USER_PASSWORD_POPUP";
    private final String BUTTON_LOGIN = "Login";
    private final String USER_LOGIN_POPUP_ERROR = "USER_LOGIN_POPUP-error";
    private final String USER_PASSWORD_POPUP_ERROR = "USER_PASSWORD_POPUP-error";
    private final String LOGIN_OR_PASSWORD_ARE_NOT_CORRECT_ERROR = "//div[@class='alert alert-danger']/p";

    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadFormTitleText() {
        return driver.findElement(By.xpath(HEAD_FORM_TITLE)).getText();
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

