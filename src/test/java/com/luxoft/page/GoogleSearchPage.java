package com.luxoft.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage implements SearchPageInterface {
    static String  url = "https://google.com/";
    WebDriver driver;

      @FindBy(name = "q")
    WebElement searchInput;

    @FindBy(xpath = "//input[@value='Мне повезёт!']")
    WebElement searchButton;

    private GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static GoogleSearchPage openPage(WebDriver driver) {
        driver.get(url);
        return new GoogleSearchPage(driver);
    }

    @Override
    public GoogleSearchPage typePageQuery(String query) {
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
