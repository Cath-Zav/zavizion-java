package by.nsv.pages;

import by.nsv.webdriver.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private final String INPUT_SEARCH = "//input[@id='title-search-input_fixed']";
    private final String BUTTON_SUBSEARCH = "//div[@class='col-md-4 search_wrap']//button[@id='subserch']";
    private final String TITLE_SEARCH_RESULT = "//div[@data-inf='12']//span[@itemprop='name']";
    private final String TITLE_NOTHING_FOUND = "//div[@class='middle']";

    public SearchPage() {
    }

    public void sendKeysSearch(String search) {
        WebDriver.sendKeys(INPUT_SEARCH, search);
    }

    public void startSearch() {
        WebDriver.clickElement(BUTTON_SUBSEARCH);
    }

    public String getSearchResultFirstItemTitleText() {
        return WebDriver.getTextFromElement(TITLE_SEARCH_RESULT);
    }

    public List<String> getSearchResultItemsTitleText() {
       List<WebElement> listOfSearchResultElements = WebDriver.findElements(TITLE_SEARCH_RESULT);
       List<String> listOfSearchResultTitles = new ArrayList<>();

       for(WebElement element : listOfSearchResultElements) {
           listOfSearchResultTitles.add(element.getText().toLowerCase());
       }
       return listOfSearchResultTitles;
    }

    public String getTitleNothingFound() {
        return WebDriver.findElement(TITLE_NOTHING_FOUND).getText().trim();
    }
}
