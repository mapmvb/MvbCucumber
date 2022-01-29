package com.luxoft.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexSearchPage implements SearchPageInterface {
    static String  url = "https://yandex.ru/";
    WebDriver driver;

      @FindBy(id = "text")
    WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    private YandexSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static YandexSearchPage openPage(WebDriver driver) {
        driver.get(url);
        return new YandexSearchPage(driver);
    }

    @Override
    public YandexSearchPage typePageQuery(String query) {
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
