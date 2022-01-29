package com.luxoft.page;

import org.openqa.selenium.WebDriver;

public interface SearchPageInterface {
//    SearchPageInterface openPage(WebDriver driver);

    SearchPageInterface typePageQuery(String query);

    SearchResultsPage pressEnter();

    SearchResultsPage pressSearchButton();
}
