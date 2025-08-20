package by.nsv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private final String URL = "https://nsv.by/";
    private final String LINK_PERSONAL_CABINET = "//div[@class='wrap_icon inner-table-block']/a[@data-name='auth']";
    private final String LINK_ACCEPT_COOKIE = "//a[@id='paloma_cookie-accept']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get(URL);
    }

    public void clickAcceptCookie() {
        driver.findElement(By.xpath(LINK_ACCEPT_COOKIE)).click();
    }

    public void clickPersonalCabinet() {
        driver.findElement(By.xpath(LINK_PERSONAL_CABINET)).click();
    }
}
