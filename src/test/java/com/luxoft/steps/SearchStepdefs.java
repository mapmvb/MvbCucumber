package com.luxoft.steps;

import com.luxoft.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SearchStepdefs {
    SearchPageInterface searchPage;
    SearchResultsPage searchResultsPage;

    @Given("^open (Yandex|Google|Mail|Yahoo) page$")
    public void openYandexPage(String name) {
        switch (name) {
            case "Yandex": searchPage = YandexSearchPage.openPage(Auxillary.driver); break;
            case "Google": searchPage = GoogleSearchPage.openPage(Auxillary.driver); break;
            case "Mail": searchPage = MailSearchPage.openPage(Auxillary.driver); break;
            case "Yahoo": searchPage = YahooSearchPage.openPage(Auxillary.driver); break;
        }
    }

    @When("I type {string} in search field")
    public void iTypeInSearchField(String arg0) {
        searchPage.typePageQuery(arg0);
    }

    @And("I press enter")
    public void iPressEnter() {
        searchResultsPage = searchPage.pressEnter();
    }

    @Then("I can see title contains {string}")
    public void iCanSeeTitleContains(String arg0) {
        System.out.println("Assertion for:"+arg0+"; In title="+searchResultsPage.getSearchTitle()+";");
        Assertions.assertTrue(searchResultsPage.getSearchTitle().contains(arg0));
    }

    @And("I press search button")
    public void iPressSearchButton() {
        searchResultsPage= searchPage.pressSearchButton();
    }
}
