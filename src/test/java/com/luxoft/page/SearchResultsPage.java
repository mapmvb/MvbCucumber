package com.luxoft.page;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchTitle(){
        return driver.getTitle();
    }
}
