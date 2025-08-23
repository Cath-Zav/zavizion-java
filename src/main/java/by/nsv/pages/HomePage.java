package by.nsv.pages;

import by.nsv.webdriver.WebDriver;

public class HomePage {

    private final String URL = "https://nsv.by/";
    private final String LINK_PERSONAL_CABINET = "//div[@class='wrap_icon inner-table-block']/a[@data-name='auth']";
    private final String LINK_ACCEPT_COOKIE = "//a[@id='paloma_cookie-accept']";
    private final String CLOSE_BUTTON_BANNER = "//div[@class='modal_game_width_close']";

    public HomePage() {
    }

    public void openSite() {
       // driver.getDriver().get(URL);
        WebDriver.getDriver().get(URL);
    }

    public HomePage clickAcceptCookie() {
        //driver.findElement(By.xpath(LINK_ACCEPT_COOKIE)).click();
        WebDriver.clickElement(LINK_ACCEPT_COOKIE);
        return this;
    }

    public void clickPersonalCabinet() {
        WebDriver.clickElement(LINK_PERSONAL_CABINET);
    }

    public HomePage clickCloseGameBanner() {
        try {
            WebDriver.findElement(CLOSE_BUTTON_BANNER).click();
        } catch(Exception e) {
            System.out.println("Баннера не было, баннер не закрылся");
        }
        return this;
    }
}
