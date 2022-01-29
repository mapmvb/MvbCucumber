package com.luxoft.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchPage implements SearchPageInterface {
    static String  url = "https://yahoo.com/";
    WebDriver driver;

      @FindBy(name = "p")
    WebElement searchInput;

    @FindBy(id = "ybar-search")
    WebElement searchButton;

    private YahooSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static YahooSearchPage openPage(WebDriver driver) {
        driver.get(url);
        return new YahooSearchPage(driver);
    }

    @Override
    public YahooSearchPage typePageQuery(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        return this;
    }

    @Override
    public SearchResultsPage pressEnter() {
        searchInput.sendKeys("\n");
        return new SearchResultsPage(driver);
    }

    @Override
    public SearchResultsPage pressSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
