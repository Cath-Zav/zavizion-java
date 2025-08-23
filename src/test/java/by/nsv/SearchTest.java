package by.nsv;

import by.nsv.pages.HomePage;
import by.nsv.pages.SearchPage;
import by.nsv.webdriver.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    @BeforeEach
    public void openHomePageClickAcceptCookie() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickCloseGameBanner()
                .clickAcceptCookie();
    }

    @Test
    @DisplayName("Checking if the list of the results contains the specific product \"ЖК телевизор Artel UA32H3200\"")
    public void test1() {
        SearchPage searchPage = new SearchPage();
        searchPage.sendKeysSearch("ЖК телевизор Artel UA32H3200");
        searchPage.startSearch();

        Assertions.assertEquals("ЖК телевизор Artel UA32H3200", searchPage.getSearchResultFirstItemTitleText());
    }

    @Test
    @DisplayName("Checking if the list of the results contains \"мотоцикл\"")
    public void test2() {
        SearchPage searchPage = new SearchPage();
        searchPage.sendKeysSearch("мотоцикл");
        searchPage.startSearch();

        for(String elementTitle : searchPage.getSearchResultItemsTitleText()) {
            Assertions.assertTrue(elementTitle.contains("мотоцикл"), "Результат, не содержащий искомое слово: " + elementTitle);
        }
    }

    @Test
    @DisplayName("Checking No Result page")
    public void test3() {
        SearchPage searchPage = new SearchPage();
        searchPage.sendKeysSearch("dfdgdfgf");
        searchPage.startSearch();

        Assertions.assertEquals("Сожалеем, но ничего не найдено.", searchPage.getTitleNothingFound());
    }
}
