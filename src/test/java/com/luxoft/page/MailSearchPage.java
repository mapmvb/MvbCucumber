package com.luxoft.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailSearchPage implements SearchPageInterface {
    static String  url = "https://mail.ru/";
    WebDriver driver;

      @FindBy(id = "q")
    WebElement searchInput;

    @FindBy(id = "search:submit")
    WebElement searchButton;

    private MailSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static MailSearchPage openPage(WebDriver driver) {
        driver.get(url);
        return new MailSearchPage(driver);
    }

    @Override
    public MailSearchPage typePageQuery(String query) {
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
