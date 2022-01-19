package com.luxoft.steps;

import com.luxoft.Calc;
import com.luxoft.page.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyStepDefsWeb {
    private MainPage mainPage = new MainPage(Auxillary.driver);

    @Given("I enter {string} to the field {string}")
    public void iEnterToTheField(String arg0, String arg1) {
        mainPage.setFieldValue(arg1, arg0);
    }

    @When("I press button {string}")
    public void iPressButton(String arg0) {
        mainPage.clickButton(arg0);
    }

//    @Then("I see button {string}")
//    public void iSeeButton(String arg0) {
//        mainPage.checkElementDiisplayed(arg0,true);
//    }

    @Then("^(?:Button|Field|Element) \"([^\"]*)\" (is displayed|is not displayed)$")
    public void buttonIsDisplayed(String arg0, String arg1) {
        mainPage.checkElementDiisplayed(arg0, arg1.equalsIgnoreCase("is displayed"));

    }
}



