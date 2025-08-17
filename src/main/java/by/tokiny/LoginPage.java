package by.tokiny;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    private final String URL = "https://tokiny.by/";
    private final String LINK_TO_PERSONAL_ACCOUNT = "//a[@href='#account']";
    private final String PERSONAL_ACCOUNT_HEADING = "//div[@class='reg-heading']";

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void goToHomePage() {
       driver.get(URL);
    }

    public void clickLinkAccount() {
        driver.findElement(By.xpath(LINK_TO_PERSONAL_ACCOUNT)).click();
    }

    public void waitForAccountFormTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PERSONAL_ACCOUNT_HEADING)));
    }

    public String getTitleAccountForm() {
        WebElement titleAccountForm = driver.findElement(By.xpath(PERSONAL_ACCOUNT_HEADING));
        return titleAccountForm.getText();
    }
}
